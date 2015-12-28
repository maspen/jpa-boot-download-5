package com.intelligrated.download.mapper.service;

import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Service;

@Service
public class MapperConversionService {
	
	GenericConversionService conversionService = new GenericConversionService();
	
	public MapperConversionService() {
		//conversionServiceFactory.registerConverters(converters, registry);
	}
}
