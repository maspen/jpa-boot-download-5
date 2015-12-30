package com.intelligrated.download.mapper.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intelligrated.download.mapper.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class FileReaderServiceTest {
	@Autowired
	FileReaderService fileReaderService;
	
	final String validTestFileName = "file-reader-service-test-file.txt";
	
	@Before
	public void setup() {
		assertThat(fileReaderService, is(not(nullValue())));
	}
	
	@Test
	public void returnNullWhenFileDoesNotExist() {
		String nullFilePath = null;
		fileReaderService.setDownloadFileName("fooBar.txt");
		nullFilePath = fileReaderService.getContextDownloadFilePath();
		assertThat(nullFilePath, is(nullValue()));
	}
	
	@Test
	public void throwsIllegalArgumentExceptionWhenFileNameIsNull() {
		fileReaderService.setDownloadFileName(null);
		try {
			fileReaderService.getContextDownloadFilePath();			
		} catch (Exception e) {
			assertThat(e, is(not(nullValue())));
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	@Test
	public void validFileNameReturnsFilePath() {
		fileReaderService.setDownloadFileName(validTestFileName);
		String validFilePath = fileReaderService.getContextDownloadFilePath();
		Assert.assertTrue(new File(validFilePath).exists());
		Assert.assertFalse(new File(validFilePath).isDirectory());
	}
}
