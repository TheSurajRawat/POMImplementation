package com.digitalacademy.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class WebDriverFactory {
	private static final String CHROME = "chrome";
	private static final String EDGE = "edge";
	private static final String FIREFOX = "firefox";
	
	public WebDriverFactory() {
	}
	
	public static WebDriver getWebDriverInstance(String browserName) {
		WebDriver webDriver = null;
		
		if(browserName.equalsIgnoreCase(CHROME)) {
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			webDriver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase(EDGE)) {
			System.setProperty("webdriver.edge.driver", "lib/edgedriver.exe");
			webDriver = new EdgeDriver();
		} else if(browserName.equalsIgnoreCase(FIREFOX)) {
			System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
			webDriver = new FirefoxDriver();
		}
		return webDriver;
	}
}

