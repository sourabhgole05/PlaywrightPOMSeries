package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class HomePageTest extends BaseTest {

	@Test
	public void homePageTitleTest() {
		String actulTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actulTitle, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test
	public void homePageURLTest() {
		String actulURL = homePage.getHomePageURL();
		Assert.assertEquals(actulURL, prop.getProperty("url"));
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { { "macbook" }, { "iMac" }, { "Samsung" } };
	}

	@Test(dataProvider = "getProductData")
	public void seachTest(String productName) {
		String actulSearchHeader = homePage.doSearch(productName);
		Assert.assertEquals(actulSearchHeader, "Search - " + productName);

	}

}
