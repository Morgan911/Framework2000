package com.sikachov.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.sikachov.framework.helpers.BaseHelper.*;
public class MainPage extends Page {

	public ProductPage goToProductPage(WebDriver driver, String category) {
		log("open product page");
		driver.findElement(By.linkText(category)).click();
		return PageFactory.initElements(driver, ProductPage.class);
	}

}
