package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {


	@Test(priority = 1)
	public void loginPageNavigationTest() {
	loginPage	= homePage.navigateToLoginPage();
	String actulLoginPageTitle = loginPage.getLoginTitle();
	System.out.println("page act title: "+ actulLoginPageTitle);
	Assert.assertEquals(actulLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	
	}
	
	@Test(priority = 2)
	public void forgotLinkExistTest() {
	Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	
	}
	
	
	
	@Test(priority = 3)
	public void appLoginTest() {
	
	Assert.assertTrue(loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password").trim()));
	
	}
}
