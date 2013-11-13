package com.sikachov.framework.test;

import static com.sikachov.framework.helpers.BaseHelper.log;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import com.sikachov.framework.configs.Config;
import com.sikachov.framework.factories.WebDriverFactory;
import com.sikachov.framework.helpers.screenshot.ScreenShotOnFailure;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setBrowserName(System.getProperty("webdriver.browser", "firefox"));
	goToMainPage();
	driver = WebDriverFactory.getDriver(caps);
	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	ScreenShotOnFailure.setDriver(driver);
	
    }

    public void goToMainPage() {
	System.setProperty("org.uncommons.reportng.escape-output", "false");
	log("open main page");
	driver.navigate().to(Config.BASE_ADDRESS);
    }

}
