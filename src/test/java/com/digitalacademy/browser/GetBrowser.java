package com.digitalacademy.browser;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class GetBrowser {

	private static Properties properties = null;
	private static String browserName = null;
	private static String url = null;

	static {
		FileReader file;
		properties = new Properties();
		
		try {
			file = new FileReader("src/test/resources/application.properties");
			properties.load(file);

		} catch (IOException e) {
		}
	}

	public static WebDriver getWebDriver() {
		browserName = properties.getProperty("browser.name");

		return WebDriverFactory.getWebDriverInstance(browserName);
	}

	public static String getUrl() {
		return properties.getProperty("site.url");
	}
}
