package com.intelligrated.download.mapper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.stereotype.Service;

@Service
public class ConversionService {
	@Autowired
	ConversionServiceFactory conversionServiceFactory;
	
	public ConversionService() {
		//conversionServiceFactory.registerConverters(converters, registry);
	}
}
