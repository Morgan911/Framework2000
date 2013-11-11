package com.sikachov.framework.helpers;

import org.testng.Reporter;

public class BaseHelper {
	
	public static void log(String message){
		Reporter.log("[LOG]"+ " " + message);
	}
}
