package com.jiang.test;

import org.apache.log4j.Logger;

public class Log4jTest {

	private static Logger logger = Logger.getLogger("这是一个测试Log4j的测试类Log4jTest");
	
	public static void main(String[] args) {
		//DEBUG < INFO < WARN < ERROR < FATAL
//		logger.fatal("fatal");
//		logger.error("这是一个错误的记录！");
//		logger.warn("warn");
//		logger.info("这是一个常规的记录！");
//		logger.debug("这是一个调试的记录！");
		int a = 0;
		System.out.println("-------------处理消息异常(开始)------------");
		logger.error("消息体");
		logger.info("阿斯顿发放"+a);
		System.out.println("-------------处理消息异常(结束)------------");
		
	}
	
}
