package com.intelligrated.download.mapper.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;

import com.intelligrated.download.mapper.AbstractIntegrationTest;
import com.intelligrated.download.mapper.ApplicationConfig;

@ContextConfiguration(classes = ApplicationConfig.class)
public class MapperHeaderRepositoryIntTestUsingHOTDataOutOfOrder extends AbstractIntegrationTest {
	@Autowired
	MapperHeaderRepository repository;
	
	/**
	 * populates H2 db from src/test/resources/test-HOT-out-of-order-data.sql
	 */
	@Override
	protected ClassPathResource getClassPathResource() {
		return new ClassPathResource("test-HOT-out-of-order-data.sql");
	}
	
	@Test
	public void getAllRecordsEnsureStartIndexOutOfOrder() {
		List<MapperHeaderEntity> entityList = repository.getByRecordCode("1");
		Assert.assertNotNull(entityList);
		Assert.assertEquals(17, entityList.size());
		
		Assert.assertFalse(listOutOfOrder(entityList));
	}
	
	private boolean listOutOfOrder(List<MapperHeaderEntity> list) {
		List<MapperHeaderEntity> tempList = new ArrayList<MapperHeaderEntity>(list);
		Collections.sort(tempList, new MapperEntityIndexStartComparator());
		return tempList.equals(list);
	}
	
	class MapperEntityIndexStartComparator implements Comparator<MapperHeaderEntity> {

		@Override
		public int compare(MapperHeaderEntity o1, MapperHeaderEntity o2) {
			return o1.getIndexStart().compareTo(o2.getIndexStart());
		}
		
	}
}
