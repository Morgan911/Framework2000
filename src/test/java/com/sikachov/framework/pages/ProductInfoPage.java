package com.sikachov.framework.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.sikachov.framework.helpers.BaseHelper.*;
public class ProductInfoPage extends Page {

	public static String productName;

	@FindBy(css = ".row .pr")
	List<WebElement> prs;
	@FindBy(css = ".row .val")
	List<WebElement> vals;
	
	public List<String> getInfo() {
		log("get product info");
		List<String> res = new ArrayList<>();
		for (int i = 0; i < vals.size(); i++) {
			System.out.println(prs.get(i).getText()+ " "+vals.get(i).getText());
			res.add(prs.get(i).getText().toLowerCase() + " " + vals.get(i).getText().toLowerCase());
		}
		return res;
	}

}
