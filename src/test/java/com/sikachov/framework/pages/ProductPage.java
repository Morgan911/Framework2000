package com.sikachov.framework.pages;

import static com.sikachov.framework.helpers.BaseHelper.log;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sikachov.framework.factories.MyPageFactory;
import com.sikachov.framework.helpers.ProductPageHelper;
import com.sikachov.framework.objects.Product;

public class ProductPage extends Page {

    private static final String sortByNameLink = "название";
    private static final String sortByPriceLink = "цена";
    private static final String pageSubHeader = "page-subheader";
    private static final String minPriceFilters = "//div[3]/div[2]";
    private static final String maxPriceFilters = "//div[4]/div[2]";
    private static final String lastPageNum = "last";
    private static final String nextButton = "//div[2]/div/div/ul/li[2]/a";
    private static final String productClass = "item";
    private static final String producerList = "//div/div/div/div[2]/div[5]/div[2]/a";
    private static final String producerAdditionalList = "//div/div[3]/div/div/div/div[2]/div[5]/div[2]/div[3]/a";
    private static final String showProducersBtn = "show_common_producer";
    private static final String pricesLinkPath = "//div/div[3]/div/div/div/div/div/a";

    @FindBy(className = lastPageNum)
    private WebElement lastPage;
    @FindBy(xpath = nextButton)
    private WebElement nextBtn;
    @FindBy(linkText = sortByNameLink)
    private WebElement sortByName;
    @FindBy(linkText = sortByPriceLink)
    private WebElement sortByPrice;
    @FindBy(id = pageSubHeader)
    private WebElement subHeader;
    @FindBy(className = productClass)
    private List<WebElement> products;
    @FindBy(xpath = minPriceFilters)
    private  WebElement minFilters;
    @FindBy(xpath = maxPriceFilters)
    private WebElement maxFilters;
    @FindBy(xpath = producerList)
    private List<WebElement> producers;
    @FindBy(xpath = producerAdditionalList)
    private List<WebElement> producersExt;
    @FindBy(className = showProducersBtn)
    private WebElement showAllButton;
    @FindBy(xpath = pricesLinkPath)
    private WebElement pricesLink;
   
    public ProductPage sortByName() {
	log("sort by name click");
	sortByName.click();
	return MyPageFactory.getPage(driver, ProductPage.class);
    }

    public ProductPage sortByPrice() {
	log("sort by price click");
	sortByPrice.click();
	return MyPageFactory.getPage(driver, ProductPage.class);
    }

    public void openAllProducers() {
	showAllButton.click();
    }

    public ProductPage openPageWithFunc(String functionName) {
	log("Open page with function " + functionName);
	driver.findElement(By.linkText(functionName)).click();
	return MyPageFactory.getPage(driver, ProductPage.class);
    }

    public PricesPage goToPrices() {
	log("open prices page");
	pricesLink.click();
	return MyPageFactory.getPage(driver, PricesPage.class);
    }

    public void filter(String f1, String f2) {
	log("Filtering by setting the min and max prices");
	minFilters.findElement(By.linkText(f1)).click();
	maxFilters.findElement(By.linkText(f2)).click();
    }

    public ProductInfoPage openProduct(String name) {
	log("product opening");
	driver.findElement(By.partialLinkText(name)).click();
	return MyPageFactory.getPage(driver, ProductInfoPage.class);
    }
    
    public List<WebElement> getProducts(int n) {
	List<WebElement> list = new ArrayList<>();
	for(int i = 0; i < n; i++){
	    list.add(products.get(i));
	}
        return list;
    }
    
    public static void clickAt(WebElement nextButton) {
  	nextButton.click();
      }
    
    public WebElement getNextButton() {
        return this.nextBtn;
    }
    
    public WebElement getLastPageNum() {
        return this.lastPage;
    }
    
    public WebElement getLastPage() {
        return lastPage;
    }

    public WebElement getNextBtn() {
        return nextBtn;
    }

    public WebElement getSortByName() {
        return sortByName;
    }

    public WebElement getSortByPrice() {
        return sortByPrice;
    }

    public WebElement getSubHeader() {
        return subHeader;
    }

    public List<WebElement> getProducts() {
        return products;
    }

    public WebElement getMinFilters() {
        return minFilters;
    }

    public WebElement getMaxFilters() {
        return maxFilters;
    }

    public List<WebElement> getProducers() {
        return producers;
    }

    public List<WebElement> getProducersExt() {
        return producersExt;
    }

    public WebElement getShowAllButton() {
        return showAllButton;
    }

    public WebElement getPricesLink() {
        return pricesLink;
    }

}
