package com.intelligrated.download.mapper.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class FileReaderService {
	@Autowired
	ApplicationContext context;
	
	final String downloadFileName = "classpath:test-download-header-order-file.txt";//"classpath:test-download-header-file.txt";
	
	public String getDownloadFilePath() {
		 String filePath = null;
		try {
			filePath = context.getResource(downloadFileName).getFile().getPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}
}
