package com.lemon.listener;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.internal.TestResult;

import com.lemon.util.BrowserUtil;

import io.qameta.allure.Attachment;

/**
 * 测试用例结果监听
 * @author 11646
 *
 */
public class TestResultListener extends TestListenerAdapter{
	//TestListenerAdapter监听结果
	
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailure(tr);
		//做一些相关操作--截图
		//对所有的测试用例都生效
		//将截图保存到工程目录
		//saveScreenshot(BrowserUtil.takeScreenshot());
		//全部的重试运行完之后，用例结果是失败的，把currentRetryCount置为1
		TestngRetry.setRetryCount(1);
	}
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestSuccess(tr);
		//当执行第一次重试的时候，用例通过的时候
		//当执行第二次重试的时候，用例通过的时候
		TestngRetry.setRetryCount(1);

	}
}
