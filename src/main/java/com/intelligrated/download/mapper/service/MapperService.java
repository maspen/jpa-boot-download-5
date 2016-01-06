package com.intelligrated.download.mapper.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligrated.download.mapper.converter.StringToIntegerConverter;
import com.intelligrated.download.mapper.converter.StringToLocalDateTimeConverter;
import com.intelligrated.download.mapper.entity.AbstractEntity;
import com.intelligrated.download.mapper.entity.EntityTypeEnum;
import com.intelligrated.download.mapper.entity.HeaderEntity;
import com.intelligrated.download.mapper.entity.IEntity;
import com.intelligrated.download.mapper.entity.MapperEntity;
import com.intelligrated.download.mapper.entity.Order_H_Entity;
import com.intelligrated.download.mapper.entity.Order_L_Entity;
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
	private static List<MapperEntity> headerMapperList;
	private static List<MapperEntity> orderMapperList;
	
	private static List<MapperEntity> orderLMapperList;
	private static List<MapperEntity> orderHMapperList;
	
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
		System.out.println("   headerMapperList size: " + headerMapperList.size());
		
		orderMapperList = mapperRepository.getByEntityType(EntityTypeEnum.ORDER_LINE.getValue());
		System.out.println("   orderMapperList size: " + orderMapperList.size());
		
		/**
		 * split out the order_l and order_h mappings
		 */
		Stream<MapperEntity> orderHMapperListStream = orderMapperList.stream();
		orderHMapperList = orderHMapperListStream.filter(m -> m.getFieldTableName().equalsIgnoreCase("orderh")).collect(Collectors.toList());
		orderHMapperListStream.close();
		System.out.println("   orderHMapperList size: " + orderHMapperList.size());
		
		Stream<MapperEntity> orderLMapperListStream = orderMapperList.stream();
		orderLMapperList = orderLMapperListStream.filter(m -> m.getFieldTableName().equalsIgnoreCase("orderl")).collect(Collectors.toList());
		orderLMapperListStream.close();
		System.out.println("   orderLMapperList size :" + orderLMapperList.size());
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
		HeaderEntity headerEntity = new HeaderEntity();
		headerEntity.setSeqNum(sequenceNumber.incrementAndGet());
		
		setField(line, headerEntity, headerMapperList);
		
		return headerEntity;
	}
	
	private static List<IEntity> mapOrderEntity(String line) {
		List<IEntity> entityList = new ArrayList<>();
		// order h
		Order_H_Entity orderHEntity = new Order_H_Entity();
		
		entityList.add(orderHEntity);
		// order l
		Order_L_Entity orderLEntity = new Order_L_Entity();
		
		entityList.add(orderLEntity);
		
		return entityList;
	}
	
	private static void setField(String line, AbstractEntity entity, List<MapperEntity> mapperEntityList) {
		// iterate over the mapper list
		for (MapperEntity mapperEntity : mapperEntityList) {
			// for each 'mapping', pull out the sub String
			String subString = line.substring(mapperEntity.getIndexStart(), (mapperEntity.getIndexStart() + mapperEntity.getIndexLength()));
			System.out.println("     subString " + subString);
			
			// get the field 'name' from mapperEntity to see which field on the
			// table entity the subString value needs to be set on
			String fieldTitle = mapperEntity.getFieldTitle();
			System.out.println("     fieldTitle " + fieldTitle);
			System.out.println("---------------------------");
			
			// get the PoJo field for this fieldName
			Field javaField = entity.getField(fieldTitle);
			if(null != javaField) {
				// set the value on the field
				setFieldOnEntity(javaField, entity, subString);
			} else {
				// TODO: handle error situation
				System.err.println("FAILED to set field '" + fieldTitle +"' on class " + entity.getClass());
			}
		}
	}
	
	private static void setFieldOnEntity(Field javaField, AbstractEntity entity, String subString) {
		Class<?> fieldClass = javaField.getType();
		Object convertedObject = DataTypeConversionService.convert(subString, fieldClass);
		try {
			javaField.set(entity, convertedObject);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.err.println("   FAILED to set value '" + subString + "' on field " + javaField.getName() +
					"\nreason: " + e.getMessage());
		}
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
