package com.intelligrated.download.mapper.config;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intelligrated.download.mapper.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MapperConfigTest {
	/** 
	 * TODO: be good to pull these in from application.properties
	 * vs hard-coding since could change
	 * */
	String url = "jdbc:h2:mem:mappers";
	
	/**
	 * Have to use context b/c there are multiple DataSources defined
	 */
	@Autowired
	ApplicationContext context;
	
	private DataSource mapperDataSource;
	
	@Before
	public void setup() {
		mapperDataSource = context.getBean("mapperDataSource", DataSource.class);
	}
	
	@Test
	public void checkMappersDbCreated() throws SQLException {
		Assert.assertNotNull(mapperDataSource);
		DatabaseMetaData databaseMetaData = null;
		try {
			databaseMetaData = mapperDataSource.getConnection().getMetaData();
		} catch (SQLException e) {
			Assert.assertNull(e);
		}
		Assert.assertNotNull(databaseMetaData);
		
		Assert.assertEquals(url, databaseMetaData.getURL());
	}
}
