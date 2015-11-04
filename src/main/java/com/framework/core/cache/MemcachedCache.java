package com.framework.core.cache;

import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;



/**使用memcache替换spring cache接口原来的实现方式.
 * @author lixiaolong
 * @version datetime：2015年11月4日  下午4:58:57
 */
public class MemcachedCache implements Cache {

	/**保存的缓存名,对应spring cache 中 @Cacheable、@CachePut、@CacheEvict等的name属性值.
	 * 
	 */
	private final String cacheName;
	/**memcache缓存对象.
	 * 
	 */
	private final MemCache memCache;

	/**构造函数.
	 * 
	 * @param cacheName 缓存名 对应spring cache 中 @Cacheable、@CachePut、@CacheEvict等的name属性值
	 * @param expire  缓存过期时间
	 * @param memcachedClient xmemcache缓存对象
	 */
	public MemcachedCache(String cacheName, int expire, MemcachedClient memcachedClient) {
		this.cacheName = cacheName;
		this.memCache = new MemCache(cacheName, expire, memcachedClient);
	}

	/**清空缓存.
	 * 
	 */
	@Override
	public void clear() {
		memCache.clear();
	}

	/**根据缓存key值，删除缓存.
	 * 
	 */
	@Override
	public void evict(Object key) {
		memCache.delete(key.toString());
	}

	/**根据缓存key值，获取缓存.
	 * 
	 */
	@Override
	public ValueWrapper get(Object key) {
		ValueWrapper wrapper = null;
		Object value = memCache.get(key.toString());
		if (value != null) {
			wrapper = new SimpleValueWrapper(value);
		}
		return wrapper;
	}

	/**获取当前操作的缓存名.
	 * 
	 */
	@Override
	public String getName() {
		return this.cacheName;
	}

	/**获取当前使用的缓存服务对象.
	 * 
	 */
	@Override
	public MemCache getNativeCache() {
		return this.memCache;
	}

	/**缓存存储.
	 * 
	 */
	@Override
	public void put(Object key, Object value) {
		memCache.put(key.toString(), value);
	}

	/**获取缓存对象.
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(Object key, Class<T> type) {
		Object value = this.memCache.get(key.toString());
		if (type != null && !type.isInstance(value)) {
			String errorMeg = "Cached value is not of required type ["+ type.getName() +"]: " +value;
			throw new IllegalStateException(errorMeg);
		}
		return (T) value;
	}


	

}
