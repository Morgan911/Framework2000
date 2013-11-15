package com.sikachov.framework.test;

import java.util.List;

import org.testng.annotations.Test;

import com.sikachov.framework.helpers.FilterHelper;
import com.sikachov.framework.helpers.NavHelper;
import com.sikachov.framework.helpers.ProductPageHelper;
import com.sikachov.framework.helpers.TestDataProvider;
import com.sikachov.framework.objects.Product;
import com.sikachov.framework.pages.ProductPage;

public class BreadMachineFilterTest_4 extends BaseTest{
	
	
	@Test(dataProvider = "catProvider", dataProviderClass = TestDataProvider.class)
	public void breadMachineTest(String category){
		ProductPage p =  NavHelper.getProductPage(driver, category);
		List<String> allProducersFromProducts = ProductPageHelper.getProductProducers(p); 
		List<String> allSidebarProducers = ProductPageHelper.getProducersFromSidebar(p); 
		FilterHelper.verifyProducersInFilter(allProducersFromProducts, allSidebarProducers);
	}
}
