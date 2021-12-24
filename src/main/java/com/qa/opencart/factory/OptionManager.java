package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;

	public OptionManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromOptions() {
		co = new ChromeOptions();
		
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			co.addArguments("--headless");
			
		}
		
		if(Boolean.parseBoolean(prop.getProperty("incongito"))) {
			co.addArguments("--incognito");
			
		}
	
		co.addArguments("--disable-dev-shm-usage");
		co.addArguments("--no-sandbox");
		return co;
	}
	

	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			fo.addArguments("--headless");
		}
		
		if(Boolean.parseBoolean(prop.getProperty("incongito"))) {
			fo.addArguments("--incognito");
		}
		fo.addArguments("--disable-dev-shm-usage");
		fo.addArguments("--no-sandbox");
		return fo;
	}
	

	
	
}
