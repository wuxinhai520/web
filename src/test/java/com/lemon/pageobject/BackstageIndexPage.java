package com.lemon.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.lemon.base.BasePage;

public class BackstageIndexPage extends BasePage{
	//借款管理
	private By loanManageBy = By.xpath("//span[text()='借款管理']");
	//加标
	private By addBidBy = By.xpath("//span[text()='加标']");
	//借款人输入框
	private By brrowerBy = By.xpath("//td[text()='借款人:']/following-sibling::td//span/input[1]");
	//贷款人输入框
	private By loanTitleBy = By.xpath("//td[text()='贷款标题:']/following-sibling::td/input");
	//贷款年利率利息输入框
	private By rateBy = By.xpath("//td[text()='年利率利息:']/following-sibling::td/input");
	//借款期限的输入框
	private By loanTermBy = By.xpath("//td[text()='借款期限:']/following-sibling::td/input");
	//借款额度
	private By loanLimitBy = By.xpath("//td[text()='借款额度:']/following-sibling::td/input");
	//竞标期限输入框
	private By bidLimitBy = By.xpath("//td[text()='竞标期限:']/following-sibling::td/input");
	//iframe元素
	private By iframeBy = By.id("mainFrame");
	//风控评测
	private By riskControlBy = By.xpath("//span[text()='风控评测']");
	//评估价值
	private By evaluetionBy = By.xpath("//td[text()='评估价值:']/following-sibling::td/input");
	//项目录入
	private By projectImportBy = By.xpath("//span[text()='项目录入']");
	//籍贯
	private By nativePlaceBy = By.xpath("//td[text()='籍贯:']/following-sibling::td/input");
	//职业
	private By occupationBy = By.xpath("//td[text()='职业:']/following-sibling::td/input");
	//年龄
	private By ageBy = By.xpath("//td[text()='年龄:']/following-sibling::td/input");
	//登录按钮
	private By submitBy = By.xpath("//span[text()='提交']");
	//第一条数据的元素定位
	private By firstDataBy = By.id("datagrid-row-r1-1-0");
	//审核的元素定位
	private By verifyBy = By.xpath("//span[text()='审核']");
	//点击审核通过
	private By clickverifypassBy = By.xpath("//span[text()='审核通过']");
	
	public void clickVerifyPass(){
		click(clickverifypassBy);
	}
	
	public void clickVerrify(){
		click(verifyBy);
	}
	public void selectBid(String loantitle){
		String locatorValue = "//div[text()='"+loantitle+"']";
		click(By.xpath(locatorValue));
	}
	
	public void clickSubmit(){
		click(submitBy);
	}
	
	public void clickRiskControl(){
		click(riskControlBy);
	}
	
	public void inputEvaluetion(String data){
		type(evaluetionBy, data);
	}
	
	public void clickProjectImport(){
		click(projectImportBy);
	}
	
	public void inputNativePlace(String data){
		type(nativePlaceBy, data);
	}
	
	public void inputOccupation(String data){
		type(occupationBy, data);
	}
	
	public void inputAge(String data){
		type(ageBy, data);
	}
	
	public void clickLoanManage(){
		click(loanManageBy);
	}
	
	public void clickAddBid(){
		click(addBidBy);
	}
	
	public void inputBrrowerInfo(String data) throws Exception{
		type(brrowerBy, data);
		Thread.sleep(1000);
		//进行选择
		//输入键盘的方向下键
		type(brrowerBy, Keys.ARROW_DOWN);
		Thread.sleep(1000);
		//输入键盘的enter键
		type(brrowerBy, Keys.ENTER);
	}
	
	public void inputLoanTitle(String data){
		type(loanTitleBy, data);
	}
	
	public void inputRate(String data){
		type(rateBy, data);
	}
	
	public void inputlanTerm(String data){
		type(loanTermBy, data);
	}
	
	public void inputLoanLimit(String data){
		type(loanLimitBy, data);
	}
	
	public void inputBidLimit(String data){
		type(bidLimitBy, data);
	}
	
	public void switchIfeame(){
		waitIframeAndSwitch(iframeBy);
	}
}
