package com.lemon.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/**
 * 重试的监听类
 * @author 11646
 *
 */
public class RetryListener implements IAnnotationTransformer{
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		//IAnnotationTransformer可以动态的修改testng的注解属性
		//annotation-->注解对象
		//获取到retryAnalyzer属性
		IRetryAnalyzer iRetryAnalyzer = annotation.getRetryAnalyzer();
		//如果这个属性没有设置的话，为空,只会在@Test里面有
		if (iRetryAnalyzer == null) {
			//设置属性
			annotation.setRetryAnalyzer(TestngRetry.class);
		}
		
		
	}
	

}
