package com.qa.opencart.test;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.util.ExcelUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
@Epic("Epic Registration Page_001")
@Story("User Stroy 001 : Open Cart Registration Page")
@Listeners(TestAllureListener.class)
public class RegistrationPageTest extends BaseTest {
	
	@BeforeClass
	public void regsPAge() {
		regPage = loginPage.link();
	}
	
	
	@Test
	public void regTitleTest() {
		String title = regPage.getTitle();
		System.out.println("Hiren" + title);
	 
	}
	
	@Test(dataProvider="regData")
	public void entry(String s1,String s2 , String s3, String s4, String s5, String s6) {
		
		regPage.formEntry(s1,s2 , s3, s4, s5, s6);
	}
	
	@DataProvider
	public Object[][] regData() throws FileNotFoundException {
		return ExcelUtil.getExcelData("data");
				
		}
}
