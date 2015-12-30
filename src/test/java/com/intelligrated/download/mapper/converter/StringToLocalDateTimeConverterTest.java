package com.intelligrated.download.mapper.converter;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;

public class StringToLocalDateTimeConverterTest {

	private StringToLocalDateTimeConverter converter = new StringToLocalDateTimeConverter();
	
	@Test
	public void validStringReturnsLocalValidDateTime() {
		String validStringDate = "2015-12-22 13:59";
		LocalDateTime convertedDateTime = converter.convert(validStringDate);
		Assert.assertEquals(2015, convertedDateTime.getYear());
		Assert.assertEquals(Month.DECEMBER, convertedDateTime.getMonth());
		Assert.assertEquals(22, convertedDateTime.getDayOfMonth());
		Assert.assertEquals(13, convertedDateTime.getHour());
		Assert.assertEquals(59, convertedDateTime.getMinute());
		Assert.assertTrue(validStringDate.equals(convertedDateTime.format(converter.getFormatter())));
	}
}
