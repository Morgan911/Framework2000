package com.sikachov.framework.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.sikachov.framework.helpers.NavHelper;
import com.sikachov.framework.helpers.SortHelper;
import com.sikachov.framework.helpers.TestDataProvider;
import com.sikachov.framework.objects.Product;
import com.sikachov.framework.pages.ProductPage;

public class FridgeSortTest_1 extends BaseTest {

    @Test(dataProvider = "catProvider", dataProviderClass = TestDataProvider.class)
    public void fridgeSortTest(String category) {
	List<Product> productsUnsorted = new ArrayList<Product>();
	ProductPage productPage = NavHelper.getProductPage(driver, category);
	List<Product> productsSortedByName = productPage.sortByName()
		.getProducts();
	productsUnsorted.addAll(productsSortedByName);
	SortHelper.verifyNameSorting(productsUnsorted, productsSortedByName);
	List<Product> productsSortedByPrice = productPage.sortByPrice()
		.getProducts();
	SortHelper.verifyPriceSorting(productsUnsorted, productsSortedByPrice);
    }

}
