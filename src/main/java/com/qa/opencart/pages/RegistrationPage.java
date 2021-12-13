package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.qa.opencart.util.ElementUtil;

public class RegistrationPage {

	private WebDriver driver;
	private ElementUtil eu;
	By link = By.linkText("Register");
	
	By firstName = By.id("input-firstname");
	By lastName = By.id("input-lastname");
	By email = By.id("input-email");
	By telePhone = By.cssSelector("input#input-telephone");
	By pass = By.cssSelector("input#input-password");
	By cpass = By.cssSelector("input#input-confirm");
	
	
	public RegistrationPage(WebDriver driver) {

		this.driver = driver;
		eu = new ElementUtil(driver);
	}

	public String getTitle() {
		return driver.getTitle();

	}
	
	
	public void  formEntry(String s1, String s2, String s3, String s4, String s5, String s6) {
		
		eu.doSendKeys(firstName, s1);
		eu.doSendKeys(lastName, s2);
		eu.doSendKeys(email, s3);
		eu.doSendKeys(telePhone, s3);
		eu.doSendKeys(pass, s3);
		eu.doSendKeys(cpass, s3);
	}

}
