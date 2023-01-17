package com.digitalacademy.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SearchItemPage {
	
private WebDriver webDriver = null;

    @FindBy(name = "q")
    private WebElement searchTextBox;
    
    @FindBy(xpath = "//button[@class='search-bar__submit']")
    private WebElement searchButton;
    
    @FindBy(xpath = "//*[@id=\"shopify-section-search-template\"]/section/div[1]/div[2]/div/div/div/div/header/div/div/div/div/h1")
    private WebElement searchItem;
    
	
	public SearchItemPage() {
	}
	
	public SearchItemPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		
		PageFactory.initElements(webDriver, this);
	}
	
	public String getTitle() {
		return webDriver.getTitle();
	}
	
	public String getPageHeading() {
		return searchItem.getText();
	}
	
		
	public void quitPage() {
		webDriver.quit();
	}
	
	public void setSearchItem(String item) {
		this.searchTextBox.sendKeys(item);
	}
	
	public void clickOnSearchButton() {
	try {
			searchButton.click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

}
