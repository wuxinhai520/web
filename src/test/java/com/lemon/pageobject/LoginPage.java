package com.lemon.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lemon.base.BasePage;
import com.lemon.testcase.LoginTest;
import com.lemon.util.BrowserUtil;

public class LoginPage extends BasePage{
	//手机号输入框
	private By mobilephoneBy = By.name("phone");
	//密码输入框
	private By passwordBy = By.name("password");
	//登录按钮
	private By loginButtonBy = By.xpath("//button[text()='登录']");
	//此账号没有经过授权，请联系管理员!
	private By errorTipsBy =By.className("layui-layer-content");
	//请输入手机号
	private By formErrorInfpBy = By.xpath("//div[@class='form-error-info']");
	//退出按钮
	private By logOutBy = By.xpath("//a[text()='退出']");
	
	//获取手机号码输入框的value值
	public String getMobilephoneValue(){
		return getElementAttribute(mobilephoneBy, "value");
	}
	
	/**
	 * 获取“此账号没有经过授权，请联系管理员!”
	 * @return
	 */
	public String getErrorTips(){
		return getElementText(errorTipsBy);
	}
	
	public String getFromErrorInfo(){
		return getElementText(formErrorInfpBy);
	}
	
	public void inputMobilephone(String mobilephone){
		type(mobilephoneBy, mobilephone);

	}
	
	
	public void inputPassword(String password){
		type(passwordBy, password);
	
	}
	
	public void clickLoginButton(){
		click(loginButtonBy);

	}
	
	public void clickLogOut(){
		click(logOutBy);
	}
	

}
