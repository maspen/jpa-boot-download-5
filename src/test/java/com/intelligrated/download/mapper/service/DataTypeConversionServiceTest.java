package com.intelligrated.download.mapper.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intelligrated.download.mapper.Application;
import com.intelligrated.download.mapper.converter.StringToBooleanConverter;
import com.intelligrated.download.mapper.converter.StringToIntegerConverter;
import com.intelligrated.download.mapper.converter.StringToLocalDateTimeConverter;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DataTypeConversionServiceTest {
	@Autowired
	DataTypeConversionService dataTypeConversionService;
	
	@Before
	public void setup() {
		assertThat(dataTypeConversionService, is(not(nullValue())));
	}
	
	@Test
	public void listConstructorThrowsNullPointerExceptionWhenListIsNullButCreatesObject() {
		List<Object> nullList = null;
		DataTypeConversionService newDataTypeConversionService = null;
		try {
			newDataTypeConversionService = new DataTypeConversionService(nullList);			
		} catch (Exception e) {
			assertThat(e, is(not(nullValue())));
			Assert.assertTrue(e instanceof NullPointerException);
		}
		assertThat(newDataTypeConversionService, is(not(nullValue())));
		Assert.assertTrue(newDataTypeConversionService instanceof DataTypeConversionService);
	}
	
//	@Test
//	public void beforeConvertersSetReturnsNullForConversion() {
//		assertThat(dataTypeConversionService.getGenericConversionService().canConvert(String.class, Integer.class), is(false));
//		assertThat(dataTypeConversionService.convert("1", Integer.class), is(nullValue()));
//	}
	
	@Test
	public void afterSettingConvertersCanConvert() {
		@SuppressWarnings("serial")
		List<Object> converterList = new ArrayList<Object>(){{
			add(new StringToBooleanConverter());
			add(new StringToIntegerConverter());
			add(new StringToLocalDateTimeConverter());
		}};
		
		String stringToBoolean = "t";
		String stringToInteger = "123";
		String stringToLocalDateTime = "2015-12-28 14:34";
		
		// ensure can't convert from String to these types
		assertThat(dataTypeConversionService.convert("String", Boolean.class), is(nullValue()));
		assertThat(dataTypeConversionService.convert("String", Integer.class), is(nullValue()));
		assertThat(dataTypeConversionService.convert("String", LocalDateTime.class), is(nullValue()));
		
		dataTypeConversionService.addConverters(converterList);
		assertThat(dataTypeConversionService.convert(stringToBoolean, Boolean.class), is(not(nullValue())));
		assertThat(dataTypeConversionService.convert(stringToInteger, Integer.class), is(not(nullValue())));
		assertThat(dataTypeConversionService.convert(stringToLocalDateTime, LocalDateTime.class), is(not(nullValue())));
	}
}
