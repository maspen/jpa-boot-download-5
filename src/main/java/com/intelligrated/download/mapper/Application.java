package com.intelligrated.download.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.intelligrated.download.mapper.entity.MapperEntity;
import com.intelligrated.download.mapper.repo.MapperRepository;

//@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	MapperRepository mapperRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// sanity check for data.sql
		long numberEntities = mapperRepository.count();
		System.out.println("number entities in mapperRepository: " + numberEntities);
		
		List<MapperEntity> mapperEntities = mapperRepository.findAll();
		System.out.println("number mapper entities from list: " + mapperEntities.size());
	}
}
