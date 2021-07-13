package com.spring.vd.simple.simple.car.factory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.vd.simple.simple.car.factory.model.Hatchback;
import com.spring.vd.simple.simple.car.factory.model.Sedan;
import com.spring.vd.simple.simple.car.factory.services.Car;


@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {
	
	Car sedan = new Sedan();	
	Car hatchback = new Hatchback();
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		String type = "Sedan";
		getRequestPerform(type, sedan);
		 type = "Hatchback";
		getRequestPerform(type, hatchback);
	}
	
	@Test
	public void shouldReturnFailureMessage() throws Exception {
		String type = "Sedann";
		getRequestFailurePerform(type);
		 
	}

	private void getRequestPerform(String type, Car car) throws Exception {
		this.mockMvc.perform(get("/api/cars/"+type)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(car.getType())));
	}
	
	private void getRequestFailurePerform(String type) throws Exception {
		this.mockMvc.perform(get("/api/cars/"+type)).andDo(print()).andExpect(status().isNotFound());
	}
	
	


}
