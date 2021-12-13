package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.ElementUtil;

public class ProductPage {

	public WebDriver driver;
	public ElementUtil eu;
	By productHeader = By.xpath("//div[@id='content'] //h1");
	By productMetadata = By.xpath("//div[@id='content'] //ul[@class='list-unstyled'][1] /li");
	By productMetaPrice = By.xpath("//div[@id='content'] //ul[@class='list-unstyled'][2] /li");

	// private By header = By.xpath("//div[@class='caption'] //h4");
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		eu = new ElementUtil(driver);
	}

	public String getHeader() {
		String text = eu.doGetText(productHeader);
		System.out.println(text);
		return text;
	}

	public HashMap<String, String> getProductInfo() {
		HashMap<String, String> productHashMap = new HashMap<String, String>();
		List<WebElement> metaData = eu.getElements(productMetadata);
		for (WebElement e : metaData) {
			String[] text = e.getText().split(":");
			String key = text[0];
			String value = text[1];

			productHashMap.put(key, value);

		}
		return productHashMap;

			
	}

}
