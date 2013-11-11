package com.sikachov.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceSortedProductPage extends ProductPage{

	@FindBy(className = "span_active")
	WebElement activeLink;

}
