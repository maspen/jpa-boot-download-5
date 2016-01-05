package com.intelligrated.download.mapper.repo;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intelligrated.download.mapper.Application;
import com.intelligrated.download.mapper.entity.EntityTypeEnum;
import com.intelligrated.download.mapper.entity.MapperEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MapperRepositoryTest {
	@Autowired
	private MapperRepository mapperRepository;
	
	private MapperEntity mapperEntity;
	
	@Before
	public void setup() {
		mapperEntity = new MapperEntity();
		mapperEntity.setEntityType(Integer.valueOf(1));
		mapperEntity.setFieldName("field name");
		mapperEntity.setFieldTitle("field title");
		mapperEntity.setFieldTableName("field table name");
		mapperEntity.setIndexLength(Integer.valueOf(0));
		mapperEntity.setIndexLength(Integer.valueOf(9));
		mapperEntity.setDataType("String");
		mapperEntity.setRecordCode("REC123456");
	}
	
	@Test
	@Transactional
	public void saveCreatesId() {
		assertThat(mapperEntity.getId(), is(nullValue()));
		MapperEntity savedEntity = mapperRepository.save(mapperEntity);
		assertThat(savedEntity.getId(), is(not(nullValue())));
	}
	
	@Test
	public void getByEntityType() {
		assertThat(mapperRepository.getByEntityType(EntityTypeEnum.HEADER.getValue()), is(not(nullValue())));
		assertThat(mapperRepository.getByEntityType(EntityTypeEnum.ORDER_LINE.getValue()), is(not(nullValue())));
	}
}
