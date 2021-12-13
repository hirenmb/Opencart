package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.ElementUtil;
import com.qa.opencart.util.ExcelUtil;

import io.qameta.allure.Step;

public class LoginPage {

	By login = By.id("input-email");
	By pass = By.id("input-password");
	By btn = By.xpath("(//*[@type='submit'])[1]");
	By link = By.xpath("(//a[text()='Register'])[2]");

	public WebDriver driver;
	public ExcelUtil excelUtil;
	private ElementUtil eu;
//	private  RegistrationPage regPage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eu = new ElementUtil(driver);
		excelUtil = new ExcelUtil(driver);

	}

	@Step("Login Page Login: {0} & Password : {1} Entry Test")
	public AccountPage login(String logintext, String passtext) {

		eu.doSendKeys(login, logintext);
		eu.doSendKeys(pass, passtext);
		eu.doClick(btn);
		return new AccountPage(driver);
	}

	@Step("Getting Login Title")
	public String getTitle() {
		return driver.getTitle();

	}

	@Step("Getting Page Url")
	public String currentUrl() {

		return driver.getCurrentUrl();
	}

	@Step("Navigating to Registration Page")
	public RegistrationPage link() {
		eu.doClick(link);
		return new RegistrationPage(driver);
	}

}
