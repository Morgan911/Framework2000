package com.sikachov.framework.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sikachov.framework.helpers.FilterHelper;
import com.sikachov.framework.helpers.NavHelper;
import com.sikachov.framework.helpers.TestDataProvider;
import com.sikachov.framework.objects.Product;
import com.sikachov.framework.pages.ProductPage;

public class WeigthFilterTest_5 extends BaseTest{
	
	@Test(dataProvider = "catProvider", dataProviderClass = TestDataProvider.class)
	public void weigthTest(String product, String ss){
		ProductPage p = NavHelper.getProductPage(driver, product);
		p.openPageWithFunc(ss);
		List<Product> prods = p.getProducts();
		prods = FilterHelper.getListWithString(ss, prods);
		
		
		List<Product> prodsWithFunc = p.getProducts();
		Assert.assertEquals(prods, prodsWithFunc);
	}
}
