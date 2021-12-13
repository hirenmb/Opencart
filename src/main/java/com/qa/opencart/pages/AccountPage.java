package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.ElementUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil eu;
	
	By search 		= By.xpath("//input[@name='search']");
	By searchBtn	= By.xpath("//div[@id='search'] /span/button");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eu = new ElementUtil(driver);
	}
	
	@Step("Account Page Title")
	public String getAccPageTitle() {
		return driver.getTitle();
	}

	@Step("Search a Product")
	public SearchPage searchProduct(String productName) {
		eu.getElement(search).clear();
		eu.getElement(search).sendKeys(productName);
		eu.doClick(searchBtn);
		return new SearchPage(driver);
	}
	
}
