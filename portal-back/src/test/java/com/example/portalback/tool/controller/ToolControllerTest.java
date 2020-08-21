package com.example.portalback.tool.controller;

import com.example.portalback.tool.core.ToolManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
class ToolControllerTest {

	@Autowired
	private ToolManager toolManager;

	@Test
	void uploadFile() throws IOException {
		InputStream inputStream = new FileInputStream(new File("/Users/lin/Documents/workspace/Daily/daily-back/src/main/resources/static/test.png"));
		MultipartFile multipartFile = new MockMultipartFile("test.png", "test.png", null, inputStream);

		String file = toolManager.uploadFile(multipartFile);

		System.out.println(file);

	}

	@Test
	void testEnum() {

	}
}