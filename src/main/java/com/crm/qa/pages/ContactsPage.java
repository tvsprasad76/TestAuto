package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;



public class ContactsPage extends TestBase {
 
 	@FindBy(xpath="//td[contains(text(), 'Contacts')]")
	WebElement contactsLabel;
 	
 	@FindBy(id="first_name")
	WebElement contactsFirstName;
 	@FindBy(id="surname")
	WebElement contactsLastName;
	@FindBy(name="client_lookup")
	WebElement contactsCompany;
	@FindBy(xpath="//input[@type= 'submit' and @value='Save' ]")
	WebElement clickSave;

public ContactsPage(){
	PageFactory.initElements(driver, this);
}


	
public boolean verifyContactsLabel(){
	return contactsLabel.isDisplayed();
}

public void clickOnNewContactsLink1(String title,String firstname,String lastname,String compname) throws InterruptedException{
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.name("title")));
	Select select = new Select(driver.findElement(By.name("title")));
	select.selectByVisibleText(title);
	contactsFirstName.sendKeys(firstname);
	contactsLastName.sendKeys(lastname);
	contactsCompany.sendKeys(compname);
	clickSave.click();
}
}

