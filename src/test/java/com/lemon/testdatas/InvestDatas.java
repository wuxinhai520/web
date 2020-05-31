package com.lemon.testdatas;

import org.testng.annotations.DataProvider;

/**
 * 投资用例的数据
 * @author 11646
 *
 */
public class InvestDatas {
	@DataProvider
	public Object getInvestNormalDatas(){
		Object[][] data = {{200.00,"投标成功！"}};
		return data;
	}
	
	@DataProvider
	public Object getNotmultipleDatas(){
		Object[][] data = {{"99","请输入10的整数倍"},{"100.01","请输入10的整数倍"},
				{"10a0","请输入10的整数倍"},{"10 0","请输入10的整数倍"},{"101","请输入10的整数倍"}};
		return data;
	}
	
	@DataProvider
	public Object getErrorDatas(){
		Object[][] data = {{"0","请正确填写投标金额"},{"-100","请正确填写投标金额"}};
		return data;
	}

}
