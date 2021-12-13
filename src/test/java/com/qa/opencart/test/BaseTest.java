package com.qa.opencart.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchPage;
import com.qa.opencart.util.ElementUtil;

public class BaseTest {
	public DriverFactory df;
	public Properties prop;
	public static WebDriver driver;
	public LoginPage loginPage;
	public RegistrationPage regPage;
	public ElementUtil eu ;
	public AccountPage accPage;
	public SearchPage searchPage;
	public ProductPage productPage;
	@BeforeTest
	public void setup() throws IOException {

		df = new DriverFactory();
		prop = df.prop_init();
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
	
	}

	@AfterTest
	public void tearDown() {
	// driver.quit();

	}

}
