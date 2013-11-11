package com.sikachov.framework.test;

import java.util.List;

import org.testng.annotations.Test;

import com.sikachov.framework.helpers.FilterHelper;
import com.sikachov.framework.helpers.NavHelper;
import com.sikachov.framework.helpers.TestDataProvider;
import com.sikachov.framework.objects.Product;
import com.sikachov.framework.pages.ProductPage;

public class FilterTest_3 extends BaseTest{
	
	@Test(dataProvider = "catProvider", dataProviderClass = TestDataProvider.class)
	public void filterTest(String category, String f1, String f2){
		goToMainPage();
		ProductPage p = NavHelper.getProductPage(driver, category);
		p.filter(f1, f2);
		List<Product> filteredProds = p.getProducts();
		FilterHelper.verifyFilterWork(filteredProds, f1, f2);
	}
	

}
