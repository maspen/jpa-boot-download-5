package com.intelligrated.download.mapper.entity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

public class Order_H_EntityTest {
	private Order_H_Entity entity;
	
	private String dbFieldName = "seq_num";
	private String javaFieldName = "seqNum";
	
	@Test
	public void checkGetFieldFromAbstractClass() throws NoSuchFieldException, SecurityException {
		entity = new Order_H_Entity();
		
		Field javaField = entity.getField(dbFieldName);
		assertThat(javaField, is(not(nullValue())));
		Assert.assertTrue(javaField.getName().equals(javaFieldName));
	}
}
