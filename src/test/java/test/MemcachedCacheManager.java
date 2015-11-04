//package test;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//
//import net.rubyeye.xmemcached.MemcachedClient;
//
//import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;
//import org.springframework.cache.Cache;
///**
// * @author lixiaolong(http://www.it165.net/pro/html/201409/21260.html)
// * @version datetime：2015年11月3日  下午2:16:55
// */
//public class MemcachedCacheManager extends AbstractTransactionSupportingCacheManager {
//
//	private ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>();
//	//缓存的时间
//	private Map<String, Integer> expireMap = new HashMap<String, Integer>();   
//	 //xmemcached的客户端
//	private MemcachedClient memcachedClient;  
//
//	public MemcachedCacheManager() {
//	}
//
//	@Override
//	protected Collection<? extends Cache> loadCaches() {
//		Collection<Cache> values = cacheMap.values();
//		return values;
//	}
//
//	@Override
//	public Cache getCache(String name) {
//		Cache cache = cacheMap.get(name);
//		if (cache == null) {
//			Integer expire = expireMap.get(name);
//			if (expire == null) {
//				expire = 0;
//				expireMap.put(name, expire);
//			}
//			cache = new MemcachedCache(name, expire.intValue(), memcachedClient);
//			cacheMap.put(name, cache);
//		}
//		return cache;
//	}
//
//	public void setMemcachedClient(MemcachedClient memcachedClient) {
//		this.memcachedClient = memcachedClient;
//	}
//
//	public void setExpireMap(Map<String, Integer> expireMap) {
//		this.expireMap = expireMap;
//	}
//
//}