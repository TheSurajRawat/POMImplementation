package com.digitalacademy.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
private WebDriver webDriver = null;

	@FindBy(xpath = "//*[@id='header_customer_login']/header/h2")
	private WebElement pageHeading;
	
	@FindBy(id = "login-customer[email]")
	private WebElement txtUsername;
	
	@FindBy(id="login-customer[password]")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//*[@id='header_customer_login']/button")
	private WebElement btnLogin;
	
	public LoginPage() {
	}
	
	public LoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;		
		PageFactory.initElements(webDriver, this);
	}
	
	public LoginPage(WebDriver webDriver, WebElement txtUsername, WebElement txtPassword) {
		this.webDriver = webDriver;
		this.txtUsername = txtUsername;
		this.txtPassword = txtPassword;
		
		PageFactory.initElements(webDriver, this);
	}
	
	public String getTitle() {
		return webDriver.getTitle();
	}
	
	public String getPageHeading() {
		return pageHeading.getText();
	}
	
	public void setUsername(String uname) {
		this.txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		this.txtPassword.sendKeys(pwd);
	}
	
	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}
	
	public void quitPage() {
		webDriver.quit();
	}
	
	public void validateLogin() {
		btnLogin.click();
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
