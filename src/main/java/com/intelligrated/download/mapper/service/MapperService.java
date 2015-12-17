package com.intelligrated.download.mapper.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligrated.download.mapper.entity.AbstractEntity;
import com.intelligrated.download.mapper.entity.EntityTypeEnum;
import com.intelligrated.download.mapper.entity.IEntity;
import com.intelligrated.download.mapper.entity.header.HeaderEntity;
import com.intelligrated.download.mapper.entity.mapper.MapperEntity;
import com.intelligrated.download.mapper.entity.order.OrderEntity;
import com.intelligrated.download.mapper.entity.order.OrderHEntity;
import com.intelligrated.download.mapper.entity.order.OrderLEntity;
import com.intelligrated.download.mapper.repo.HeaderRepository;
import com.intelligrated.download.mapper.repo.MapperRepository;

@Service
public class MapperService {
	final MapperRepository mapperRepository;
	
	final HeaderRepository headerRepository;
	
	private static List<MapperEntity> headerMapperList;
	private static List<MapperEntity> orderMapperList;
	// ....
	private static List<MapperEntity> orderHMapperList;
	private static List<MapperEntity> orderLMapperList;
	
	// TODO: has to somehow manage sequenceNumber(s)
	private static AtomicInteger sequenceNumber = new AtomicInteger(0);
	
	@Autowired
	public MapperService(MapperRepository repository, HeaderRepository headerRepository) {
		this.mapperRepository = repository;
		this.headerRepository = headerRepository;
		
		initMapperList();
	};
	
	private void initMapperList() {
		// TODO: gets all entities (header AND order)
		// will need to figure out way to separate them
		// headerMapperList = repository.findAll();
		headerMapperList = mapperRepository.getByEntityType(EntityTypeEnum.HEADER.getValue());
		System.out.println("MapperService#initMapperList headerMapperList.size(): " + headerMapperList.size());
		
		orderMapperList = mapperRepository.getByEntityType(EntityTypeEnum.ORDER_LINE.getValue());
		System.out.println("MapperService#initMapperList orderMapperList.size(): " + orderMapperList.size());
		
		// split up ones for OrderH & OrderL
		Stream<MapperEntity> orderHMapperListStream = orderMapperList.stream();
		orderHMapperList = orderHMapperListStream.filter(m -> m.getFieldTableName().equalsIgnoreCase("orderh")).collect(Collectors.toList());
		System.out.println("orderHMapperList.size :" + orderHMapperList.size());
		orderHMapperListStream.close();
		
		Stream<MapperEntity> orderLMapperListStream = orderMapperList.stream();
		orderLMapperList = orderLMapperListStream.filter(m -> m.getFieldTableName().equalsIgnoreCase("orderl")).collect(Collectors.toList());
		System.out.println("orderLMapperList.size :" + orderLMapperList.size());
		orderLMapperListStream.close();
	}
	
	public static IEntity map(String line) {
		System.out.println("MapperService#map LINE:" + line);
		
		/* WHAT HAPPENS IF LINES DO NOT COME IN IN ORDER ??? */
		// if line starts w/ '1' is a header -> start new sequence number
		if(line.startsWith("1")) {
			return mapHeader(line);
		}
		// else its '2' so use header's sequence number
		else if(line.startsWith("2")) {
			return mapOrder(line);
		}
		
		return null;
	}
	
	private static HeaderEntity mapHeader(String line) {
		HeaderEntity headerEntity = new HeaderEntity();
		// increment sequence number before setting
		headerEntity.setSequenceNumber(sequenceNumber.incrementAndGet());
		
		// use headerMapperList
		
		return null;
	}
	
	private static OrderEntity mapOrder(String line) {
		System.out.println("   line: " + line);
		OrderEntity orderEntity = new OrderEntity();
		
		// populate OrderHEntity
		OrderHEntity orderHEntity = new OrderHEntity();
		orderHEntity.setSequenceNumber(sequenceNumber.get());
		
		setField(line, orderHEntity, orderHMapperList);
		
		// populate OrderLEntity
		OrderLEntity orderLEntity = new OrderLEntity();
		orderLEntity.setSequenceNumber(sequenceNumber.get());
		
		setField(line, orderLEntity, orderLMapperList);
		
		orderEntity.setOrderHEntity(orderHEntity);
		orderEntity.setOrderLEntity(orderLEntity);
		
		return orderEntity;
	}
	
	private static void setField(String line, AbstractEntity entity, List<MapperEntity> mapperEntityList) {
		for(MapperEntity mapperEntity : mapperEntityList) {
			// get the substring
			String subStringValue = line.substring(mapperEntity.getIndexStart(), (mapperEntity.getIndexStart() + mapperEntity.getIndexLength()));
			
			System.out.println("   subStringValue: " + subStringValue);
			
			// set on orderHEntity
			// - get field_title & remove any '_'
			String fieldTitle = mapperEntity.getFieldTitle();
			
			System.out.println("    fieldTitle: " + fieldTitle);
			
			Field objectField = entity.getField(fieldTitle);
			if(null != objectField) {
				try {
					setFieldOnEntity(objectField, entity, subStringValue);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					System.err.println("ERROR setting field value " + e.getMessage());
				}
			} else {
				System.err.println("FAILED to set " + entity.getClass() + "'" + fieldTitle +"' -- field not found in object");
			}
		}
	}

	private static void setFieldOnEntity(Field objectField, AbstractEntity entity, String subStringValue) throws IllegalArgumentException, IllegalAccessException {
		// TODO check nothing is null
		String fieldTypeName = objectField.getType().getCanonicalName();
		// can't use switch statement on Class
		
		System.out.println("   fieldType: " + fieldTypeName);
		switch(fieldTypeName) {
		case("java.lang.String"):
			System.out.println("STRING object type found");
			objectField.set(entity, subStringValue);
			break;
		case("java.lang.Integer"):
			System.out.println("INTEGER object type found");
			objectField.set(entity, new Integer(subStringValue));
			break;
		default:
			System.out.println("unknown object type found");
			break;
		}
	}
	
	// orderl
}
