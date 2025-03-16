package pom.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywriteFactory;
import com.qa.opencart.pages.HomePage;

public class HomePageTest {
	
	PlaywriteFactory pf;
	 Page page;
	
	HomePage homePage ; 
	
	@BeforeTest
	public void setup() {
		pf =  new PlaywriteFactory();
		page = pf.initBrowser("chromium");
		homePage = new HomePage(page);
		
	}
	
	@Test
	public void homePageTitleTest() {
	String actulTitle	= homePage.getHomePageTitle();
	Assert.assertEquals(actulTitle, "Your Store");
	}
	
	@Test
	public void homePageURLTest() {
	String actulURL	= homePage.getHomePageURL();
	Assert.assertEquals(actulURL, "https://naveenautomationlabs.com/opencart/");
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"macbook"},
			{"iMac"},
			{"Samsung"}
		};
	}
	
		
	@Test(dataProvider = "getProductData")
	public void seachTest(String productName) {
		String actulSearchHeader =  homePage.doSearch(productName);
		Assert.assertEquals(actulSearchHeader, "Search - "+productName);
		
	}
	
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
