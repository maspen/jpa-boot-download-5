package com.intelligrated.download.mapper.converter;

import org.junit.Assert;
import org.junit.Test;

public class StringToBooleanConverterTest {
	private StringToBooleanConverter converter = new StringToBooleanConverter();
	
	@Test
	public void convertNullStringReturnsNull() {
		String nullString = null;
		Boolean returnedBooleanType = converter.convert(nullString);
		Assert.assertNull(returnedBooleanType);
	}
	
	@Test
	public void convertEmptyStringReturnsNull() {
		String emptyString = "";
		Boolean returnedBooleanType = converter.convert(emptyString);
		Assert.assertNull(returnedBooleanType);
	}
	
	@Test
	public void convertBogusStringReturnsFalse() {
		String bogusString = "12tdset9";
		Boolean returnedBooleanType = null;
		try {
			returnedBooleanType = converter.convert(bogusString);
		} catch (Exception e) {
			Assert.assertNotNull(e);
		}
		
		Assert.assertFalse(returnedBooleanType);
	}
	
	@Test
	public void convertTStringReturnsBooleanTrue() {
		String tString = "t";
		Boolean returnedBooleanType = converter.convert(tString);
		Assert.assertTrue(returnedBooleanType);
	}
	
	@Test
	public void convertTrueStringReturnsBooleanTrue() {
		String trueString = "true";
		Boolean returnedBooleanType = converter.convert(trueString);
		Assert.assertTrue(returnedBooleanType);
	}
	
	@Test
	public void convertFStringReturnsBooleanFalse() {
		String fString = "f";
		Boolean returnedBooleanType = converter.convert(fString);
		Assert.assertFalse(returnedBooleanType);
	}
	
	@Test
	public void convertFalseStringReturnsBooleanFalse() {
		String falseString = "false";
		Boolean returnedBooleanType = converter.convert(falseString);
		Assert.assertFalse(returnedBooleanType);
	}
}
