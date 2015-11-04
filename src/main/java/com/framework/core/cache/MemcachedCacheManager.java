package com.framework.core.cache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.rubyeye.xmemcached.MemcachedClient;

import org.springframework.cache.Cache;
import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;


/**缓存管理，实现重写spring cache缓存管理的抽象类.
 * @author lixiaolong
 * @version datetime：2015年11月4日  下午5:17:44
 */
public class MemcachedCacheManager extends AbstractTransactionSupportingCacheManager{

	/**缓存对象集合.
	 * 
	 */
	private ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>();
	/**根据缓存名配置的缓存的时间.
	 * 
	 */
	private Map<String, Integer> expireMap = new HashMap<String, Integer>();   
	 /** xmemcached的客户端.
	  *
	  */
	private MemcachedClient memcachedClient;  

	/**默认构造函数.
	 * 
	 */
	public MemcachedCacheManager() {
	}

	/**载入缓存（Load the initial caches for this cache manager.）.
	 * 
	 */
	@Override
	protected Collection<? extends Cache> loadCaches() {
		Collection<Cache> values = cacheMap.values();
		return values;
	}

	/**根据缓存名，获取缓存对象.
	 * 
	 */
	@Override
	public Cache getCache(String name) {
		Cache cache = cacheMap.get(name);
		if (cache == null) {
			Integer expire = expireMap.get(name);
			if (expire == null) {
				expire = 0;
				expireMap.put(name, expire);
			}
			cache = new MemcachedCache(name, expire.intValue(), memcachedClient);
			cacheMap.put(name, cache);
		}
		return cache;
	}

	/**设置当前服务的缓存对象.
	 * 
	 * @param memcachedClient  当前服务的缓存对象
	 */
	public void setMemcachedClient(MemcachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}

	/**设置当前缓存过期时间配置.
	 * 
	 * @param expireMap  根据缓存名与对应的缓存过期时间
	 */
	public void setExpireMap(Map<String, Integer> expireMap) {
		this.expireMap = expireMap;
	}

}
