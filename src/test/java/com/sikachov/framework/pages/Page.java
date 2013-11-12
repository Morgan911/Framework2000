package com.sikachov.framework.pages;

import static com.sikachov.framework.helpers.BaseHelper.log;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sikachov.framework.factories.MyPageFactory;

public abstract class Page {

    public WebDriver driver;

    @FindBy(id = "edit-name-1")
    public WebElement search;

    @FindBy(id = "edit-submit-1")
    public WebElement buttonSearch;

    @FindBy(className = "mlogo")
    public WebElement mainLogo;

    public Page(WebDriver driver) {
	this.driver = driver;
    }

    public WebDriverWait wait_() {
	return new WebDriverWait(driver, 10);
    }

    public MainPage goToMainPage() {
	log("open main page");
	mainLogo.click();
	return MyPageFactory.getPage(driver, MainPage.class);
    }

    public SearchResultPage search(String request) {
	log("searhing");
	search.clear();
	search.sendKeys(request);
	buttonSearch.click();
	return MyPageFactory.getPage(driver, SearchResultPage.class);
    }

}
