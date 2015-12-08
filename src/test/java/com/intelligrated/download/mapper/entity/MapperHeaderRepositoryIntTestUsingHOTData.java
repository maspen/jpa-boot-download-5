package com.intelligrated.download.mapper.entity;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;

import com.intelligrated.download.mapper.AbstractIntegrationTest;
import com.intelligrated.download.mapper.ApplicationConfig;

@ContextConfiguration(classes = ApplicationConfig.class)
public class MapperHeaderRepositoryIntTestUsingHOTData extends AbstractIntegrationTest {

	@Autowired
	MapperHeaderRepository repository;
	
	/**
	 * populates H2 db from src/test/resources/test-HOT-data.sql
	 */
	@Override
	protected ClassPathResource getClassPathResource() {
		return new ClassPathResource("test-HOT-data.sql");
	}
	
	@Test
	public void getByRecordCode() {
		List<MapperHeaderEntity> entityList = repository.getByRecordCode("1");
		Assert.assertNotNull(entityList);
		Assert.assertEquals(17, entityList.size());
	}
}
