package cache;

import java.net.URL;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;


public class TestEhCache {
	
	public void basic(){
		
	}
	
	public static void main(String[] args) {
		URL url = Thread.currentThread().getClass().getResource("/ehcache.xml"); 
		CacheManager singletonManager =CacheManager.create(url);
		singletonManager.addCache("test");
		Cache test = singletonManager.getCache("test");

		test.getCacheManager().
		   getCacheManagerEventListenerRegistry().notifyCacheAdded("test");
		
		test.put(new Element("a", "a"));
		System.out.println(test.get("a").getObjectValue());
	}
	
}
