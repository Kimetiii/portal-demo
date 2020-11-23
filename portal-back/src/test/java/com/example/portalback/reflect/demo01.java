package com.example.portalback.reflect;

/**
 * @author songsenior
 * @date 2020/11/3 10:39
 * @Description: Java Reflection
 */
public class demo01 {

	public static void main(String[] args) {
		int[] A = {1, 3, 2};
		boolean b = validMountainArray(A);
		System.err.println(b);
	}

	/**
	 * 判断山脉数组
	 *
	 * @param A 入参数组
	 * @return 布尔返回
	 */
	public static boolean validMountainArray(int[] A) {
		// 记录长度
		int len = A.length;
		// 记录索引
		int i = 0;
		// 1. 从左向右移动元素 需要满足升序
		while (i + 1 < len && A[i] < A[i + 1]) {
			i++;
		}
		// 2. 出现索引仍旧为0（递增） 或者索引为尾（递减）
		if (i == 0 || i == len - 1) {
			return false;
		}
		// 3. 继续从左向右移动元素 需要满足降序
		while (i + 1 < len && A[i] > A[i + 1]) {
			i++;
		}
		return i == len - 1;
	}
}
