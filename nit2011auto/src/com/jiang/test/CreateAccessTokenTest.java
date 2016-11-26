package com.jiang.test;

import com.jiang.thread.AccessTokenThread;


public class CreateAccessTokenTest {
	
	public static void main(String[] args) {
		
		AccessTokenThread t  = new AccessTokenThread("A");
		AccessTokenThread t1 = new AccessTokenThread("B");
		AccessTokenThread t2 = new AccessTokenThread("C");
		
		Thread th = new Thread(t);
		th.start();
		Thread th1 = new Thread(t1);
		th1.setPriority(Thread.MAX_PRIORITY);	//设置优先级
		th1.start();
		Thread th2 = new Thread(t2);
		th2.start();
		
	}
	
}


