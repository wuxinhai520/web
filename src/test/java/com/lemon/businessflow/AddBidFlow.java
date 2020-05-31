package com.lemon.businessflow;

import com.lemon.pageobject.BackstageIndexPage;
import com.lemon.pageobject.BackstagePage;

/**
 * 后台加标
 * @author 11646
 *
 */
public class AddBidFlow {
	private String loanTitle;
	
	public AddBidFlow(String loanTitle){
		this.loanTitle=loanTitle;
	}
	
	public void BackstageAddBid() throws Exception{
		//新建标
		//1.输入账号
		BackstagePage bPage = new BackstagePage();
		bPage.inputUserName("lemon7");
		//2.输入密码
		bPage.inputPassWord("lemonbest");
		//3.输入验证码
		bPage.inputVerifyCode("hapi");
		//4.点击登录
		bPage.clickbackstageLogin();
		//5.点击借款管理
		BackstageIndexPage backstageIndexPage = new BackstageIndexPage();
		backstageIndexPage.clickLoanManage();
		//切换iframe
		backstageIndexPage.switchIfeame();
		//6.点击加标
		backstageIndexPage.clickAddBid();
		//7.输入借款人信息
		backstageIndexPage.inputBrrowerInfo("13323234444");
		//8.输入贷款标题
		loanTitle = "web_" + System.currentTimeMillis();  //System.currentTimeMillis()  时间戳
		backstageIndexPage.inputLoanTitle(loanTitle);
		//9.输入年利率利息
		backstageIndexPage.inputRate("10");
		//10.输入借款期限
		backstageIndexPage.inputlanTerm("5");
		//11.输入借款额度
		backstageIndexPage.inputLoanLimit("500000");
		//12.输入竞标期限
		backstageIndexPage.inputBidLimit("5");
		//13.点击风控评测
		backstageIndexPage.clickRiskControl();
		//14.输入评估价值
		backstageIndexPage.inputEvaluetion("1000000");
		//15.项目录入
		backstageIndexPage.clickProjectImport();
		//16.输入籍贯
		backstageIndexPage.inputNativePlace("江西");
		//17.职业
		backstageIndexPage.inputOccupation("农民");
		//18.年龄
		backstageIndexPage.inputAge("23");
		//19.点击提交按钮
		backstageIndexPage.clickSubmit();
		Thread.sleep(2000);
		//三次审核
		backstageIndexPage.selectBid(loanTitle);
		backstageIndexPage.clickVerrify();
		backstageIndexPage.clickVerifyPass();
		Thread.sleep(2000);
		backstageIndexPage.selectBid(loanTitle);
		backstageIndexPage.clickVerrify();
		backstageIndexPage.clickVerifyPass();
		Thread.sleep(2000);
		backstageIndexPage.selectBid(loanTitle);
		backstageIndexPage.clickVerrify();
		backstageIndexPage.clickVerifyPass();
		Thread.sleep(2000);
	}

}
