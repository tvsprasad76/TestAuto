package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;


//Test
public class HomePageTest extends TestBase {
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil tu = new TestUtil();
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialize();
		LoginPage Login = new LoginPage();
		homepage = Login.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void verifyHomePageTitleTest(){
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","HomePagetitle is not correct");
		 
	}
	
	@Test
	public void verifyUsernameTest(){
		TestUtil tu = new TestUtil();
		tu.switchTo();
		Assert.assertTrue(homepage.verifyUsername());
	}
	
	@Test
	public void verifyContactsLinkTest(){
		tu.switchTo();
		contactspage= homepage.clickOnContacts();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
