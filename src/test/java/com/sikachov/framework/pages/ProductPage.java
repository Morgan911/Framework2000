package com.sikachov.framework.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sikachov.framework.objects.Product;

import static com.sikachov.framework.helpers.BaseHelper.*;
public class ProductPage extends Page {

	private static final String sortByNameLink = "название";
	private static final String sortByPriceLink = "цена";
	private static final String pageSubHeader = "page-subheader";
	private static final String minPriceFilters = "//div[3]/div[2]";
	private static final String maxPriceFilters = "//div[4]/div[2]";
	@FindBy(linkText = sortByNameLink)
	WebElement sortByName;
	@FindBy(linkText = sortByPriceLink)
	WebElement sortByPrice;
	@FindBy(id = pageSubHeader)
	WebElement subHeader;
	@FindBy(className = "item")
	List<WebElement> products;
	@FindBy(className = "last")
	public WebElement lastPage;
	@FindBy(xpath = "//div[2]/div/div/ul/li[2]/a")
	public WebElement next;

	@FindBy(xpath = minPriceFilters)
	WebElement minFilters;
	@FindBy(xpath = maxPriceFilters)
	WebElement maxFilters;

	@FindBy(xpath = "//div/div/div/div[2]/div[5]/div[2]/a")
	List<WebElement> producers;
	@FindBy(xpath = "//div/div[3]/div/div/div/div[2]/div[5]/div[2]/div[3]/a")
	List<WebElement> producersExt;

	@FindBy(className = "show_common_producer")
	WebElement showAllButton;
	
	@FindBy(xpath = "//div/div[3]/div/div/div/div/div/a")
	WebElement link;
	

	// the number of the last page
	int last;

	public int parsePageNum(WebElement e) {
		log("parsing the last page");
		String s = e.getText();
		return Integer.parseInt(s);
	}

	
	public List<Product> getProducts(int k) {
		log("get all products from page");
		List<Product> prods = new ArrayList<Product>();
		int i = 1;

		while (i <= k) {
			for (WebElement product : products) {
				prods.add(convertRowToProduct(product));
			}
			if (i < last)
				next.click();
			i++;
		}
		return prods;
	}

	public List<Product> getProducts() {
		last = parsePageNum(lastPage);
		return this.getProducts(last);
	}

	// Elements without converting to Product type
	public List<WebElement> getWebElementProducts(int num) {
		log("get products like webElements");
		List<WebElement> res = new ArrayList<WebElement>();
		for (int i = 0; i < num; i++) {
			res.add(products.get(i));
		}
		return res;

	}

	public List<String> getProductProducers() {
		log("reading product producers");
		List<String> list = new ArrayList<>();
		List<Product> products = getProducts();
		for (Product p : products) {
			String fullName = p.getName();
			String firstName = fullName.split(" ")[0];
			if (!list.contains(firstName.toLowerCase())) {
				list.add(firstName.toLowerCase());
			}
		}
		return list;
	}

	public List<String> getProducers() {
		log("reading producers from filter");
		openAllProducers();
		List<String> list = new ArrayList<>();
		for (WebElement w : producers) {
			String name = w.getText();
			name = name.split(" ")[0];
			list.add(name.toLowerCase());
		}
		for (WebElement w : producersExt) {
			String name = w.getText();
			name = name.split(" ")[0];

			list.add(name.toLowerCase());
		}

		list.remove("скрыть");

		return list;
	}

	public void sortByName() {
		log("sort by name click");
		sortByName.click();
	}

	public void sortByPrice() {
		log("sort by price click");
		sortByPrice.click();
	}

	public void openAllProducers() {
		
		showAllButton.click();
	}
	
	public void openPageWithFunc(String ss) {
		log("open page with function "+ ss);
		driver.findElement(By.linkText(ss)).click();
	}

	public void goToPrices() {
		log("open prices page");
		link.click();
	}

	public void filter(String f1, String f2) {
		log("filtering by setting the min and max prices");
		minFilters.findElement(By.linkText(f1)).click();
		maxFilters.findElement(By.linkText(f2)).click();
	}

	public void openProduct(String name) {
		log("product opening");
		driver.findElement(By.partialLinkText(name)).click();
	}

	/****************************************************************/
	/************************ PRIVATE METHODS *************************/
	/****************************************************************/

	private Product convertRowToProduct(WebElement element) {
		String name = element.findElement(By.className("name")).getText();
		String price = element.findElement(By.className("price")).getText();
		String description = element.findElement(By.className("description"))
				.getText();
		String href = element.findElement(By.cssSelector(".name a")).getAttribute("href");
		System.out.println("HREEEEEEEEEFFFF = >>> " + href);
		price = price.replace(" ", "");
		price = price.substring(0, price.indexOf("г"));
		Double dprice = Double.parseDouble(price);
		Product tmp = new Product(name,href, dprice, description);
		return tmp;
	}

	

}
