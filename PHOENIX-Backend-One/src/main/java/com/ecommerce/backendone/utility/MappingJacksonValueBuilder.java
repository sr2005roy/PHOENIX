package com.ecommerce.backendone.utility;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;

public class MappingJacksonValueBuilder {
    Object value;
    SimpleFilterProvider simpleFilterProvider;

    private MappingJacksonValueBuilder(Object value) {
        this.value = value;
        this.simpleFilterProvider = new SimpleFilterProvider();
    }

    public static MappingJacksonValueBuilder init(Object value) {
        return new MappingJacksonValueBuilder(value);
    }

    public MappingJacksonValueBuilder addFilter(String filterName, String... excludeProperties) {
        if (excludeProperties.length == 0)
            simpleFilterProvider.addFilter(filterName, SimpleBeanPropertyFilter.serializeAll());
        else
            simpleFilterProvider.addFilter(filterName, SimpleBeanPropertyFilter.serializeAllExcept(excludeProperties));
        return this;
    }

    public MappingJacksonValue build() {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(value);
        mappingJacksonValue.setFilters(simpleFilterProvider);
        return mappingJacksonValue;
    }
}