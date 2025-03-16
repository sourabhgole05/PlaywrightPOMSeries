package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;
	
	//1.String Locators - OR
	private String emailID = "//input[@id='input-email']";
	private String password = "//input[@id='input-password']";
	private String loginBtn = "//input[@value='Login']";
	private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
	private String logoutLink="//a[@class='list-group-item'][normalize-space()='Logout']";
	
	//2. Page constructor 
	public LoginPage(Page page) {
		this.page = page;
	}
	
	//3. page actions/methods: 
	public String getLoginTitle() {
		return page.title();
	}
	
	public boolean isForgotPwdLinkExist() {
		return page.isVisible(forgotPwdLink);
	}
	
	public boolean doLogin(String appUserName, String appPassword) {
		System.out.println("App creds: "+ appUserName + ": " + appPassword);
		page.fill(emailID, appUserName);
		page.fill(password, appPassword);
		page.click(loginBtn);
		if(page.isVisible(logoutLink)) {
			System.out.println("user is logged in successfully...");
			return true;
		}
		return false ;
	}
	
}
