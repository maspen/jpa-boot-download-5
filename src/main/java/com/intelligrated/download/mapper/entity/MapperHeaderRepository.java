package com.intelligrated.download.mapper.entity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MapperHeaderRepository extends CrudRepository<MapperHeaderEntity, Long> {
	
	List<MapperHeaderEntity> getByRecordCode(String recordCode);
	
	List<MapperHeaderEntity> getByFieldTableName(String fieldTableName);
	
	List<MapperHeaderEntity> getByIndexStart(Integer indexStart);
	
	List<MapperHeaderEntity> getByIndexLength(Integer indexLength);
	
	List<MapperHeaderEntity> getByRecordCodeOrderByIndexStart(String recordCode);
}
