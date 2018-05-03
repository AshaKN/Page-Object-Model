package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage  LoginPage;
	HomePage homepage;
	LoginPageTest(){
		super();
	}
	
@BeforeMethod
public void setup() {
initialization();
LoginPage = new LoginPage();


}
@Test(priority=1)
public void LoginPageTitleTest() {
	String title = LoginPage.validateLoginPageTitle();
	Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
}

@Test(priority=2)
public void crmLogoTest() {
	boolean flag = LoginPage.validateLogo();
	Assert.assertTrue(flag);
	}
//@Test(priority=3)
public void LoginTest() {
	
	homepage =LoginPage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
}
@AfterMethod
public void teardown() {
	driver.quit();
}
}
