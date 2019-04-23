package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage login;
	HomePage homepage;
	ContactsPage contactspage;
	String sheetname ="contactsList";
	
	public ContactsPageTest(){
		super();		
	}
	
	@BeforeMethod
	public void setup() {
		initialize();
		login = new LoginPage();
		contactspage = new ContactsPage();
		homepage= login.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil tu = new TestUtil();
		tu.switchTo();
		contactspage=homepage.clickOnContacts();
	}

		@Test(priority=1)		
		public void verifyContactsLabelTest(){
			Assert.assertTrue(contactspage.verifyContactsLabel());
			
		}
		@DataProvider
		public Object[][] getCrmTestData() throws Exception{
			Object data[][]=TestUtil.getTestData(sheetname);
			return data;
		}
	 	@Test(dataProvider="getCrmTestData")
		public void validatecreateNewContacts(String title, String firstname, String lastname,String company )throws Exception{
			homepage.clickOnNewContactsLink();
			
			contactspage.clickOnNewContactsLink1(title, firstname, lastname, company);
		}
		
		
		
		@AfterMethod
	      public void abc(){
			driver.close();
		}
}
