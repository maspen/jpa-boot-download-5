package com.intelligrated.download.mapper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Service;

import com.intelligrated.download.mapper.converter.StringToBooleanConverter;
import com.intelligrated.download.mapper.converter.StringToIntegerConverter;
import com.intelligrated.download.mapper.converter.StringToLocalDateTimeConverter;

/**
 * Responsible for converting from input String to appropriate data type objects.
 * Used when download file is read it and split up into fields. These fields represent
 * Entity (db) fields of specific data types.
 * 
 * Idea here is to have one service that can take as input a String and desired, resultin
 * data type and have that type be returned.
 * 
 * TODO: have this work both ways (right now only @ReadingConverter); add ability to go from db/data types to String
 * - used in upload.
 * 
 * @author matt.aspen
 */
@Service
public class MapperConversionService {
	
	List<Object> converterList;
	
	GenericConversionService genericConversionService = new GenericConversionService();
	
	public MapperConversionService() {
		this(new ArrayList<Object>());
	}

	public MapperConversionService(List<Object> converters) {
		// copy existing list or create new, empty list
		converterList = (converters != null ? new ArrayList<Object>(converters) : new ArrayList<Object>());
		
		// TODO: better (configurable ?) way of registering our converters
		// BESIDES using this constructor
		converterList.add(new StringToBooleanConverter());
		converterList.add(new StringToIntegerConverter());
		converterList.add(new StringToLocalDateTimeConverter());
		
		for (Object converter : converterList) {
			registerConverter(converter);
		}
	}

	public void registerConverter(Object converter) {
		if(null == converter) {
			throw new NullPointerException("converter cannot be null");
		}
		
		if (converter instanceof Converter<?, ?>) {
			genericConversionService.addConverter((Converter<?, ?>) converter);
		} else if (converter instanceof ConverterFactory<?, ?>) {
			genericConversionService.addConverterFactory((ConverterFactory<?, ?>) converter);
		} else if (converter instanceof GenericConverter) {
			genericConversionService.addConverter((GenericConverter) converter);
		} else {
			throw new IllegalArgumentException("converter '" + converter
					+ "' has to be of type Converter, ConverterFactory or GenericeConverter");
		}
	}
	
	/**
	 * Converts 'from' to desired Object/type
	 * @param from
	 * @param targetType - desired return Object/type
	 * 
	 * @return Object represents the output type after the conversion
	 * 
	 * NOTE: uncaught exceptions - from genericConversionService:
	 * ConversionException - if a conversion exception occurred
	 * IllegalArgumentException - if targetType is null
	 */
	public Object convert(Object from, Class<?> targetType) {
		if(null == from) { 
			return null;
		}
		
		return genericConversionService.convert(from, targetType);
	}

	public List<Object> getConverterList() {
		return converterList;
	}

	public GenericConversionService getGenericConversionService() {
		return genericConversionService;
	}

	public void setGenericConversionService(GenericConversionService genericConversionService) {
		this.genericConversionService = genericConversionService;
	}
}
