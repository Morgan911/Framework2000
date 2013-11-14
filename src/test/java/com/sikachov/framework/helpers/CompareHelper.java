package com.sikachov.framework.helpers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.sikachov.framework.objects.Product;
import com.sikachov.framework.pages.PricesPage;
import com.sikachov.framework.pages.ProductInfoPage;
import com.sikachov.framework.pages.ProductPage;

public class CompareHelper extends BaseHelper {
    private static String tagName = "td";

    private static List<WebElement> getSubelements(WebElement el, String str) {
	return el.findElements(By.tagName(str));
    }

    public static void verifySameParams(List<WebElement> sameParams) {
	Boolean actual = isSameValid(sameParams);
	Boolean expected = true;

	Assert.assertEquals(actual, expected);
    }

    public static void verifyDifferentParams(List<WebElement> different) {
	Boolean actual = isDifferentValid(different);
	Boolean expected = true;

	Assert.assertEquals(actual, expected);
    }

    public static void veryfyTextOnPages(WebDriver driver, String category,
	    String num) {
	ProductPage p = NavHelper.getProductPage(driver, category);
	List<Product> list = new ArrayList<Product>();
	List<Product> temp = p.getProducts(1);
	int n = Integer.parseInt(num);
	for (int i = 0; i < n; i++) {
	    p = NavHelper.getProductPage(driver, category);
	    checkInfoFor(driver, p, temp.get(i));
	    p = NavHelper.getProductPage(driver, category);
	    checkLinkFor(driver, p, temp.get(i));
	}
    }

    private static void checkLinkFor(WebDriver driver, ProductPage page,
	    Product p) {

	PricesPage pr = NavHelper.getPricesPage(driver, page);
	System.out.println("Prices");
	pr.findProduct(p.getName());
	String href = pr.getResultItem(0).getAttribute("href");

	Assert.assertEquals(href, p.getHref());

    }

    private static boolean isSameValid(List<WebElement> sameParams) {

	for (WebElement w : sameParams) {
	    if (!CompareHelper.compare(w))
		return false;
	}
	return true;
    }

    public static boolean isDifferentValid(List<WebElement> differentParams) {
	for (WebElement w : differentParams) {
	    if (CompareHelper.compare(w))
		return false;
	}
	return true;
    }

    private static boolean compare(WebElement w) {
	List<WebElement> temp = getSubelements(w, tagName);
	String el1 = temp.get(temp.size() - 1).getText();
	System.out.println("El1====>>>>" + el1);
	for (int i = 1; i < temp.size(); i++) {
	    String el2 = temp.get(i).getText();
	    System.out.println("El" + i + "====>>>>" + el2);
	    if (!el1.trim().equals(el2.trim()))
		return false;
	}
	return true;
    }

    public static void checkInfoFor(WebDriver driver, ProductPage page,
	    Product p) {
	String productName = p.getName();
	System.out.println("Name --->> " + productName);
	ProductInfoPage info = NavHelper.getProductInfoPage(driver, page,
		productName);
	String[] s = p.getDescription().split(";");
	System.out.println("Splited");
	List<String> in = info.getInfo();
	System.out.println("info");
	for (int k = 2; k < 4; k++) {
	    System.out.println("loop" + k);
	    String str = s[k].toLowerCase().trim();
	    Assert.assertEquals(in.contains(str), true);
	}
	System.out.println("loopEnd");

    }
}
