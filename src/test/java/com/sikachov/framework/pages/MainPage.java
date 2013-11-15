package com.sikachov.framework.pages;

import static com.sikachov.framework.helpers.BaseHelper.log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sikachov.framework.factories.MyPageFactory;
public class MainPage extends Page {

	public ProductPage goToProductPage(String category) {
		log("Open product page " + category);
		driver.findElement(By.linkText(category)).click();
		return MyPageFactory.getPage(driver, ProductPage.class);
	}

}
