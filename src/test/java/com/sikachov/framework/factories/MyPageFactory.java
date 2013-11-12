package com.sikachov.framework.factories;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.sikachov.framework.pages.Page;


public class MyPageFactory {
	


  public static <T extends Page> T getPage(WebDriver driver, Class<T> pageClass) {
    T page = instantiatePage(driver, pageClass);
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 4), page);
    page.driver = driver;
    return page;
  }

  private static <T> T instantiatePage(WebDriver driver, Class<T> pageClassToProxy) {
    try {
      try {
        Constructor<T> constructor = pageClassToProxy.getConstructor(WebDriver.class);
        return constructor.newInstance(driver);
      } catch (NoSuchMethodException e) {
        return pageClassToProxy.newInstance();
      }
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }
}
