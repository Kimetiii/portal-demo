package com.example.portalback.common.util;

import java.util.UUID;

public class CustomUtils {

	/**
	 * 生成一个去符号的uuid
	 *
	 * @return String
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
