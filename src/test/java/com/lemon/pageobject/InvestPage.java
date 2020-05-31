package com.lemon.pageobject;

import org.openqa.selenium.By;

import com.lemon.base.BasePage;

/**
 * 
 * 投资的元素封装
 * @author 11646
 *
 */
public class InvestPage extends BasePage{
	//投资金额输入框元素
	private By investAmountBy = By.className("invest-unit-investinput");
	//投标按钮
	private By bidBy = By.xpath("//button[text()='投标']");
	//投标成功的元素定位
	private By invsetSuccessBy = By.xpath("//div[@class='layui-layer-content']//div[@class='capital_font1 note']");
	//请输入10的倍数
	private By notMultipleBy = By.xpath("//button[@class='btn btn-special height_style']");
	
	public void investAmount(double data){
		type(investAmountBy, data+"");
	}
	
	public void clickBid(){
		click(bidBy);
	}
	
	public void invsetSuccess(){
		click(invsetSuccessBy);
	}
	
	public String getInvestSuccessText(){
		return getElementText(invsetSuccessBy);
	}
	
	public String getNotMultipleText(){
		return getElementText(notMultipleBy);
	}

}
