package com.corecomets.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping(path = "/filtering")
	public DummyBean retriveDummyBean() {
		return new DummyBean("someField1", "someField2", "someField3");
	}
	
	@GetMapping(path = "/filtering-list")
	public List<DummyBean> retriveListOfDummyBean() {
		return Arrays.asList(new DummyBean("someField1", "someField2", "someField3"), new DummyBean
				("someField11", "someField22", "someField33"));
	}
	
	//Dynamic Filtering
	@GetMapping(path = "/filtering-dynamic")
	public MappingJacksonValue retriveDynamicDummyBean() {
		DummyBean dummyBean =  new DummyBean("someField1", "someField2", "someField3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("someField3", "someField2"); // Filters out the fields except what we want to send
		FilterProvider filters = new SimpleFilterProvider().addFilter("DummyBeanFilter", filter); // This is basic filter
		MappingJacksonValue mapping = new MappingJacksonValue(dummyBean); // 
		mapping.setFilters(filters); // Sets the configured filters to mapping and sends the mapping value in the response
		return mapping;
		
	}
	
	@GetMapping(path = "/filtering-dynamic-list")
	public MappingJacksonValue retriveDynamicListOfDummyBean() {
		List<DummyBean> dummyBeanList =  Arrays.asList(new DummyBean("someField1", "someField2", "someField3"), new DummyBean
				("someField11", "someField22", "someField33"));
	SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("someField3","someField33");
	FilterProvider filters = new SimpleFilterProvider().addFilter("DummyBeanFilter",filter);
	MappingJacksonValue mapping = new MappingJacksonValue(dummyBeanList);
	mapping.setFilters(filters);
	return mapping;

	}
}
