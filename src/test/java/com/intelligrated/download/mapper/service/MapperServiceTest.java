package com.intelligrated.download.mapper.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intelligrated.download.mapper.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class MapperServiceTest {
	@Autowired
	MapperService mapperService;
	
	final int expectedNumberHeaderMappers = 16;
	final int expectedNumberOrderLineMappers = 10;
	
	@Before
	public void setup() {
		assertThat(mapperService, is(not(nullValue())));
	}
	
	@Test
	public void onInitializationMapperListsCreated() {
		assertThat(mapperService.getHeaderMapperList(), is(not(nullValue())));
		Assert.assertTrue(mapperService.getHeaderMapperList().size() == expectedNumberHeaderMappers);
		
		assertThat(mapperService.getOrderMapperList(), is(not(nullValue())));
		Assert.assertTrue(mapperService.getOrderMapperList().size() == expectedNumberOrderLineMappers);
	}
}
