package com.intelligrated.download.mapper.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.intelligrated.download.mapper.entity.header.HeaderEntity;

public interface HeaderRepository extends CrudRepository<HeaderEntity, Long> {
	// 'save' comes for free
	
	List<HeaderEntity> findAll();
	
	// getBySequenceNumber
}
