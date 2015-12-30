package com.intelligrated.download.mapper.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class FileReaderService {
	@Autowired
	ApplicationContext applicationContext;
	
	// for testing purposes in src/main/resources
	private String downloadFileName = "classpath:test-download-header-order-file.txt";
	
	/**
	 * Gets file path based on application context
	 * @return String file path
	 * 
	 * NOTE: throws IllegalArgumentException when file name is null.
	 */
	public String getContextDownloadFilePath() {
		String filePath = null;
		try {
			filePath = applicationContext.getResource(downloadFileName).getFile().getPath();
		} catch (IOException e) {
			System.err.println("failed to read file '" + downloadFileName +"' because: " + e.getMessage());
		}
		return filePath;
	}

	public String getDownloadFileName() {
		return downloadFileName;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}
}
