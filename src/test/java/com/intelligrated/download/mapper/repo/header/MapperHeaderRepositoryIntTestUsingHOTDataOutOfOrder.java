package com.intelligrated.download.mapper.repo.header;

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
import com.intelligrated.download.mapper.entity.header.MapperHeaderEntity;
import com.intelligrated.download.mapper.repo.header.MapperHeaderRepository;

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
	
	/**
	 * the .sql file contains records with 'index start' that are not sequentially in order (on 
	 * purpose). this just check that when this file is loaded, this is the case.
	 */
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
	
	/**
	 * Want to test {@link MapperHeaderRepository#getByRecordCodeOrderByIndexStart(String)}
	 * to ensure that even an out-of-order file that creates the db will not prevent
	 * entities from being returned in index start order.
	 */
	@Test
	public void getByRecordCodeOrderedByIndexStart() {
		List<MapperHeaderEntity> entityList = repository.getByRecordCodeOrderByIndexStart("1");
		Assert.assertTrue(listOutOfOrder(entityList));
	}
}
