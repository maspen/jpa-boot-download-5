package com.intelligrated.download.mapper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligrated.download.mapper.converter.StringToIntegerConverter;
import com.intelligrated.download.mapper.converter.StringToLocalDateTimeConverter;
import com.intelligrated.download.mapper.entity.EntityTypeEnum;
import com.intelligrated.download.mapper.entity.HeaderEntity;
import com.intelligrated.download.mapper.entity.IEntity;
import com.intelligrated.download.mapper.entity.MapperEntity;
import com.intelligrated.download.mapper.repo.MapperRepository;

@Service("mapperService")
//@Transactional -- prevents from autowiring in Application
public class MapperService {
	private final MapperRepository mapperRepository;
	private DataTypeConversionService dataTypeConversionService;
	
	/**
	 * The "mappers" repo (h2) contains mapping for both
	 * header entities and order entities. This splits
	 * them up (based on 'type' see {@link EntityTypeEnum})
	 */
	private List<MapperEntity> headerMapperList;
	private List<MapperEntity> orderMapperList;
	
	/**
	 * Associates a header with order line(s).
	 * TODO: better place to manage this
	 */
	private static AtomicInteger sequenceNumber = new AtomicInteger(0);
	
	/**
	 * List that stores the data type converters.
	 */
	private List<Object> converterList;
	
	@Autowired
	public MapperService(MapperRepository mapperRepository, DataTypeConversionService dataTypeConversionService) {
		this.mapperRepository = mapperRepository;
		this.dataTypeConversionService = dataTypeConversionService;
		
		initializeMapperLists();
		initializeDataTypeConversionService();
	}

	/**
	 * Pulls from mappers repo and sets up the lists of mappings
	 */
	private void initializeMapperLists() {
		headerMapperList = mapperRepository.getByEntityType(EntityTypeEnum.HEADER.getValue());
		orderMapperList = mapperRepository.getByEntityType(EntityTypeEnum.ORDER_LINE.getValue());
	}
	
	/**
	 * Sets the types for data types the {@link DataTypeConversionService}
	 * will have to convert to (from String)
	 */
	@SuppressWarnings("serial")
	private void initializeDataTypeConversionService() {
		// TODO configurable way to set this list up
		converterList = new ArrayList<Object>(){{
			// add(new StringToBooleanConverter());
			add(new StringToIntegerConverter());
			// NOTE: below is added for mock testing
			add(new StringToLocalDateTimeConverter());
		}};
		
		dataTypeConversionService.addConverters(converterList);
	}
	
	/**
	 * Static method that takes in a line of text and maps it to an entity.
	 * NOTE: returns List<IEntity> because order lines go into two tables
	 * @param line - String from a file
	 * @return List of {@link IEntity}
	 */
	public static List<IEntity> map(String line) {
		List<IEntity> entityList = new ArrayList<IEntity>();
		
		if(line.startsWith("1")) {
			entityList.add(mapHeaderEntity(line));
			return entityList;
		} else if(line.startsWith("2")) {
			entityList.addAll(mapOrderEntity(line));
			return entityList;
		}
		
		return null;
	}
	
	private static HeaderEntity mapHeaderEntity(String line) {
		return null;
	}
	
	private static List<IEntity> mapOrderEntity(String line) {
		return null;
	}

	public List<MapperEntity> getMappers() {
		return mapperRepository.findAll();
	}

	public List<MapperEntity> getHeaderMapperList() {
		return headerMapperList;
	}

	public List<MapperEntity> getOrderMapperList() {
		return orderMapperList;
	}
}
