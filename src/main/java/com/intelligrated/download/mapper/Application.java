package com.intelligrated.download.mapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.intelligrated.download.mapper.entity.HeaderEntity;
import com.intelligrated.download.mapper.entity.IEntity;
import com.intelligrated.download.mapper.entity.MapperEntity;
import com.intelligrated.download.mapper.entity.Order_H_Entity;
import com.intelligrated.download.mapper.entity.Order_L_Entity;
import com.intelligrated.download.mapper.service.FileReaderService;
import com.intelligrated.download.mapper.service.MapperService;
import com.intelligrated.download.mapper.service.PersistenceService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private MapperService mapperService;
	
	@Autowired
	private FileReaderService fileReaderService;
	
	@Autowired
	private PersistenceService persistenceService;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		List<MapperEntity> mapperEntities = mapperService.getMappers();
		
		System.out.println("number mapper entities from list: " + mapperEntities.size());
		
		// get the 'download' file from context
		String downloadFilePath = fileReaderService.getContextDownloadFilePath();
		System.out.println("downloadFilePath: " + downloadFilePath);
		
		// create Stream for download file for reading in
		Stream<String> lines = Files.lines(Paths.get(downloadFilePath));
		
		// read in file one line at a time & pass to MapperService.map
		List<IEntity> entityList = lines.filter(line -> !line.equalsIgnoreCase(""))
				.map(MapperService::map)
				.collect(Collectors.toList()) // at this point, is List<List<IEntity>>
				.stream().flatMap(List::stream) // hear onward, 'flattens' List<List ... to List<IEntity>
				.collect(Collectors.toList());
		
		lines.close();
		
		// TODO: persist into appropriate tables contents of entityList
		entityList.stream().forEach((e) -> persistenceService.persist(e));
		
		// sanity check that got persisted
		Iterable<HeaderEntity> persistedHeaders = persistenceService.getHeaders();
		Iterable<Order_H_Entity> persistedOrderH = persistenceService.getOrderH();
		Iterable<Order_L_Entity> persistedOrderL = persistenceService.getOrderL();
		
		// TODO: find out what is running/hanging that prevents app. from exiting w/o this
		System.exit(1);
	}
}
