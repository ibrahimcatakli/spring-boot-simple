package com.spring.vd.simple.simple.car.factory.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.vd.simple.simple.car.factory.exception.ResourceNotFoundException;
import com.spring.vd.simple.simple.car.factory.services.Car;
import com.spring.vd.simple.simple.car.factory.services.CarFactory;
import com.spring.vd.simple.simple.car.factory.services.CarType;
import com.spring.vd.simple.simple.car.factory.services.CarUtil;


@RestController
@RequestMapping("/api")
public class CarController {
	@Autowired(required=true)
	CarFactory carFactory;	
	
	@Autowired(required=true)
	CarUtil carUtil;
	
	@GetMapping("/cars/{type}")
	@ExceptionHandler(value 
		      = { ResourceNotFoundException.class, ResourceNotFoundException.class })
	public @ResponseBody String getCarType(@PathVariable("type") String type) throws ResourceNotFoundException {

		Car car = carFactory.getCar(CarUtil.getCarType(type.toLowerCase()))
				.orElseThrow(() -> new ResourceNotFoundException("Car not found for this type :: " + type));
		return car.getType();

	}
}
