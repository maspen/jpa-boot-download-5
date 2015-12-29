package com.intelligrated.download.mapper.service;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intelligrated.download.mapper.Application;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MapperConversionServiceTest extends TestCase {
	
	@Autowired
	MapperConversionService mapperConversionService;
	
//	@Before
//	public void setup() {
//		mapperConversionService = new MapperConversionService();
//	}
	
	@Test
	public void serviceHasRegisteredConverters() {
		GenericConversionService genericConversionService = mapperConversionService.getGenericConversionService();
		Assert.assertTrue( genericConversionService.canConvert(String.class, Boolean.class) );
		Assert.assertTrue( genericConversionService.canConvert(String.class, Integer.class) );
		Assert.assertTrue( genericConversionService.canConvert(String.class, LocalDateTime.class) );
	}
	
	@Test
	public void nullFromReturnsNull() {
		Object nullFrom = null;
		Object returnedObject = mapperConversionService.convert(nullFrom, String.class);
		Assert.assertNull(returnedObject);
	}
	
	@Test
	public void nullClassThrowsIllegalArgumentException() {
		Object from = "true";
		Class<?> nullClass = null;
		Object returnedObject = null;
		try {
			returnedObject = mapperConversionService.convert(from, nullClass);
		} catch (Exception e) {
			Assert.assertEquals(IllegalArgumentException.class, e.getClass());
		}
		Assert.assertNull(returnedObject);
	}
}
