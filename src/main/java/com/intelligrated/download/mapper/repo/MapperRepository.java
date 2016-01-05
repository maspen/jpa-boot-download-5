package com.intelligrated.download.mapper.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intelligrated.download.mapper.entity.MapperEntity;

public interface MapperRepository extends JpaRepository<MapperEntity, Long> {
	List<MapperEntity> getByEntityType(Integer type);
}
