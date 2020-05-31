package com.lemon.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lemon.businessflow.AddBidFlow;
import com.lemon.businessflow.InvestFlow;
import com.lemon.businessflow.LoginFlow;
import com.lemon.listener.TestngRetry;
import com.lemon.pageobject.BackstageIndexPage;
import com.lemon.pageobject.BackstagePage;
import com.lemon.pageobject.IndexPage;
import com.lemon.pageobject.InvestPage;
import com.lemon.pageobject.LoginPage;
import com.lemon.testdatas.InvestDatas;
import com.lemon.testdatas.LoginDatas;
import com.lemon.util.BrowserUtil;
import com.lemon.testdatas.Constant;


/**
 * 投资
 * @author 11646
 *
 */
public class InvestTest {
	public String loanTitle = "";
	
	@BeforeTest
	public void setUpTest(){
		//初始化重试次数为1
		TestngRetry.setRetryCount(1);
	}
	
	@BeforeSuite
	//数据准备前置
	public void setUpSuit() throws Exception{
		//1.项目的数据怎么创建
		//(1)通过接口来去创建数据（推荐） --数据准备，测试套件运行之前创建
		//(2)通过自动化在后台进行加标
		BrowserUtil.openBrowser("chrome");
		BrowserUtil.getDriver().get(Constant.BACKSTAGE_URL);
		BrowserUtil.browserMaxmize();
		addBid();
		BrowserUtil.closeBrowser();
		//2.账户的余额    
		//(1)测试套件允许之前充值一次
		//(2)自动化UI界面去充值
		
	}
	public void addBid() throws Exception{
		AddBidFlow addBidFlow = new AddBidFlow(loanTitle);
		addBidFlow.BackstageAddBid();
	}
	
	@Parameters({"broweName"})
	@BeforeMethod
	public void setUp(String broweName){
		//用例的前置
		BrowserUtil.openBrowser(broweName);
		BrowserUtil.getDriver().get(Constant.LOGIN_URL);
		BrowserUtil.getDriver().manage().window().maximize();
		//实例化登录的业务流程
		LoginFlow loginFlow = new LoginFlow(LoginDatas.CORRECT_MOBILEPHONE, LoginDatas.CORRECT_PASSWORD);
		loginFlow.Login();
	}
	
	@Test(description="正常金额输入验证",dataProviderClass=InvestDatas.class,dataProvider="getInvestNormalDatas")
	public void test_invest(double money,String expectedValue) throws Exception{
		//投资的业务流程
		InvestFlow investFlow = new InvestFlow(loanTitle, money);
		investFlow.chooseAndInvest();
		//3.投标成功的元素定位
		InvestPage investPage = new InvestPage();
		String actualValue = investPage.getInvestSuccessText();
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	
	@AfterMethod
	public void tearDown(){
		//资源销毁
		BrowserUtil.closeBrowser();
	}

}
