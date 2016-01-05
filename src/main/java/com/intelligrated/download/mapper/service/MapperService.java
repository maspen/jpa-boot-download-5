package com.intelligrated.download.mapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligrated.download.mapper.entity.MapperEntity;
import com.intelligrated.download.mapper.repo.MapperRepository;

@Service("mapperService")
//@Transactional -- prevents from autowiring in Application
public class MapperService {

	private final MapperRepository mapperRepository;
	
	@Autowired
	public MapperService(MapperRepository mapperRepository) {
		this.mapperRepository = mapperRepository;
	}

	public List<MapperEntity> getMappers() {
		return mapperRepository.findAll();
	}
}
