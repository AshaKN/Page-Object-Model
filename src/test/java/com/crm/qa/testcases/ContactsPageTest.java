package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.Util.*;


public class ContactsPageTest extends TestBase{
	LoginPage  LoginPage;
	HomePage homepage;
	ContactsPage contactsPage ;
	TestUtil testUtil;
	String sheetName = "Contacts";
	
	ContactsPageTest(){
		super();
	}
	
@BeforeMethod
public void setup() throws InterruptedException {
initialization();
LoginPage = new LoginPage();
homepage = new HomePage();
testUtil = new TestUtil();
contactsPage = new ContactsPage();
LoginPage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
testUtil.switchToFrame();
homepage.goToContactsPage();
Thread.sleep(2000);
}

@Test(priority=0)
public void verifyContactsLabelTest() {
	Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label in not present");
}

@Test(priority=1)
public void contactsSearchByStatusTest() {
	contactsPage.contactsSearchByStatus(1);
	//contactsPage.contactsSearchResult();	
	
}
	
@Test(priority=2)
public void contactsSearchByCompanyTest() {
	contactsPage.contactsSearchByCompany("Micorsoft");
}

@DataProvider
public Object[][] getContactsTestData() {
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
}

//@Test(priority=3, dataProvider = "getContactsTestData")
public void createNewContactTest(String title, String fname, String lname, String cname){
	homepage.clickOnNewContactLink();
	contactsPage.createNewContact(title,fname,lname,cname);
}

@AfterTest
public void teardown() {
	driver.quit();
}
}