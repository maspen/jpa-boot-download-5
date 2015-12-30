package com.intelligrated.download.mapper.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

/**
 * Reading (from download file) converter which converts from String data to
 * LocalDateTime objects.
 * 
 * @author matt.aspen
 *
 */
@ReadingConverter
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime>{
	// could be a property that gets injected on init
	private String format = "yyyy-MM-dd HH:mm";
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
	
	/**
	 * throws unchecked DateTimeParseException
	 */
	@Override
	public LocalDateTime convert(String source) {
		// TODO check String
		return LocalDateTime.parse(source, formatter);
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public DateTimeFormatter getFormatter() {
		return formatter;
	}

	public void setFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}
}
