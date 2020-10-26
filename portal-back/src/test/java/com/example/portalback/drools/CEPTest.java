package com.example.portalback.drools;

import com.example.portalback.common.util.FileUtils;
import org.junit.jupiter.api.Test;


import java.util.concurrent.locks.LockSupport;

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


	static Thread t1=null,t2=null;

	public static void main(String[] args) {

		char[] aI="1234567".toCharArray();
		char[] aC="ABCDEFG".toCharArray();

		t1=new Thread(()->{
			for (char c : aI) {
				System.out.println(c);
				LockSupport.unpark(t2); // 叫醒 T2
				LockSupport.park(); // T1 阻塞 当前线程阻塞
			}
		},"t1");

		t2=new Thread(()->{
			for (char c : aC) {
				LockSupport.park(); //t2 阻塞 当前线程阻塞
				System.out.println(c);
				LockSupport.unpark(t1); // 叫醒 t1
			}
		},"t2");


		t1.start();
		t2.start();
	}



}
