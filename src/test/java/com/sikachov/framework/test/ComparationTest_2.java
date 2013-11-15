package com.sikachov.framework.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sikachov.framework.helpers.CompareHelper;
import com.sikachov.framework.helpers.NavHelper;
import com.sikachov.framework.helpers.TestDataProvider;
import com.sikachov.framework.pages.ComparationPage;
import com.sikachov.framework.pages.ProductPage;

public class ComparationTest_2 extends BaseTest {
	ComparationPage p;
	

	@Test(dataProvider = "catProvider", dataProviderClass = TestDataProvider.class)
	public void sameParamsTest(String category) {
		ProductPage productPage = NavHelper.getProductPage(driver, category);
		List<WebElement> els = productPage.getProducts(3);
		p = NavHelper.getComparationPage(driver, els);
		CompareHelper.verifySameParams(p.getSameParams());
		CompareHelper.verifyDifferentParams(p.getDifferentParams());
	}
}
