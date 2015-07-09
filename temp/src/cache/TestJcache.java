package cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.AccessedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.spi.CachingProvider;

import org.junit.Test;



public class TestJcache {
	@Test
	public void testJcache(){

		//resolve a cache manager
		//CachingProvider cachingProvider = Caching.getCachingProvider();
		//CachingProvider cachingProvider = Caching.getCachingProvider("org.apache.commons.jcs.jcache.JCSCachingProvider");
		CachingProvider cachingProvider = Caching.getCachingProvider("com.hazelcast.cache.HazelcastCachingProvider");
		CacheManager cacheManager = cachingProvider.getCacheManager();
		//configure the cache
		MutableConfiguration<String, Integer> config =
				new MutableConfiguration<String, Integer>()
			.setTypes(String.class, Integer.class)
			.setExpiryPolicyFactory(AccessedExpiryPolicy.factoryOf(Duration.ONE_HOUR))
			.setStatisticsEnabled(true);
		//create the cache
		Cache<String, Integer> cache = cacheManager.createCache("simpleCache", config);

		//cache operations
		String key = "key";
		Integer value1 = 1;
		cache.put("key", value1);
		Integer value2 = cache.get(key);
		assertEquals(value1, value2);
		cache.remove(key);
		assertNull(cache.get(key));
	}
}
