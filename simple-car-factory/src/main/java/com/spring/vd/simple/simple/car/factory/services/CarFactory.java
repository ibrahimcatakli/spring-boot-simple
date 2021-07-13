package com.spring.vd.simple.simple.car.factory.services;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.spring.vd.simple.simple.car.factory.exception.ResourceNotFoundException;
import com.spring.vd.simple.simple.car.factory.model.Cabrio;
import com.spring.vd.simple.simple.car.factory.model.Hatchback;
import com.spring.vd.simple.simple.car.factory.model.Sedan;

@Component
public class CarFactory {

	public Optional<Car> getCar(CarType carType) throws ResourceNotFoundException {

		Car car;

		if (carType == null)
			throw new ResourceNotFoundException("Car type can not be empty or null");

		switch (carType) {
		case CABRIO:
			car = new Cabrio();
			break;
		case SEDAN:
			car = new Sedan();
			break;
		case HATCHBACK:
			car = new Hatchback();
			break;
		default:
			throw new ResourceNotFoundException("Car type can not be empty or null");

		}

		return Optional.of(car);
	}
}
