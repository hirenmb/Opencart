package com.qa.opencart.test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.util.Constants;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;

@Epic("Account Page Epic_001 ")
@Story("Stroy Account Page_0001")
@Listeners(TestAllureListener.class)
public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.login(prop.getProperty("user"), prop.getProperty("pass"));
		
	}
	
	@Test
	public void accTitle() {
	String title= accPage.getAccPageTitle();
	Assert.assertEquals(title, Constants.ACC_PAGE_TITLE);
	
	}
	
	
	@Test
	public void selectProduct() {
		
	}
	
	@DataProvider
	public Object[][] searchData() {
		return  new Object[][] {{"Apple"} ,{ "MacBook"},{ "samsung"}};
	}
	
	@Test(dataProvider="searchData")
	public void searchProduct(String prodctName) {
		  accPage.searchProduct(prodctName);
		  String title =driver.getTitle();
		 // Assert.assertEquals(title, Constants.SEARCH_PAGE_TITLE);
	}
	
	
	@DataProvider
	private Object[][] productSelectData() {
		return new Object[][] { 
			{ "MacBook" , "MacBook Pro"}, 
			{ "iMac", "iMac" }, 
			{ "Samsung" , "Samsung SyncMaster 941BW"},
			{"Apple", "Apple Cinema 30\""}
			};
	}
	
	@Test(dataProvider = "productSelectData")
	private void productSelect(String product , String selctedProduct) {
		searchPage  = accPage.searchProduct(product);
		productPage = searchPage.getProducts(selctedProduct);
		HashMap<String, String> pMetaData = productPage.getProductInfo();
		System.out.println(pMetaData);
		
		pMetaData.forEach((k, v) -> System.out.println("KEY  :--->"+k + "    Value :--->" + v));
	Assert.assertEquals(productPage.getHeader(),selctedProduct);	
	}

	
}
