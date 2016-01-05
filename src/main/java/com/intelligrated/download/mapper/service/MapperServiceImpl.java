package com.intelligrated.download.mapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.intelligrated.download.mapper.entity.MapperEntity;
import com.intelligrated.download.mapper.repo.MapperRepository;

@Component("mapperService")
@Transactional
public class MapperServiceImpl implements MapperService {

	private final MapperRepository mapperRepository;
	
	@Autowired
	public MapperServiceImpl(MapperRepository mapperRepository) {
		this.mapperRepository = mapperRepository;
	}

	@Override
	public List<MapperEntity> getMappers() {
		return mapperRepository.findAll();
	}
}
