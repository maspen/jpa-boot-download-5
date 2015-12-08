package com.intelligrated.download.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intelligrated.download.mapper.ApplicationConfig;
import com.intelligrated.download.mapper.entity.MapperHeaderRepository;

public class ApplicationConfigTest {

	@Test
	public void bootstrapApplicationJavaConfig() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Assert.assertNotNull(context);
		Assert.assertNotNull(context.getBean(MapperHeaderRepository.class));
	}
	
	@Test
	public void bootstrapApplicationXmlConfig() {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/application-context.xml");
		Assert.assertNotNull(context);
		Assert.assertNotNull(context.getBean(MapperHeaderRepository.class));
	}
}
