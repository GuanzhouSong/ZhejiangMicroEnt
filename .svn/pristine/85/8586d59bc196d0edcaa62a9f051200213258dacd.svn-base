package com.icinfo.cs.common.utils;

/**
 * sleep方法相关工具类
 * 
 * @author zhuyong
 */
public class SleepUtil {
	
	/**
	 * 让方法阻塞
	 * 解决spring定时并发问题
	 * 
	 * @author zhuyong
	 * @throws Exception
	 */
	public static void threadSleep() throws Exception{
		Thread.sleep((int) (300000 * Math.random()));
	}
	
	
	
	
	
	
	/**
	 * 测试
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		System.out.println("start");
		SleepUtil.threadSleep();
		System.out.println("end");
	}
}
