package com.intelligrated.download.mapper.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;

import com.intelligrated.download.mapper.converter.StringToIntegerConverter;

public class MapperConversionServiceTest {
	
	@Resource(name = "defaultConversionService")
	GenericConversionService conversionService; // = new GenericConversionService();
	
	@Before
	public void setup() {
		conversionService = new GenericConversionService();
		
		conversionService.addConverter(new Converter<String, Boolean>() {
			@Override
			public Boolean convert(String source) {
				if(source.length() == 0) {
					return null;
				}
				if(source.equalsIgnoreCase("")) {
					return null;
				}
				if(source.equalsIgnoreCase("t")) {
					source = "true";
				}
				return Boolean.valueOf(source);
			}
			
		});
		
		conversionService.addConverter(new StringToIntegerConverter());
	}

	@Test
	public void test() {
		stringToBoolean();
	}
	
	
	private void stringToBoolean() {
		String string = "true";
		Boolean data = conversionService.convert(string, Boolean.class);
		Assert.assertTrue(data);
	}

}
