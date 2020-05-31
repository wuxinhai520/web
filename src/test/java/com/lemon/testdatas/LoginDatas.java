package com.lemon.testdatas;

import org.testng.annotations.DataProvider;

/**
 * 登录测试用例的数据
 * @author 11646
 *
 */
public class LoginDatas {
	public static final String CORRECT_MOBILEPHONE = "13323234545";
	public static final String CORRECT_PASSWORD = "lemon123456";
	
	@DataProvider
	public Object[][] getLoginFailureDatas(){
		Object[][] datas = {{"","lemon123456","请输入手机号"},{"1332323454","lemon123456","请输入正确的手机号"},
				{"133232345454","lemon123456","请输入正确的手机号"},{"1332323454%","lemon123456","请输入正确的手机号"},
				{"13323234545","","请输入密码"}};
		return datas;
	}
	@DataProvider
	public Object[][] getLoginErrorDatas(){
		Object[][] datas = {{"15000000000","lemon123456","此账号没有经过授权，请联系管理员!"},
				{"13323234545","123456","帐号或密码错误!"}};
		return datas;
	}
	

}
