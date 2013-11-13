package com.sikachov.framework.test;

import org.testng.annotations.Test;

import com.sikachov.framework.helpers.CompareHelper;
import com.sikachov.framework.helpers.TestDataProvider;
import com.sikachov.framework.objects.Product;

public class CompareInfoTest_6 extends BaseTest{

	@Test(dataProvider = "catProvider", dataProviderClass = TestDataProvider.class)
	public void test(String category, String num){
		CompareHelper.veryfyTextOnPages(driver,category, num);
		
	}
	
}
