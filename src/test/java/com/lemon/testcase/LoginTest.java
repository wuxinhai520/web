package com.lemon.testcase;

import static org.testng.Assert.assertEquals;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lemon.base.BasePage;
import com.lemon.businessflow.LoginFlow;
import com.lemon.listener.TestngRetry;
import com.lemon.pageobject.IndexPage;
import com.lemon.pageobject.LoginPage;
import com.lemon.testdatas.LoginDatas;
import com.lemon.util.BrowserUtil;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;

import com.lemon.testdatas.Constant;

/**
 * 登录
 * @author 11646
 *
 */
public class LoginTest{
	
	@BeforeTest
	public void setUpTest(){
		//初始化重试次数为1
		TestngRetry.setRetryCount(1);
	}
	
	@Parameters({"broweName"})   //testng参数化
	@BeforeMethod
	public void setUp(String broweName){
		//前置准备
		//打开浏览器
		BrowserUtil.openBrowser(broweName);
		//访问登录地址
		BrowserUtil.getDriver().get(Constant.LOGIN_URL);
		//最大化浏览器窗口
		BrowserUtil.browserMaxmize();
	}
	
	@Test(description="手机号未注册",dataProviderClass=LoginDatas.class,dataProvider="getLoginErrorDatas")
	public void login_failure(String mobilephone,String password,String expectedValue){
		//实例化登录的业务流程
		LoginFlow loginFlow = new LoginFlow(mobilephone, password);
		loginFlow.Login();
		//4.断言
		LoginPage loginPage =new LoginPage();
		String actualValue = loginPage.getErrorTips();
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	@Test(description="手机号或密码错误",dataProviderClass=LoginDatas.class,dataProvider="getLoginFailureDatas")
	public void login_namenull(String mobilephone,String password,String expectedValue){
		//实例化登录的业务流程
		LoginFlow loginFlow = new LoginFlow(mobilephone, password);
		loginFlow.Login();
		//显示等待
		LoginPage loginPage =new LoginPage();
		String actualValue = loginPage.getFromErrorInfo();
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	@Test(description="正确的手机号和正确的密码登录")    //enabled=false  禁止运行 用于调试
	public void login_success() throws Exception{
		//实例化登录的业务流程
		LoginFlow loginFlow = new LoginFlow(LoginDatas.CORRECT_MOBILEPHONE, LoginDatas.CORRECT_PASSWORD);
		loginFlow.Login();
		//4.断言
		//4.1判断URL是否为首页
		Thread.sleep(2000);
		String actualValue = BrowserUtil.getDriver().getCurrentUrl();
		String expectedValue = Constant.INDEX_URL;
		Assert.assertEquals(actualValue, expectedValue);
		
		//4.2判断首页是否有出现我的账户元素
		//显示等待   条件：元素可见
		IndexPage indexPage = new IndexPage();
		Assert.assertTrue(indexPage.isMyaccountVisible());
		//5.截图
		//BrowserUtil.takeScreenshot("D:\\screenshot1.png");
	}
	
	@Test(description="记住手机号码功能验证")
	public void remeberMobilephone(){
		//实例化登录的业务流程
		LoginFlow loginFlow = new LoginFlow(LoginDatas.CORRECT_MOBILEPHONE, LoginDatas.CORRECT_PASSWORD);
		loginFlow.Login();
		//点击首页退出
		loginFlow.indexQuitLogin();
		//点击首页的登录按钮
		loginFlow.indexClickLogin();
		//断言:获取到手机号码输入框value属性
		LoginPage loginPage =new LoginPage();
		String actualValue = loginPage.getMobilephoneValue();
		String expectedValue = LoginDatas.CORRECT_MOBILEPHONE;
		Assert.assertEquals(actualValue, expectedValue);
		//截图
		//BrowserUtil.takeScreenshot();
	}
	
	@AfterMethod
	public void tearDown(){
		//资源销毁
		BrowserUtil.closeBrowser();
	}
	


}
