package com.example.portalback.common.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
class CosUtilsTest {

    @Test
    void saveImg() throws IOException {

        Path imgPath = Paths.get("E:\\Daily\\daily-back\\src\\main\\resources\\static\\test.png");

        String url = CosUtils.saveAvatar(imgPath);

        System.out.println(url);
    }

	@Test
	 void data() throws FileNotFoundException {
		File file=new File("D:\\test/变量_房抵贷变量.csv");
		ExcelReaderBuilder read = EasyExcel.read(file);
		System.out.println(read);
	}

}
