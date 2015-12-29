package com.intelligrated.download.mapper.config;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intelligrated.download.mapper.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class HeaderConfigTest {
	/** 
	 * TODO: be good to pull these in from application.properties
	 * vs hard-coding since could change
	 * */
	String url = "jdbc:h2:mem:headers";

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void checkHeadersDbCreated() throws SQLException {
		Assert.assertNotNull(dataSource);
		DatabaseMetaData databaseMetaData = null;
		try {
			databaseMetaData = dataSource.getConnection().getMetaData();
		} catch (SQLException e) {
			Assert.assertNull(e);
		}
		Assert.assertNotNull(databaseMetaData);
		
		Assert.assertEquals(url, databaseMetaData.getURL());
	}
}
