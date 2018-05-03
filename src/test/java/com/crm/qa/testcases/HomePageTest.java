package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.Util.*;


public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TasksPage tasksPage;
	DealsPage dealsPage;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		 loginPage = new LoginPage();
		 contactsPage = new ContactsPage();
		 homePage=loginPage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		 testUtil.switchToFrame();
	
	}
	
@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Hoeme Page title does not match");
	}
	
	@Test(priority=2)
	public void verifyHomepageUserTest() {	
		
		Assert.assertTrue(homePage.verifyHomePageUsername());		
	}
	
	@Test(priority=3)
	public void contacsPageNavigationTest() {
	
		contactsPage=homePage.goToContactsPage();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
