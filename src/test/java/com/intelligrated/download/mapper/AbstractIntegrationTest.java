package com.intelligrated.download.mapper;

import java.sql.Connection;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public abstract class AbstractIntegrationTest {
	@Autowired
	DataSource dataSource;
	
	/**
	 * populates H2 db from src/test/resources/test-data.sql
	 */
//	static String resourcePath = "test-data.sql";
	ClassPathResource classpathResource = new ClassPathResource("test-data.sql");
	
//	static {
//		setClasspathResourcePath(resourcePath);
//	}
	
	@Before
	public void setup() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		//populator.addScript(new ClassPathResource("test-data.sql"));
		
		populator.addScript(getClassPathResource());
		Connection connection = null;
		
		try {
			connection = DataSourceUtils.getConnection(dataSource);
			populator.populate(connection);			
		} catch (Exception e) {
			Assert.assertNull(e);
		} finally {
			if(connection != null) {
				DataSourceUtils.releaseConnection(connection, dataSource);
			}
		}
	}
	
	protected ClassPathResource getClassPathResource() {
		return classpathResource;
	}
}
