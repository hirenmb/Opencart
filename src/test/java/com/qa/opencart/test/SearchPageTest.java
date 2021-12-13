package com.qa.opencart.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {

	@BeforeClass()
	public void searchPageSetup() {
		accPage = loginPage.login(prop.getProperty("user"), prop.getProperty("pass"));
		//searchPage = accPage.searchProduct();
	
	}
	
	@Test
	public void selectProduct() {
		accPage.searchProduct("Macbook");
		
		
	}
}
