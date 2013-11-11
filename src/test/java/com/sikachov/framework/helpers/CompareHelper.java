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

public class CompareHelper extends BaseHelper{
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
	
	public static void veryfyTextOnPages(WebDriver driver, String category, String num){
		ProductPage p = NavHelper.getProductPage(driver, category);
		List<Product> list = new ArrayList<Product>();
		List<Product> temp = p.getProducts(1);
		int n = Integer.parseInt(num);
		for(int i = 0; i < n; i++){
			 p = NavHelper.getProductPage(driver, category);
			Product tempP = temp.get(i);
			list.add(tempP);
			String productName = tempP.getName();
			System.out.println("Product Name"+ ProductInfoPage.productName);
			ProductInfoPage info = NavHelper.getProductInfoPage(driver, p, productName);
			String[] s = tempP.getDescription().split(";");
			
			List<String> in = info.getInfo();
	
			for(int k = 2; k < 4; k++){
				String str = s[k].toLowerCase().trim();
				Assert.assertEquals(in.contains(str), true);
			}
			
		}
		PricesPage pr = NavHelper.getPricesPage(driver, p);
		for(int i = 0; i < n; i++){
			Product pFromList = list.get(i);
			pr.findProduct(pFromList.getName());
			String href = pr.getResultItem(0).getAttribute("href");
			
			Assert.assertEquals(href, pFromList.getHref());
		}
	}
	
	
	private static boolean isSameLink(String link1, String link2) {
		
		if(link1.equals(link2)){
			return true;
		}
		return false;
	}

	private static boolean isSameValid(List<WebElement> sameParams) {

		for (WebElement w : sameParams){
			if(!CompareHelper.compare(w))
				return false;
		}
		return true;
	}
	
	public static boolean isDifferentValid(List<WebElement> differentParams) {
		for (WebElement w : differentParams){
			if(CompareHelper.compare(w))
				return false;
		}
		return true;
	}
	
	private static boolean compare(WebElement w) {

		List<WebElement> temp = getSubelements(w, tagName);
		String el1 = temp.get(1).getText();
		String el2 = temp.get(2).getText();
		System.out.println(el1 + "<<--el1  el2-->> "+ el2);
		if (el1.trim().equals(el2.trim()))
			return true;
		return false;
	}
}
