package com.digitalacademy.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	
private WebDriver webDriver = null;

    @FindBy(xpath = "//*[text()='Discover our products']")
    private WebElement homepageHeading;
    
    @FindBy(xpath = "//*[@id='shopify-section-collection-list']//span")
    private WebElement categories;
    
    @FindBy(xpath = "//*[@id='shopify-section-header']/section/header/div/div/div[2]/div[2]/div/a[2]")
    private WebElement loginLink;
    
	
	public HomePage() {
	}
	
	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		
		PageFactory.initElements(webDriver, this);
	}
	
	public String getTitle() {
		return webDriver.getTitle();
	}
	
	public String getHomePageHeading() {
		return homepageHeading.getText();
	}
	
		
	public void quitPage() {
		webDriver.quit();
	}
	
	public void goToLoginPage() {
	try {
			loginLink.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

}
