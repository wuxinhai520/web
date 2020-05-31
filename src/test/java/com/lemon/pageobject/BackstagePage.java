package com.lemon.pageobject;

import org.openqa.selenium.By;

import com.lemon.base.BasePage;

public class BackstagePage extends BasePage{
	//用户名元素框定位
	private By userNameBy = By.name("admin_name");
	//密码元素框定位
	private By passwordBy = By.name("admin_pwd");
	//输入验证码
	private By verifycodeBy = By.name("code");
	//后台管理登录按钮
	private By backstageLoginBy = By.xpath("//button[@class='admin_login_btn denglu']");


	public void inputUserName(String data){
		type(userNameBy, data);
	}
	
	public void inputPassWord(String data){
		type(passwordBy, data);
	}
	
	public void inputVerifyCode(String data){
		type(verifycodeBy, data);
	}
	
	public void clickbackstageLogin(){
		click(backstageLoginBy);
	}
	
	
}
