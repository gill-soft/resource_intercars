package com.gillsoft.client;

import java.util.Objects;

public enum TariffType {

	CHILD(1, 0, 11, "DT (до 12 лет)"),
	TEEN(2, 12, 26, "ET (12...26 лет)"),
	ADULT(3, 27, 59, "PT (27...59 лет)"),
	SENIOR(4, 60, null, "ET (более 60 лет)");
	
	private Integer id;
	private Integer minAge;
	private Integer maxAge;
	private String name;
	
	private TariffType(Integer id, Integer minAge, Integer maxAge, String name) {
		this.id = id;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public Integer getMinAge() {
		return minAge;
	}

	public Integer getMaxAge() {
		return maxAge;
	}
	
	public String getName() {
		return name;
	}
	
	public static TariffType getType(String id) {
		for (TariffType type : values()) {
			if (Objects.equals(id, type.getId())) {
				return type;
			}
		}
		return null;
	}
	
}


