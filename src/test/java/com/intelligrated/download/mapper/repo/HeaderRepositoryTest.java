package com.intelligrated.download.mapper.repo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intelligrated.download.mapper.Application;
import com.intelligrated.download.mapper.entity.HeaderEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class HeaderRepositoryTest {

	@Autowired
	private HeaderRepository headerRepository;
	
	private HeaderEntity headerEntity;
	
	@Before
	public void setup() {
		headerEntity = new HeaderEntity();
		headerEntity.setSeqNum(Integer.valueOf(123434));
		headerEntity.setComment1("comment 1");
		headerEntity.setComment2("comment 2");
		headerEntity.setDlBatch("dl batch");
		headerEntity.setcOrderNbr("c order number");
		headerEntity.setMiscField1("misc field 1");
		headerEntity.setComment3("comment 3");
		headerEntity.setComment4("comment 4");
		headerEntity.setComment5("comment 5");
		headerEntity.setComment6("comment 6");
		headerEntity.setComment8("comment 8");
		headerEntity.setOrderNumber("order number");
		headerEntity.setCartonId("carton id");
		headerEntity.setMiscInt1(Integer.valueOf(5768696));
		headerEntity.setMiscField1("misc field 1");
		headerEntity.setMiscField2("misc field 2");
		headerEntity.setMiscField3("misc field 3");
		headerEntity.setComment9("comment 9");
	}
	
	@Test
	@Transactional
	public void saveCreatesId() {
		assertThat(headerEntity.getId(), is(nullValue()));
		HeaderEntity savedEntity = headerRepository.save(headerEntity);
		assertThat(savedEntity.getId(), is(not(nullValue())));
	}
}
