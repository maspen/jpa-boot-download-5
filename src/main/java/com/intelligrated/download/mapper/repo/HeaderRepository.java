package com.intelligrated.download.mapper.repo;

import org.springframework.data.repository.CrudRepository;

import com.intelligrated.download.mapper.entity.HeaderEntity;

//public interface HeaderRepository<E extends IEntity> extends CrudRepository<E, Long> {
public interface HeaderRepository extends CrudRepository<HeaderEntity, Long> {
	
}
