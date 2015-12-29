package com.intelligrated.download.mapper.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intelligrated.download.mapper.entity.MapperEntity;

public interface MapperRepository extends JpaRepository<MapperEntity, Long> {

}
