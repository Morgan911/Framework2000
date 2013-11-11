package com.sikachov.framework.test;

import org.testng.annotations.Test;

import com.sikachov.framework.helpers.FilterHelper;
import com.sikachov.framework.helpers.NavHelper;
import com.sikachov.framework.helpers.TestDataProvider;
import com.sikachov.framework.pages.ProductPage;

public class BreadMachineFilterTest_4 extends BaseTest{
	
	
	@Test(dataProvider = "catProvider", dataProviderClass = TestDataProvider.class)
	public void breadMachineTest(String category){
		ProductPage p =  NavHelper.getProductPage(driver, category);
		FilterHelper.verifyProducersInFilter(p);
	}
}
