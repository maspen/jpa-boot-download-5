package com.intelligrated.download.mapper.entity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MapperRepository extends CrudRepository<MapperEntity, Long> {
	
	List<MapperEntity> getByRecordCode(String recordCode);
	
	List<MapperEntity> getByFieldTableName(String fieldTableName);
	
	List<MapperEntity> getByIndexStart(Integer indexStart);
	
	List<MapperEntity> getByIndexLength(Integer indexLength);
}
