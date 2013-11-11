package com.sikachov.framework.helpers.excel;

public class ExcelHelper {
	
	public static Object[][] getData(String path){
		IReader r = new ExcelReader(path);
		return r.read();
		
	}

}
