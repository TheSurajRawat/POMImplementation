package com.digitalacademy.page;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.digitalacademy.browser.GetBrowser;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LoginPageTest {
	private static WebDriver webDriver = null;
	private static HomePage homePage = null;
	private static LoginPage loginPage = null;
	
	@BeforeClass
	public static void setup() {
		webDriver = GetBrowser.getWebDriver();
		webDriver.navigate().to(GetBrowser.getUrl());
		webDriver.manage().window().maximize();
		
		homePage = new HomePage(webDriver);
		loginPage = new LoginPage(webDriver);

	}
	
	@AfterClass
	public static void windUp() {
		webDriver.quit();
	}
	
	@Test
	public void test01() {
		String title = homePage.getTitle();
		String actualTitle = webDriver.getTitle();
		
		Assert.assertEquals(title, actualTitle);
	}
	
	@Test
	public void test02() {
		String expectedHeading = "Discover our products";				
		String actualHeading = homePage.getHomePageHeading();
		
		Assert.assertEquals(expectedHeading, actualHeading);
		
	}
	
		
	@Test
	public void test03() {

		homePage.goToLoginPage();
		String actualHeading = loginPage.getPageHeading();
		Assert.assertEquals("Login to my account", actualHeading);
		
	}
	
	@Test
	public void test04() {
		
		loginPage.setUsername("testuser@gmail.com");
		loginPage.setPassword("Test@123");
		loginPage.validateLogin();
		String actualUrl = loginPage.getCurrentUrl();
		Assert.assertEquals("https://odyssey.in/account", actualUrl);
		
	}
	
	
	
}
