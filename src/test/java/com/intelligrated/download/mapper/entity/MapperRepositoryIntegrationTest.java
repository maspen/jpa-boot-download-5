package com.intelligrated.download.mapper.entity;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.intelligrated.download.mapper.AbstractIntegrationTest;
import com.intelligrated.download.mapper.ApplicationConfig;
import com.intelligrated.download.mapper.entity.MapperEntity;
import com.intelligrated.download.mapper.entity.MapperRepository;

@ContextConfiguration(classes = ApplicationConfig.class)
public class MapperRepositoryIntegrationTest extends AbstractIntegrationTest {
	@Autowired
	MapperRepository repository;
	
	@Test
	public void getByRecordCode() {
		List<MapperEntity> entityList = repository.getByRecordCode("1");
		Assert.assertNotNull(entityList);
		Assert.assertEquals(9, entityList.size());
	}
	
	@Test
	public void getByTableName() {
		List<MapperEntity> entityList = repository.getByFieldTableName("order");
		Assert.assertNotNull(entityList);
		Assert.assertEquals(3, entityList.size());
	}
	
	@Test
	public void getByIndexStart() {
		List<MapperEntity> entityList = repository.getByIndexStart(Integer.valueOf(1));
		Assert.assertNotNull(entityList);
		Assert.assertEquals(3, entityList.size());
	}
	
	@Test
	public void getByIndexLength() {
		List<MapperEntity> entityList = repository.getByIndexLength(Integer.valueOf(6));
		Assert.assertNotNull(entityList);
		Assert.assertEquals(2, entityList.size());
	}
}
