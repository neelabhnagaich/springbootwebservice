package com.neelabh.rest.restfullwebservices.Filtering;

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
	
	@GetMapping("/filtering")
	public SampleBean filtering() {
		return new SampleBean("neelabh","nagaich", "male");
	}
	
//	dynamically filters out field3 from this api response	
	@GetMapping("/filtering-dynamic")
	public MappingJacksonValue filteringDynamic() {
		SampleBean someBean = new SampleBean("neelabh","nagaich", "male");
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SampleBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}
	
	@GetMapping("/filtering-list-dynamic")
	public MappingJacksonValue filteringListDynamic() {
		List<SampleBean> list = Arrays.asList(new SampleBean("neelabh","nagaich", "male"), new SampleBean("ashish","shukla", "male"));
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
	
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SampleBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}

}
