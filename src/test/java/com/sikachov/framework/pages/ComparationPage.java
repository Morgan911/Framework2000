package com.sikachov.framework.pages;

import static com.sikachov.framework.helpers.BaseHelper.log;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparationPage extends Page {

    private String isOnElement = "//html/body/div[2]/div[3]/div/div[4]/div[2]/div/div[2]/table/tbody/tr/th/div/span/a";
    int productNum = 2;

    @FindBy(xpath = "//tr[@class = \"\"]")
    List<WebElement> sameParams;
    @FindBy(xpath = "//tr[@class = \"different\"]")
    List<WebElement> differentParams;

    public List<WebElement> getSameParams() {
	log("get product same parameters webElement");
	return this.sameParams;
    }

    public List<WebElement> getDifferentParams() {
	log("get product different parameters webElement");
	return this.differentParams;
    }

}
