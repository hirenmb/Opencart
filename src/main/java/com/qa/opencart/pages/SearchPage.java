package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.ElementUtil;

public class SearchPage {

	private WebDriver driver;
	private ElementUtil eu;

//	By productImg = By.xpath("//div[@class='product-thumb']");
	By productImg = By.xpath("//div[@class='caption'] //a");

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		eu = new ElementUtil(driver);
	}

	public String getSearchPageTitle() {

		return driver.getTitle();

	}

	public ProductPage getProducts(String selctedProduct) {
		List<WebElement> productsList = eu.getElements(productImg);
		ArrayList<String> pList = new ArrayList<String>();
		for (WebElement e : productsList) {
			String text = e.getText();
			pList.add(text);

			if (e.getText().equalsIgnoreCase(selctedProduct)) {
				e.click();
				break;
			}
		}
		eu.printElementValues(pList);

		System.out.println(productsList.size());
		return new ProductPage(driver);
	}

}
