package com.lemon.businessflow;

import com.lemon.pageobject.BackstageIndexPage;
import com.lemon.pageobject.BackstagePage;
import com.lemon.pageobject.IndexPage;
import com.lemon.pageobject.InvestPage;

/**
 * 投资业务流程封装
 * @author 11646
 *
 */
public class InvestFlow {
	private String loanTitle;
	private double investAmount;
	public InvestFlow(String loanTitle,double investAmount){
		this.loanTitle=loanTitle;
		this.investAmount=investAmount;
	}
	

	public void chooseAndInvest(){
		IndexPage indexPage = new IndexPage();
		indexPage.clickRushToBid(loanTitle);
		
		InvestPage investPage = new InvestPage();
		investPage.investAmount(investAmount);
		investPage.clickBid();
	}

}
