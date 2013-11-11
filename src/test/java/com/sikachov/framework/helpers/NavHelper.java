package com.sikachov.framework.helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sikachov.framework.pages.ComparationPage;
import com.sikachov.framework.pages.MainPage;
import com.sikachov.framework.pages.NameSortedProductPage;
import com.sikachov.framework.pages.Page;
import com.sikachov.framework.pages.PriceSortedProductPage;
import com.sikachov.framework.pages.PricesPage;
import com.sikachov.framework.pages.ProductInfoPage;
import com.sikachov.framework.pages.ProductPage;
import com.sikachov.framework.pages.SearchResultPage;

public class NavHelper extends BaseHelper{
	
	public static ProductPage getProductPage(WebDriver driver, String product){
		log("open Product Page " + product);
		MainPage p = PageFactory.initElements(driver, MainPage.class);
		return p.goToProductPage(driver, product);
	}
	
	public static ProductInfoPage getProductInfoPage(WebDriver driver, ProductPage p, String productName){
		log("open Product Info Page " + productName);
		p.openProduct(productName);
		return PageFactory.initElements(driver, ProductInfoPage.class);
	}
	
	public static SearchResultPage getSearchResultPage(WebDriver driver, Page p, String request){
		log("open Search Result Page for request " + request);
		p.search(request);
		return PageFactory.initElements(driver, SearchResultPage.class);
	}
	
	public static PricesPage getPricesPage(WebDriver driver, ProductPage p){
		log("open Prices Page");
		p.goToPrices();
		return PageFactory.initElements(driver, PricesPage.class);	
	}
	
	public static PriceSortedProductPage getPriceSortedProductPage(WebDriver driver, ProductPage p){
		log("open Price Sorted Product Page");
		p.sortByPrice();
		return PageFactory.initElements(driver, PriceSortedProductPage.class);	
	}
	
	public static NameSortedProductPage getNameSortedProductPage(WebDriver driver, ProductPage p){
		log("open Name Sorted Product Page");
		p.sortByName();
		return PageFactory.initElements(driver, NameSortedProductPage.class);	
	}
	
	public static ComparationPage getComparationPage(WebDriver driver, ProductPage p, int num){
		log("open Comparation Page");
		List<WebElement> l = p.getWebElementProducts(num);
		for (WebElement w : l) {
			w.findElement(By.className("compare_add_link")).click();
		}
		try{
		l.get(0).findElement(By.className("head-compare-link")).click();
		}catch(Exception e){
			return null;
		}
		return PageFactory.initElements(driver, ComparationPage.class);	
	}

}
