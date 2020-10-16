package com.example.portalback.drools;

import com.example.portalback.common.util.FileUtils;
import org.junit.jupiter.api.Test;

/**
 * @author songsenior
 * @date 2020/9/3 14:47
 * @Description:
 */
public class CEPTest {
	@Test
	public void test(){
		boolean b = FileUtils.deleteFile("D:\\test/111.txt");
	}

}
