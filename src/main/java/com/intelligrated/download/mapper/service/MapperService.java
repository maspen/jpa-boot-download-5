package com.intelligrated.download.mapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligrated.download.mapper.entity.EntityTypeEnum;
import com.intelligrated.download.mapper.entity.MapperEntity;
import com.intelligrated.download.mapper.repo.MapperRepository;

@Service("mapperService")
//@Transactional -- prevents from autowiring in Application
public class MapperService {

	private final MapperRepository mapperRepository;
	
	/**
	 * The "mappers" repo (h2) contains mapping for both
	 * header entities and order entities. This splits
	 * them up (based on 'type' see {@link EntityTypeEnum})
	 */
	List<MapperEntity> headerMapperList;
	List<MapperEntity> orderMapperList;
	
	@Autowired
	public MapperService(MapperRepository mapperRepository) {
		this.mapperRepository = mapperRepository;
		
		initializeMapperLists();
	}
	
	/**
	 * Pulls from mappers repo and sets up the two lists of mappings
	 */
	private void initializeMapperLists() {
		headerMapperList = mapperRepository.getByEntityType(EntityTypeEnum.HEADER.getValue());
		orderMapperList = mapperRepository.getByEntityType(EntityTypeEnum.ORDER_LINE.getValue());
		
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
