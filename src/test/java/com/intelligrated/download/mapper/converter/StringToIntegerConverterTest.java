package com.intelligrated.download.mapper.converter;

import org.junit.Assert;
import org.junit.Test;

public class StringToIntegerConverterTest {
	private StringToIntegerConverter converter = new StringToIntegerConverter();
	
	@Test
	public void testConvertValidStringToInteger() {
		String validString = "12345";
		Integer returnedInteger = converter.convert(validString);
		Assert.assertNotNull(returnedInteger);
		Assert.assertEquals(12345, returnedInteger.intValue());
	}
	
	@Test
	public void testConvertNullStringThrowsNumberFormatException() {
		String nullString = null;
		Integer returnedInteger = null;
		try {
			returnedInteger = converter.convert(nullString);
		} catch (NumberFormatException e) {
			Assert.assertNotNull(e);
			Assert.assertTrue(e instanceof NumberFormatException);
		}
		Assert.assertNull(returnedInteger);
	}
	
	@Test
	public void testConvertBlankStringThrowsNumberFormatException() {
		String blankString = "";
		Integer returnedInteger = null;
		try {
			returnedInteger = converter.convert(blankString);
		} catch (NumberFormatException e) {
			Assert.assertNotNull(e);
			Assert.assertTrue(e instanceof NumberFormatException);
		}
		Assert.assertNull(returnedInteger);
	}
	
	@Test
	public void testConvertStringWithWhiteSpacesThrowsNumberFormatException() {
		String paddedString = " 12345 ";
		Integer returnedInteger = null;
		try {
			returnedInteger = converter.convert(paddedString);
		} catch (NumberFormatException e) {
			Assert.assertNotNull(e);
			Assert.assertTrue(e instanceof NumberFormatException);
		}
		Assert.assertNull(returnedInteger);
	}
	
	@Test
	public void testConvertStringWithNumbersLettersThrowsNumberFormatException() {
		String mixedString = "123t45,";
		Integer returnedInteger = null;
		try {
			returnedInteger = converter.convert(mixedString);
		} catch (NumberFormatException e) {
			Assert.assertNotNull(e);
			Assert.assertTrue(e instanceof NumberFormatException);
		}
		Assert.assertNull(returnedInteger);
	}

}
