package com.sikachov.framework.helpers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sikachov.framework.objects.Product;
import com.sikachov.framework.pages.ProductPage;

public class ProductPageHelper extends BaseHelper{
    
    public static List<Product> getProducts(ProductPage p){
	WebElement lastPageNum = p.getLastPageNum();
	int lastPage= parsePageNum(lastPageNum);
	return getProducts(lastPage, p);
    }
    
    public static List<Product> getProducts(int lastPage, ProductPage p){
	List<Product> prods = new ArrayList<Product>();
	int i = 1;
	List<WebElement> elements;
	WebElement nextBtn = p.getNextButton();
	while (i <= lastPage) {
	    elements = p.getProducts();
	    for (WebElement product : elements) {
		prods.add(convertRowToProduct(product));
	    }
	    if (i < lastPage)
		p.clickAt(nextBtn);
	    i++;
	}
	log("Get all products from page");
	return prods;
    }
    
    public static List<String> getProductProducers(ProductPage p) {
   	log("Reading product producer names");
   	List<String> list = new ArrayList<>();
   	List<Product> products = getProducts(p);
   	for (Product product : products) {
   	    String fullName = product.getName();
   	    String firstName = fullName.split(" ")[0];
   	    if (!list.contains(firstName.toLowerCase())) {
   		list.add(firstName.toLowerCase());
   	    }
   	}
   	return list;
       }
    
    public List<WebElement> getWebElementProducts(int num, List<WebElement> elements) {
  	log("get products like webElements");
  	List<WebElement> res = new ArrayList<WebElement>();
  	for (int i = 0; i < num; i++) {
  	    res.add(elements.get(i));
  	}
  	return res;
      }
    
    public static List<String> getProducersFromSidebar(ProductPage p) {
	log("reading producers from filter");
	p.openAllProducers();
	List<String> list = new ArrayList<>();
	for (WebElement w : p.getProducers()) {
	    String name = w.getText();
	    name = name.split(" ")[0];
	    list.add(name.toLowerCase());
	}
	for (WebElement w : p.getProducersExt()) {
	    String name = w.getText();
	    name = name.split(" ")[0];

	    list.add(name.toLowerCase());
	}
	list.remove("скрыть");
	return list;
    }
    
    private static int parsePageNum(WebElement e) {
	log("parsing the last page");
	String s = e.getText();
	return Integer.parseInt(s);
    }

    private static Product convertRowToProduct(WebElement product) {
	String name = product.findElement(By.className("name")).getText();
	String price = product.findElement(By.cssSelector(".price strong"))
		.getText();
	String description = product.findElement(By.className("description"))
		.getText();
	String href = product.findElement(By.cssSelector(".name a"))
		.getAttribute("href");
	price = price.replaceAll("[a-zA-Zа-яА-Я ]", "");
	Double dprice = Double.parseDouble(price);
	Product tmp = new Product(name, href, dprice, description);
	return tmp;
    }
}
