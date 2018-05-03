package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.Util.TestUtil;
import com.crm.qa.Util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListner;
	public TestBase() {
		try {
		prop = new Properties();
		FileInputStream input = new FileInputStream("C:\\Users\\Asha\\Desktop\\Selenium\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(input);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
}
	public static void initialization() {
	String URL= prop.getProperty("URL");
	String BrowserNm = prop.getProperty("Browser");
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	if (BrowserNm.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	else if (BrowserNm.equals("FireFox")) {
		System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
	}					   
	else if (BrowserNm.equals("IE")) {
		System.setProperty("webdriver.IE.driver", "C:\\InternetExplorerDriver.exe");
		driver = new InternetExplorerDriver();
	}
	 e_driver = new EventFiringWebDriver(driver);
	 eventListner = new WebEventListener();
	e_driver.register(eventListner);
	driver = e_driver;
	
	driver.get(URL);
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_TimeOut	, TimeUnit.SECONDS);
}
	
	
}