package com.sikachov.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.sikachov.framework.helpers.BaseHelper.*;
public class PricesPage extends Page {
	
	@FindBy(className = "styled-result-table")
	WebElement resultTable;
	@FindBy(id = "edit-name-1")
	WebElement searchField;
	@FindBy(id = "edit-submit-1")
	WebElement searchBtn;
	@FindBy(className = "description-link")
	List<WebElement> resultItems;

	public void findProduct(String name) {
		log("finding product by name");
		searchField.clear();
		searchField.sendKeys(name);
		searchBtn.click();
	}
	
	public WebElement getResultItem(int num){
		return resultItems.get(num);
	}

}
