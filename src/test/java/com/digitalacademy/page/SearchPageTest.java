package com.digitalacademy.page;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.digitalacademy.browser.GetBrowser;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class SearchPageTest {
	private static WebDriver webDriver = null;
	private static SearchItemPage searchItemPage = null;
	
	@BeforeClass
	public static void setup() {
		webDriver = GetBrowser.getWebDriver();
		webDriver.navigate().to(GetBrowser.getUrl());
		webDriver.manage().window().maximize();

		searchItemPage = new SearchItemPage(webDriver);
	}
	
	@AfterClass
	public static void windUp() {
		webDriver.quit();
	}
	
	
		
	@Test
	public void test01() {
		
		searchItemPage.setSearchItem("BEST OF FRIENDS");
		searchItemPage.clickOnSearchButton();
		String actualHeadingPage = searchItemPage.getPageHeading();
		Assert.assertEquals("Products for \"BEST OF FRIENDS\"", actualHeadingPage);
		
	}	
	
}
