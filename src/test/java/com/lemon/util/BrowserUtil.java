package com.lemon.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserUtil {
	private static Logger logger = Logger.getLogger(BrowserUtil.class);
	
	private static ThreadLocal<WebDriver> driverthreadLocal = new ThreadLocal<>();
	
	/**
	 * 封装打开浏览器方法
	 * @param browserName
	 * @return
	 */
	public static void openBrowser(String browserName){
		logger.info("==================case执行开始==================");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			ChromeDriver chromeDriver = new ChromeDriver();
			//往threadLocal区域存储driver对象
			setDriver(chromeDriver);
			logger.info("打开【chrome】浏览器");
		}else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
			FirefoxDriver firefoxDriver = new FirefoxDriver();
			setDriver(firefoxDriver);
			logger.info("打开【firefox】浏览器");
		}else if (browserName.equals("ie")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//取消IE安全设置
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			//解决浏览器缩放问题
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			InternetExplorerDriver ieDriver = new InternetExplorerDriver(capabilities);
			setDriver(ieDriver);
			logger.info("打开【IE】浏览器");
		}
	}
	
	/**
	 * 从threadLocal区域里面取到driver对象
	 * @return
	 */
	public static WebDriver getDriver(){
		return driverthreadLocal.get();
	}
	
	/**
	 * 往threadLocal区域里面存储对象
	 * @param webDriver
	 */
	public static void setDriver(WebDriver webDriver){
		driverthreadLocal.set(webDriver);
	}
	
	/**
	 * 截图工具方法
	 */
	public static void takeScreenshot(String filePath){
		//类型强制转换
		TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
		//OutputType.FILE -->返回类型为File(图片)
		File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		//把file(图片)保存到本地
		//给一个目标地址的File对象
		File destFile = new File(filePath);
		//把原始file对象拷贝到目标地址对应的file对象中
		//第三方依赖commons
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static byte[] takeScreenshot(){
		//类型强制转换
		TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
		//OutputType.BYTES -->返回类型为byte[](图片)
		byte[] arr = takesScreenshot.getScreenshotAs(OutputType.BYTES);
		return arr;
	}
	
	/**
	 * 关闭浏览器
	 */
	public static void closeBrowser(){
		logger.info("==================case执行结束=================");
		getDriver().quit();
	}
	
	/**
	 * 浏览器最大化
	 */
	public static void browserMaxmize(){
		getDriver().manage().window().maximize();
		logger.info("浏览器最大化");
	}

}
