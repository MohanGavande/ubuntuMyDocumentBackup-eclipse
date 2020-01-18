package com.mohan.rest.webservices.restfulwebservices.controller.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;



@RestController
public class FilterController {

	@GetMapping(path = "/filtering")
	public MappingJacksonValue retriewSomeBean () {
		
		Somebean somebean = new Somebean("Value1", "Value2", "Value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");	
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(somebean);
		mapping.setFilters(filters);
		
		return mapping;
		
	}

	@GetMapping(path = "/filtering-list")
	public MappingJacksonValue retriewListOfSomeBeans () {
		
		List<Somebean> somebeanList = new ArrayList<Somebean>();
		somebeanList.add(new Somebean("Value1", "Value2", "Value3"));
		somebeanList.add(new Somebean("Value11", "Value12", "Value13"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(somebeanList);
		
		mapping.setFilters(filterProvider);
		
		return mapping;
	}

}
