package com.intelligrated.download.mapper;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.intelligrated.download.mapper.entity.MapperEntity;
import com.intelligrated.download.mapper.repo.MapperRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public CommandLineRunner demo(MapperRepository repository) {
    	return (args) -> {
    		// the data is pulled from src/main/resources/data.sql
//    		MapperEntity one = new MapperEntity();
//    		one.setId(Long.valueOf(1));
//    		one.setFieldName("sku");
//    		one.setFieldName("SKU");
//    		one.setFieldTableName("header");
//    		one.setIndexStart(1);
//    		one.setIndexLength(5);
//    		one.setDataType("integer");
//    		one.setRecordCode("1");
//    		
//    		repository.save(one);
    		
    		List<MapperEntity> pojoList = repository.getByRecordCode("1");
    		
    		for (MapperEntity pojo : pojoList) {
				System.out.println(pojo.toString());
			}
    	};
    }
}
