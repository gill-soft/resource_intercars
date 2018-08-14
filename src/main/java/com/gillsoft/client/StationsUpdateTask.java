package com.gillsoft.client;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.gillsoft.cache.IOCacheException;
import com.gillsoft.cache.RedisMemoryCache;
import com.gillsoft.model.ArrayOfCityS;
import com.gillsoft.util.ContextProvider;

public class StationsUpdateTask implements Runnable, Serializable {
	
	private static final long serialVersionUID = -447739350784487326L;

	@Override
	public void run() {
		Map<String, Object> params = new HashMap<>();
		params.put(RedisMemoryCache.OBJECT_NAME, RestClient.STATIONS_CACHE_KEY);
		params.put(RedisMemoryCache.IGNORE_AGE, true);
		params.put(RedisMemoryCache.UPDATE_DELAY, Config.getCacheStationsUpdateDelay());
		
		RestClient client = ContextProvider.getBean(RestClient.class);
		try {
			ArrayOfCityS stations = client.getAllStations();
			if (stations == null) {
				stations = (ArrayOfCityS) client.getCache().read(params);
			}
			params.put(RedisMemoryCache.UPDATE_TASK, this);
			client.getCache().write(stations, params);
		} catch (ResponseError | IOCacheException e) {
			e.printStackTrace();
		}
	}

}
