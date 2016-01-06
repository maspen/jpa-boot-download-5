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

import com.intelligrated.download.mapper.entity.IEntity;
import com.intelligrated.download.mapper.entity.MapperEntity;
import com.intelligrated.download.mapper.service.FileReaderService;
import com.intelligrated.download.mapper.service.MapperService;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private MapperService mapperService;
	
	@Autowired
	private FileReaderService fileReaderService;
	
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
		List<List<IEntity>> entityList = lines.filter(line -> !line.equalsIgnoreCase(""))
				.map(MapperService::map)
				.collect(Collectors.toList());
		
		// TODO: persist into appropriate tables contents of entityList
		
		lines.close();
		
		// TODO: find out what is running/hanging that prevents app. from exiting w/o this
		System.exit(1);
	}
}
