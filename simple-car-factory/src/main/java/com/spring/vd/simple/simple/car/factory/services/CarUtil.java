package com.spring.vd.simple.simple.car.factory.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public final class CarUtil {
	public final static Map<String, CarType> activityMap = new HashMap<String, CarType>();
	{
		activityMap.put("cabrio", CarType.CABRIO);
		activityMap.put("sedan", CarType.SEDAN);
		activityMap.put("hatchback", CarType.HATCHBACK);
	}
	
	public static CarType getCarType(String cartype) {
		System.err.println(activityMap.get(cartype));
		return activityMap.get(cartype);
	}
	

}
