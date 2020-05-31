package com.lemon.listener;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import com.lemon.util.BrowserUtil;

import io.qameta.allure.Attachment;

public class AllureReportListener implements IHookable{
	//IHookable 运行的时候动态替换@Test注解
	@Override
	public void run(IHookCallBack callBack, ITestResult testResult) {
		// TODO Auto-generated method stub
		//会执行@Test注解对应的方法
		callBack.runTestMethod(testResult);
		if (testResult.getThrowable() != null) {
			//调用把截图嵌入到Allrue报表中的方法
			saveScreenshot(testResult.getName());
			//testResult.getName()  获取测试方法名字
			//getDescription()   获取用例描述
		}
	}
	
	@Attachment(value="methdName:{0}",type="image/png")
	public byte[] saveScreenshot(String methdName){
		return BrowserUtil.takeScreenshot();
	}

}
