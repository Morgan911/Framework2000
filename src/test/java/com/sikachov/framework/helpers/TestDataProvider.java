package com.sikachov.framework.helpers;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.sikachov.framework.helpers.excel.ExcelHelper;

public class TestDataProvider {

	@DataProvider(name = "catProvider")
	public static Object[][] provider(Method method) {
		String fileName = method.getDeclaringClass().getSimpleName();
		
		String filePath = "../exlData/"
				+ fileName + ".xls";
		return ExcelHelper.getData(filePath);
	}
}
