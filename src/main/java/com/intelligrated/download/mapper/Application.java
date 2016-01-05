package com.intelligrated.download.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.intelligrated.download.mapper.entity.MapperEntity;
import com.intelligrated.download.mapper.service.MapperService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private MapperService mapperService;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		List<MapperEntity> mapperEntities = mapperService.getMappers();
		
		System.out.println("number mapper entities from list: " + mapperEntities.size());
	}
}
