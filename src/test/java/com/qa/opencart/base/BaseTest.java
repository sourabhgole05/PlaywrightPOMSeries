package com.qa.opencart.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywriteFactory;
import com.qa.opencart.pages.HomePage;

public class BaseTest {

	PlaywriteFactory pf;
	private Page page;
	protected Properties prop;

	protected HomePage homePage;

	@BeforeTest
	public void setup() {
		pf = new PlaywriteFactory();
		prop = pf.init_prop();
		page = pf.initBrowser(prop);
		homePage = new HomePage(page);

	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
