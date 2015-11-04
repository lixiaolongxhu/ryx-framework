package com.framework.core.cache;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

/**memCache缓存客户端操作.
 * @author lixiaolong
 * @version datetime：2015年11月4日  下午4:37:26
 */
public class MemCache {
	/**日志.
	 * 
	 */
	private static Logger log = LoggerFactory.getLogger(MemCache.class);

	/**缓存key值集合.
	 * 
	 */
	private Set<String> keySet = new HashSet<String>();
	
	/**保存的缓存名,对应spring cache 中 @Cacheable、@CachePut、@CacheEvict等的name属性值.
	 * 
	 */
	private final String cacheName;
	
	/**缓存过期时间，单位秒,默认是1小时,不超过30天.
     * 
	 */
	private final int expire;
	
	/**xmemcached缓存对象客户端.
	 * 
	 */
	private final MemcachedClient memcachedClient;

	/**构造函数.
	 * 
	 * @param cacheName 缓存名 对应spring cache 中 @Cacheable、@CachePut、@CacheEvict等的name属性值
	 * @param expire  缓存过期时间
	 * @param memcachedClient xmemcache缓存对象
	 */
	public MemCache(String cacheName, int expire, MemcachedClient memcachedClient) {
		this.cacheName = cacheName;
		this.expire = expire;
		this.memcachedClient = memcachedClient;
	}

	/**根据缓存key值获取缓存对象.
	 * 
	 * @param key  缓存key值
	 * @return 返回根据key获取的缓存对象
	 */
	public Object get(String key) {
		Object value = null;
		try {
			key = this.getKey(key);
			value = memcachedClient.get(key);
		} catch (TimeoutException e) {
			log.warn("获取 Memcached 缓存超时", e);
		} catch (InterruptedException e) {
			log.warn("获取 Memcached 缓存被中断", e);
		} catch (MemcachedException e) {
			log.warn("获取 Memcached 缓存错误", e);
		}
		return value;
	}

	/**缓存保存.
	 * 
	 * @param key  缓存key值
	 * @param value  缓存内容
	 */
	public void put(String key, Object value) {
		if (value == null) {
			return;
		}
		try {
			key = this.getKey(key);
			memcachedClient.setWithNoReply(key, expire, value);
			keySet.add(key);
		} catch (InterruptedException e) {
			log.warn("更新 Memcached 缓存被中断", e);
		} catch (MemcachedException e) {
			log.warn("更新 Memcached 缓存错误", e);
		}
	}

	/**删除清空所有缓存.
	 * 
	 */
	public void clear() {
		for (String key : keySet) {
			try {
				memcachedClient.deleteWithNoReply(this.getKey(key));
			} catch (InterruptedException e) {
				log.warn("删除 Memcached 缓存被中断", e);
			} catch (MemcachedException e) {
				log.warn("删除 Memcached 缓存错误", e);
			}
		}
	}

	/**根据key值删除缓存.
	 *    
	 * @param key  缓存key值
	 */
	public void delete(String key) {
		try {
			key = this.getKey(key);
			memcachedClient.deleteWithNoReply(key);
		} catch (InterruptedException e) {
			log.warn("删除 Memcached 缓存被中断", e);
		} catch (MemcachedException e) {
			log.warn("删除 Memcached 缓存错误", e);
		}
	}

	/**获取缓存名+key值.
	 * 
	 * @param key  key值
	 * @return 返回缓存名+key值
	 */
	private String getKey(String key) {
		return cacheName + "_" + key;
	}
}
