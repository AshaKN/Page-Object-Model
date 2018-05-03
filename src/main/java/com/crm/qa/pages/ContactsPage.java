package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

@FindBy(xpath="//td[contains(text(),'Contacts')]") 
@CacheLookup
WebElement contactsLabel;
@FindBy(name="cs_status") WebElement Status;
@FindBy(name = "cs_submit") WebElement ContactsSearchBtn;
@FindBy(name="cs_name") WebElement contactsName;
@FindBy(name = "cs_company_name") WebElement companyName;
@FindBy(name="title") WebElement Title;
@FindBy(id="first_name") WebElement firstName;
@FindBy(id="surname") WebElement lastName;
@FindBy(id="client_lookup") WebElement companyLookup;
@FindBy(xpath="//input[@type='submit' and @value='Save']") WebElement saveBtn;

public ContactsPage() {
	PageFactory.initElements(driver, this);
}

public boolean verifyContactsLabel() {
 	return contactsLabel.isDisplayed();
}

public void selectContactByName(String name) {
	
	contactsName.sendKeys(name);
	ContactsSearchBtn.click();
}

public void contactsSearchByStatus(int i) {
	Select StatusValue = new Select(Status);
	StatusValue.selectByIndex(i);
	//selectByValue(st);
	ContactsSearchBtn.click();
}

public void contactsSearchByCompany(String nm) {

	companyName.sendKeys(nm);
	ContactsSearchBtn.click();
}

public void contactsSearchResult() {
	List<WebElement> searchResult = driver.findElements(By.xpath("//[@id='vContactsForm']/table/tbody/tr"));
	System.out.println("Total No. Of records = " +searchResult.size());
}

public void createNewContact(String title, String fname, String lname, String cname) {
	Select select = new Select(Title);
	select.selectByVisibleText(title);
	firstName.sendKeys(fname);
	lastName.sendKeys(lname);
	saveBtn.click();
}
}
