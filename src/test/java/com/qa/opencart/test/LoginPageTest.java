package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic Login_001")
@Story("User Stroy 001 : Open Cart Login PAge")
@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest {

//	@Description("Login PAge Title Test")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void agetTitleTest() {

		String actualTitle =loginPage.getTitle();
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}

	//@Description("Login Page Url Test")
	@Severity(SeverityLevel.NORMAL)
	
	@Test
	public void bgetUrlTest() {
		Assert.assertEquals(driver.getCurrentUrl() ,Constants.LOGIN_PAGE_URL);
	}
	

	@Severity(SeverityLevel.CRITICAL)
	
	@Test
	public void cloginTest() {
		loginPage.login(prop.getProperty("user"),prop.getProperty("pass"));
	}
	
@Description("Login PAge Title Test")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void dclickLink() {
		loginPage.link();
	}
	
	
}

