package com.lemon.businessflow;

import com.lemon.pageobject.IndexPage;
import com.lemon.pageobject.LoginPage;
import com.lemon.testdatas.LoginDatas;

/**
 * 登录业务流程封装
 * @author 11646
 *
 */
public class LoginFlow {
	
	private String mobilephone;
	private String password;
	
	//对象的数据怎么进行初始化
	//1.有参构造
	//2.set方法
	public LoginFlow (String mobilephone,String password){
		this.mobilephone=mobilephone;
		this.password=password;
	}
	
	public LoginFlow(){
		
	}
	
	/**
	 * 登录业务流程
	 */
	public void Login(){
		
		LoginPage loginPage = new LoginPage();
		loginPage.inputMobilephone(mobilephone);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
	}
	
	/**
	 * 首页退出登录的业务流程
	 */
	public void indexQuitLogin(){
		//点击首页的退出
		IndexPage indexPage = new IndexPage();
		indexPage.clickQuit();
	}
	
	/**
	 * 首页点击登录的业务流程
	 */
	public void indexClickLogin(){
		//点击首页登录
		IndexPage indexPage = new IndexPage();
		indexPage.clickLogin();
	}


}
