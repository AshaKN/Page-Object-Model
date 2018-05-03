package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import com.crm.qa.Util.*;


public class HomePage extends TestBase{
	
	TestUtil testUtil = new TestUtil();
	
	@FindBy(xpath="//font[contains(text(),'User: Naveen K')]") WebElement userNameLabel;
	@FindBy (xpath = "//a[contains(text(), 'Contacts')]") WebElement ContactsLink;
	@FindBy (xpath = "//a[contains(text(), 'New Contact')]") WebElement newContactLink;
	@FindBy (xpath = "//a[contains(text(), 'Deals')]") WebElement DealsLink;
	@FindBy (xpath = "//a[contains(text(), 'Tasks')]") WebElement TasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return  driver.getTitle();	
		}
	
	public boolean verifyHomePageUsername() {
	
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage goToContactsPage() {	
		ContactsLink.click();
		return new ContactsPage();
		//return new ContactsPage();		
	}
	
	public DealsPage goToDealsPage() {
		DealsLink.click();
		return new DealsPage();		
	}
	public TasksPage goToTasksPage() {
		TasksLink.click();
		return new TasksPage();	
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		newContactLink.click();
		
	}
}
