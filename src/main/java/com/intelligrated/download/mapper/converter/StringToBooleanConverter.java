package com.intelligrated.download.mapper.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

/**
 * Reading (from download file) converter which converts from String data to
 * Boolean objects.
 * 
 * @author matt.aspen
 */
@ReadingConverter
public class StringToBooleanConverter implements Converter<String, Boolean> {

	/**
	 * Returns Boolea.true or Boolean.false for 't', 'true' or 'f', 'false' 
	 * respectively.
	 * Returns null if source is null or empty
	 * Returns false for any other String in put
	 */
	@Override
	public Boolean convert(String source) {
		if(null == source) {
			return null;
		}
		if(source.length() == 0 || source.equalsIgnoreCase("")) {
			return null;
		}
		if(source.equalsIgnoreCase("t")) {
			source = "true";
		}
		if(source.equalsIgnoreCase("f")) {
			source = "false";
		}
		return Boolean.valueOf(source);
	}
}
