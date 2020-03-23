package com.gillsoft.client;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gillsoft.cache.CacheHandler;
import com.gillsoft.cache.IOCacheException;
import com.gillsoft.cache.RedisMemoryCache;
import com.gillsoft.util.ContextProvider;

public class BindingUpdateTask implements Runnable, Serializable {
	
	private static final long serialVersionUID = -4411490577087475509L;
	
	private static final String BINDING_CACHE_KEY = "intercars.binding.";

	@Override
	public void run() {
		Map<String, Object> params = new HashMap<>();
		params.put(RedisMemoryCache.OBJECT_NAME, BindingUpdateTask.BINDING_CACHE_KEY);
		params.put(RedisMemoryCache.IGNORE_AGE, true);
		params.put(RedisMemoryCache.UPDATE_DELAY, Config.getCacheStationsUpdateDelay());
		
		RestClient client = ContextProvider.getBean(RestClient.class);
		try {
			Map<String, List<String>> binding = client.getBinding();
			if (binding != null) {
				params.put(RedisMemoryCache.UPDATE_TASK, this);
				client.getCache().write(binding, params);
			}
		} catch (ResponseError | IOCacheException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static Map<String, List<String>> getBinding(CacheHandler cache) throws IOCacheException {
		Map<String, Object> params = new HashMap<>();
		params.put(RedisMemoryCache.OBJECT_NAME, BindingUpdateTask.BINDING_CACHE_KEY);
		params.put(RedisMemoryCache.IGNORE_AGE, true);
		params.put(RedisMemoryCache.UPDATE_DELAY, Config.getCacheStationsUpdateDelay());
		params.put(RedisMemoryCache.UPDATE_TASK, new BindingUpdateTask());
		return (Map<String, List<String>>) cache.read(params);
	}

}
