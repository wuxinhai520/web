package com.lemon.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lemon.util.BrowserUtil;

/**
 * 页面的父类
 * @author 11646
 *
 */
public class BasePage {
	private Logger logger = Logger.getLogger(BasePage.class);
	
	/**
	 * 封装的显示等待，等待元素是否可见
	 * @param by
	 */
	public WebElement waitElementVisible(By by){
		WebDriverWait webDriverWait = new WebDriverWait(BrowserUtil.getDriver(), 5);
		WebElement webElement = webDriverWait.until(ExpectedConditions.
				elementToBeClickable(by));
		return webElement;
	}
	
	/**
	 * 封装的显示等待,等待元素可被点击
	 * @param by
	 */
	public WebElement waitElementClickble(By by){
		WebDriverWait webDriverWait = new WebDriverWait(BrowserUtil.getDriver(), 5);
		WebElement webElement = webDriverWait.until(ExpectedConditions.
				visibilityOfElementLocated(by));
		return webElement;
	}
	
	/**
	 * 等待iframe可用，并且切换到iframe中
	 */
	public void waitIframeAndSwitch(By locator){
		WebDriverWait webDriverWait = new WebDriverWait(BrowserUtil.getDriver(), 5);
		webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	/*
	 * 点击操作
	 */
	public void click(By by){
		waitElementClickble(by).click();
		//日志
		logger.info("点击了元素【"+by+"】");
	}
	
	/*
	 * 输入数据
	 * **/
	public void type(By by,String data){
		waitElementVisible(by).sendKeys(data);
		//日志
		logger.info("给元素【"+by+"】输入了数据【"+data+"】");
	}
	
	/*
	 * 输入键值
	 * **/
	public void type(By by,Keys keys){
		waitElementVisible(by).sendKeys(keys);
		//日志
		logger.info("给元素【"+by+"】输入了键值【"+keys.toString()+"】");
	}
	
	/*
	 * 获取元素文本
	 */
	public String getElementText(By by){
		String text = waitElementVisible(by).getText();
		//日志
		logger.info("获取到元素【"+by+"】的文本值【"+text+"】");
		return text;
		
	}
	
	/*
	 * 获取元素属性值
	 * 
	 */
	public String getElementAttribute(By by,String attributeName){
		//日志
		WebElement webElement = waitElementVisible(by);
		String attributeValue = webElement.getAttribute(attributeName);
		logger.info("获取到元素【"+by+"】的属性名【"+attributeName+"】属性值【"+attributeValue+"】");
		return waitElementVisible(by).getAttribute(attributeName);
	}
}
