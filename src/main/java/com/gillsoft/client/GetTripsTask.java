package com.gillsoft.client;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gillsoft.cache.IOCacheException;
import com.gillsoft.cache.RedisMemoryCache;
import com.gillsoft.model.PathL;
import com.gillsoft.util.ContextProvider;

public class GetTripsTask implements Runnable, Serializable {
	
	private static final long serialVersionUID = -612450869121241871L;
	
	private TripsTaskKey key;
	
	public GetTripsTask() {

	}

	public GetTripsTask(TripsTaskKey key) {
		this.key = key;
	}

	@Override
	public void run() {
		Map<String, Object> params = new HashMap<>();
		params.put(RedisMemoryCache.OBJECT_NAME, key.toString());
		params.put(RedisMemoryCache.UPDATE_TASK, this);
		params.put(RedisMemoryCache.UPDATE_DELAY, Config.getCacheTripUpdateDelay());
		TripPackage tripPackage = null;
		
		// получаем рейсы для создания кэша
		RestClient client = ContextProvider.getBean(RestClient.class);
		try {
			tripPackage = client.findPath(key);
			params.put(RedisMemoryCache.TIME_TO_LIVE, getTimeToLive(tripPackage));
		} catch (ResponseError e) {
			// ошибку поиска тоже кладем в кэш но с другим временем жизни
			params.put(RedisMemoryCache.TIME_TO_LIVE, Config.getCacheErrorTimeToLive());
			params.put(RedisMemoryCache.UPDATE_DELAY, Config.getCacheErrorUpdateDelay());
			tripPackage = new TripPackage();
			tripPackage.setError(e);
		}
		try {
			client.getCache().write(tripPackage, params);
		} catch (IOCacheException e) {
			e.printStackTrace();
		}
	}
	
	// время жизни до момента самого позднего отправления
	private long getTimeToLive(TripPackage tripPackage) {
		if (Config.getCacheTripTimeToLive() != 0) {
			return Config.getCacheTripTimeToLive();
		}
		if (tripPackage != null && tripPackage.getPathList() != null
				&& !tripPackage.getPathList().isEmpty()) {
			long max = 0;
			for (PathL trip : tripPackage.getPathList()) {
				try {
					Date date = RestClient.dateFormatFull.parse(trip.getTimeIn());
					if (date != null && date.getTime() > max) {
						max = date.getTime();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return max - System.currentTimeMillis();
		}
		return 0;
	}

}
