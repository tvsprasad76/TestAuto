package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class HomePage extends TestBase{
	
 @FindBy(xpath ="//td[contains(text(),'User: Prasad TVS')]")
 WebElement usernameLabel;
 
 @FindBy(xpath="//a[contains(text(), 'Deals'")
 WebElement DealsLink;
 
 @FindBy(xpath="//a[contains(text(), 'Contacts')]")
 WebElement ContactLink;
 
 @FindBy(xpath="//a[contains(text(), 'New Contact')]")
 WebElement newContactLink;
 public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
 
 public String verifyHomePageTitle(){
	 return driver.getTitle();
 }
  public boolean verifyUsername(){
	  return usernameLabel.isDisplayed();
  }
 
 public ContactsPage clickOnContacts(){
	 ContactLink.click();
	  return new ContactsPage();
 }
 
 public void clickOnNewContactsLink(){
	Actions action = new Actions(driver);
	action.moveToElement(ContactLink);
	newContactLink.click();
	}
 
 }

