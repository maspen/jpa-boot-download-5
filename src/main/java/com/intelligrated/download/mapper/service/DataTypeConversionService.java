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
 * On download, String values need to be converted to other data types.
 * TODO: on upload, the opposite is true
 * 
 * @author matt.aspen
 */
@Service
public class DataTypeConversionService {
	private GenericConversionService genericConversionService = new GenericConversionService();
	
	public DataTypeConversionService() {
		this(new ArrayList<Object>());
	}
	
	public DataTypeConversionService(List<Object> converters) {
//		/**
//		 * TODO: standardize that 'converters' will populate converterList
//		 * NOT hard-code here
//		 */
//		converterList.add(new StringToBooleanConverter());
//		converterList.add(new StringToIntegerConverter());
//		converterList.add(new StringToLocalDateTimeConverter());
		
		if(null != converters && !converters.isEmpty()) {
			for (Object converter : converters) {
				registerConverter(converter);
			}			
		}
	}
	
	private void registerConverter(Object converter) throws NullPointerException {
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
	 * @return Object represents the output type after the conversion OR null if no conversion is possible
	 * 
	 * NOTE: uncaught exceptions - from genericConversionService:
	 * ConversionException - if a conversion exception occurred
	 * IllegalArgumentException - if targetType is null
	 */
	public Object convert(Object from, Class<?> targetType) {
		if(null == from) { 
			return null;
		}

		if(genericConversionService.canConvert(from.getClass(), targetType)) {
			return genericConversionService.convert(from, targetType);			
		} else {
			return null;
		}
	}

	public void addConverter(Object newConverter) {
		registerConverter(newConverter);
	}
	
	public void addConverters(List<Object> converterList) {
		for (Object converter : converterList) {
			addConverter(converter);
		}
	}
	
	public void removeConverter(Class<?> fromClass, Class<?> toClass) {
		genericConversionService.removeConvertible(fromClass, toClass);
	}

	public GenericConversionService getGenericConversionService() {
		return genericConversionService;
	}

	public void setGenericConversionService(GenericConversionService genericConversionService) {
		this.genericConversionService = genericConversionService;
	}
}
