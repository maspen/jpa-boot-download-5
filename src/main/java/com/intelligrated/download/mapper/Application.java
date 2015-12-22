package com.intelligrated.download.mapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.intelligrated.download.mapper.entity.AbstractEntity;
import com.intelligrated.download.mapper.entity.IEntity;
import com.intelligrated.download.mapper.entity.header.HeaderEntity;
import com.intelligrated.download.mapper.entity.mapper.MapperEntity;
import com.intelligrated.download.mapper.repo.MapperRepository;
import com.intelligrated.download.mapper.service.FileReaderService;
import com.intelligrated.download.mapper.service.MapperService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	MapperRepository repository;
	
	@Autowired
	FileReaderService fileReaderService;
	
	@Autowired
	MapperService mapperService;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
	@Override
	public void run(String... args) throws Exception {
		// for now, the only data in data.sql is header data
		List<MapperEntity> headerMapperList = repository.findAll();
		
		for (MapperEntity pojo : headerMapperList) {
			System.out.println(pojo.toString());
		}
		
		String downloadFilePath = fileReaderService.getDownloadFilePath();
		System.out.println("downloadFilePath: " + downloadFilePath);
		
		// read in 'download' file
//		Stream<String> lines = Files.lines(Paths.get(downloadFilePath));
//		// DOESN"T RETURN ANYTHING lines.forEach(line -> mapperService.map(line));
//		List<String> linesList = lines.filter(line -> !line.equalsIgnoreCase("")).collect(Collectors.toList());
//		
//		lines.close();
//		
//		for (String string : linesList) {
//			System.out.println(string);
//		}
		
		Stream<String> lines = Files.lines(Paths.get(downloadFilePath));
		
		/**
		 * uses Stream<String> from input file
		 * filters to ignore lines that are empty
		 * maps each line to MapperServices's map()
		 * collects results from map() into Collection which is a List<EPOrderEntity>
		 */
		List<IEntity> abstractEntityList = lines.filter(line -> !line.equalsIgnoreCase(""))
				.map(MapperService::map)
				.collect(Collectors.toList());
		
		// sanity check
		
		
		lines.close();
	}
    
//    @Bean
//    public CommandLineRunner demo(MapperRepository repository) {
//    	return (args) -> {
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
    		
//    		List<MapperEntity> pojoList = repository.getByRecordCode("1");
//    		
//    		for (MapperEntity pojo : pojoList) {
//				System.out.println(pojo.toString());
//			}
//    	};
//    }
}
