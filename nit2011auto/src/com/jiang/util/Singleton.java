package com.jiang.util;


/**
 * 
 * @功能概要：高并发下的单例模式<br>
 * 			 	1、变量采用volatile修饰,保证其线程间的可见性；可见性指的是一个线程对变量的写操作对其他线程后续的读操作可见<br>
 * 				2、在两个或者更多的线程访问的成员变量上使用volatile。当要访问的变量已在synchronized代码块中，或者为常量时，不必使用。
 * 			 	3、创建实例采用DCL（Double check locking）+ synchronized<br>
 * 				4、这种实现方式既保证了其高效性，也保证了其线程安全性<br>
 * @项目名称： MDOS<br>
 * @初创作者： jiangxl  emil：836200494@qq.com <br>
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.<br>
 * @创建时间： 2016-11-8 下午3:46:28<br>
 */
public class Singleton {

	private volatile static Singleton singleton = null;//volatile可有可无

	private Singleton() {
	}

	public static Singleton getInstance() {
		
		System.out.println("--"+Thread.currentThread().getId()+"--"+"第一层"+singleton);
		
		if (singleton == null) {
			try {
				System.out.println("--"+Thread.currentThread().getId()+"--"+"第二层"+singleton);
				Thread.sleep(300);
				synchronized (Singleton.class) {
					System.out.println("--"+Thread.currentThread().getId()+"--"+"第三层"+singleton);
					if (singleton == null) {
						singleton = new Singleton();
						System.out.println("--"+Thread.currentThread().getId()+"--"+"第四层"+singleton.hashCode());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return singleton;

	}

}

class MyThread extends Thread {

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getId()+" 的hashCode码："+Singleton.getInstance().hashCode()); 
		
	}

	public static void main(String[] args) {
		
		 MyThread[] mts = new MyThread[100];  
	        for(int i = 0 ; i < mts.length ; i++){  
	            mts[i] = new MyThread();  
	        }  
	          
	        for (int j = 0; j < mts.length; j++) {  
	            mts[j].start();  
	        }
	}
	
}