package com.sikachov.framework.helpers.screenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import static com.sikachov.framework.helpers.BaseHelper.log;

import com.sikachov.framework.factories.WebDriverFactory;

public class ScreenShotOnFailure extends TestListenerAdapter {

    private static WebDriver driver;

    @Override
    public void onTestFailure(ITestResult tr) {

	File scrFile = ((TakesScreenshot) driver)
		.getScreenshotAs(OutputType.FILE);
	DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy__hh_mm_ssaa");

	String destDir = "../target/surefire-reports/html/screenshots/";

	new File(destDir).mkdirs();
	String destFile = dateFormat.format(new Date()) + ".png";
	try {
	    FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	Reporter.setEscapeHtml(false);
	String path = "screenshots/" +destFile;
	log("<a href = " + path + "><img src =" + path + " width = 100 heigth = 200/></a>");
    }

    public static WebDriver getDriver() {
	return driver;
    }

    public static void setDriver(WebDriver driver) {
	ScreenShotOnFailure.driver = driver;
    }
}
