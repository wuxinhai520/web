package com.lemon.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lemon.base.BasePage;
import com.lemon.util.BrowserUtil;

/**
 * 首页页面对象
 * @author 11646
 *
 */
public class IndexPage extends BasePage{
	//我的账户元素定位
	private By myAccountBy = By.xpath("//a[contains(text(),'我的帐户')]");
	//退出元素定位
	private By quitBy = By.xpath("//a[text()='退出']");
	//登录按钮元素定位
	private By loginBy = By.xpath("//a[text()='登录']");
	//抢投标元素定位
	
	public void clickRushToBid(String loanTitle){
		String locatorValue = "//span[contains(text(),'"+loanTitle+"')]/parent::div/parent::a/following-sibling::div[1]//a[text()='抢投标']";;
		click(By.xpath(locatorValue));
	}

	
	public void clickQuit(){
		click(quitBy);
	}
	
	public void clickLogin(){
		click(loginBy);
	}
	//获取myAccountBy元素文本值
	public String getMyAccountText(){
		return waitElementVisible(myAccountBy).getText();
		
	}
	//等待myAccountBy元素是否可见
	public boolean isMyaccountVisible(){
		return waitElementVisible(myAccountBy).isDisplayed();
	}
	


}
