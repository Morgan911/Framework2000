package com.sikachov.framework.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sikachov.framework.helpers.FilterHelper;
import com.sikachov.framework.helpers.NavHelper;
import com.sikachov.framework.helpers.ProductPageHelper;
import com.sikachov.framework.helpers.TestDataProvider;
import com.sikachov.framework.objects.Product;
import com.sikachov.framework.pages.ProductPage;

public class WeigthFilterTest_5 extends BaseTest{
	
	@Test(dataProvider = "catProvider", dataProviderClass = TestDataProvider.class)
	public void weigthTest(String product, String function){
		ProductPage p = NavHelper.getProductPage(driver, product);
		List<Product> allProducts = ProductPageHelper.getProducts(p);
		p.openPageWithFunc(function);
		List<Product> productsWithFunc = ProductPageHelper.getProducts(p);
		FilterHelper.verifyTextPresent(allProducts,productsWithFunc, function);
	}
}
