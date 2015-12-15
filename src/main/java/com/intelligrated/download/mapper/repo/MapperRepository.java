package com.intelligrated.download.mapper.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.intelligrated.download.mapper.entity.mapper.MapperEntity;

public interface MapperRepository extends CrudRepository<MapperEntity, Long> {
	
	List<MapperEntity> findAll();
	
	// TODO: get for header only data
	// TODO: get for order line only data
	// ...
	List<MapperEntity> getByEntityType(Integer type);
	
	List<MapperEntity> getByRecordCode(String recordCode);
	
	List<MapperEntity> getByFieldTableName(String fieldTableName);
	
	List<MapperEntity> getByIndexStart(Integer indexStart);
	
	List<MapperEntity> getByIndexLength(Integer indexLength);
	
	List<MapperEntity> getByRecordCodeOrderByIndexStart(String recordCode);
}
