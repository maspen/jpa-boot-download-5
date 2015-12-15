package com.intelligrated.download.mapper.repo;

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
import com.intelligrated.download.mapper.entity.mapper.MapperEntity;
import com.intelligrated.download.mapper.repo.MapperRepository;

@ContextConfiguration(classes = ApplicationConfig.class)
public class MapperRepositoryIntTestUsingHOTDataOutOfOrder extends AbstractIntegrationTest {
	@Autowired
	MapperRepository repository;
	
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
		List<MapperEntity> entityList = repository.getByRecordCode("1");
		Assert.assertNotNull(entityList);
		Assert.assertEquals(17, entityList.size());
		
		Assert.assertFalse(listOutOfOrder(entityList));
	}
	
	private boolean listOutOfOrder(List<MapperEntity> list) {
		List<MapperEntity> tempList = new ArrayList<MapperEntity>(list);
		Collections.sort(tempList, new MapperEntityIndexStartComparator());
		return tempList.equals(list);
	}
	
	class MapperEntityIndexStartComparator implements Comparator<MapperEntity> {

		@Override
		public int compare(MapperEntity o1, MapperEntity o2) {
			return o1.getIndexStart().compareTo(o2.getIndexStart());
		}
	}
	
	/**
	 * Want to test {@link MapperRepository#getByRecordCodeOrderByIndexStart(String)}
	 * to ensure that even an out-of-order file that creates the db will not prevent
	 * entities from being returned in index start order.
	 */
	@Test
	public void getByRecordCodeOrderedByIndexStart() {
		List<MapperEntity> entityList = repository.getByRecordCodeOrderByIndexStart("1");
		Assert.assertTrue(listOutOfOrder(entityList));
	}
}
