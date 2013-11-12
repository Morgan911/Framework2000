package com.sikachov.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NameSortedProductPage extends ProductPage {
	
    public NameSortedProductPage(WebDriver driver) {
	super(driver);
    }

	@FindBy(className = "span_active")
	WebElement activeLink;
}
