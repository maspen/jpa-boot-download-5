package com.intelligrated.download.mapper.converter;

import org.springframework.core.convert.converter.Converter;

public class StringToIntegerConverter implements Converter<String, Integer> {
	/**
	 * Uncaught exception NumberFormatException
	 */
	@Override
	public Integer convert(String source) {
		return Integer.valueOf(source);
	}
}
