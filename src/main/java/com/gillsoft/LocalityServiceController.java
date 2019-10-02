package com.gillsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.gillsoft.abstract_rest_service.AbstractLocalityService;
import com.gillsoft.cache.IOCacheException;
import com.gillsoft.client.RestClient;
import com.gillsoft.model.ArrayOfCityS;
import com.gillsoft.model.CityS;
import com.gillsoft.model.Lang;
import com.gillsoft.model.Locality;
import com.gillsoft.model.request.LocalityRequest;
import com.google.common.collect.Lists;

@RestController
public class LocalityServiceController extends AbstractLocalityService {
	
	private static List<Locality> all;
	private static Map<String, List<String>> binding;
	
	@Autowired
	private RestClient client;

	@Override
	public List<Locality> getAllResponse(LocalityRequest request) {
		return getAllLocalities(request);
	}

	@Override
	public Map<String, List<String>> getBindingResponse(LocalityRequest request) {
		createLocalities();
		return binding;
	}

	@Override
	public List<Locality> getUsedResponse(LocalityRequest request) {
		return getAllLocalities(request);
	}
	
	private List<Locality> getAllLocalities(LocalityRequest request) {
		createLocalities();
		if (all != null) {
			return Lists.newArrayList(all);
		}
		return null;
	}
	
	@Scheduled(initialDelay = 60000, fixedDelay = 900000)
	public void createLocalities() {
		if (LocalityServiceController.all == null) {
			synchronized (LocalityServiceController.class) {
				if (LocalityServiceController.all == null) {
					boolean cacheError = true;
					do {
						try {
							ArrayOfCityS cities = client.getCachedStations();
							if (cities != null) {
								all = new ArrayList<>();
								binding = new HashMap<>();
								all.addAll(cities.getCityS().stream().map(this::getLocalityFromStation).collect(Collectors.toList()));
								/*for (CityS city : cities.getCityS()) {
									Locality locality = getLocalityFromStation(city);
									all.add(locality);
									//binding.put(locality.getId(), station.getPairs());
								}*/
								cacheError = false;
							}
						} catch (IOCacheException e) {
							try {
								TimeUnit.MILLISECONDS.sleep(1000);
							} catch (InterruptedException ie) {
							}
						}
					} while (cacheError);
				}
			}
		}
	}
	
	private Locality getLocalityFromStation(CityS city) {
		Locality locality = new Locality(String.valueOf(city.getId()));
		if (city.getNameEng() != null && !city.getNameEng().isEmpty()) {
			locality.setName(Lang.EN, city.getNameEng());
		}
		if (city.getNameRus() != null && !city.getNameRus().isEmpty()) {
			locality.setName(Lang.RU, city.getNameRus());
		}
		return locality;
	}
	
	public static Locality getLocalityById(String id) {
		if (all == null) {
			return null;
		}
		for (Locality locality : all) {
			if (Objects.equals(id, locality.getId())) {
				return locality;
			}
		}
		return null;
	}
	
	public static Locality getLocalityByName(String name) {
		if (all == null) {
			return null;
		}
		for (Locality locality : all) {
			for (String localityName : locality.getName().values()) {
				if (Objects.equals(name, localityName)) {
					return locality;
				}
			}
		}
		return null;
	}

}
