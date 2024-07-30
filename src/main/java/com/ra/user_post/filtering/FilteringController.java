package com.ra.user_post.filtering;

import java.util.ArrayList;
//import java.util.Arrays;
// import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController 
{

    @GetMapping("/filtering")
    public MappingJacksonValue filtering()
    {
        SomeBean someBean= new SomeBean("Focus", "on", "Me");
        MappingJacksonValue mappingJacksonValue= new MappingJacksonValue(someBean);

        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");


        FilterProvider filters= new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList()
    {
        ArrayList<SomeBean> arr= new ArrayList<>();
        arr.add(new SomeBean("Focus", "on", "Me"));
        arr.add(new SomeBean("Find","our","light"));
        arr.add(new SomeBean("Oh","My","God"));

        MappingJacksonValue mappingJacksonValue= new MappingJacksonValue(arr);

        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");


        FilterProvider filters= new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
        
    }
    
}
