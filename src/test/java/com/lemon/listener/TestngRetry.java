package com.lemon.listener;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * 重试机制
 * @author 11646
 *
 */
public class TestngRetry implements IRetryAnalyzer{
	private Logger logger = Logger.getLogger(TestngRetry.class);
	//规定重试次数最多跑多少次
	private int maxRetryCount = 2;
	//实例化threadLocal变量，里面存储的是当前的重试次数
	private static ThreadLocal<Integer> retryThreadLocal = new ThreadLocal<>();
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		//默认返回为false就表示不会执行重试机制
		if (getRetryCount() <= maxRetryCount) {
			logger.info("当前的重试次数:"+getRetryCount());
			//选取从ThreadLocal区域取得重试次数，再来加1
			int currentRetryCount = getRetryCount();
			currentRetryCount++;
			//保存ThreadLocal区域
			setRetryCount(getRetryCount());
			return true;
		}else {
			return false;
		}
	}
	
	public static void setRetryCount(Integer retryCount){
		retryThreadLocal.set(retryCount);
	}
	
	public static Integer getRetryCount(){
		return retryThreadLocal.get();
	}

}
