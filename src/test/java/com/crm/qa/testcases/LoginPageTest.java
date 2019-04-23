package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage login;
	HomePage homepage;
	

	public LoginPageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initialize();
		login = new LoginPage();
		
	}
	
	@Test
	public void LoginPageTitleTest(){
		String ActTitle = login.loginPageTitle();
		String ExTitle = "CRMPRO Log In Screen";
		System.out.println(ActTitle);
		System.out.println(ExTitle);
		Assert.assertEquals(ActTitle,ExTitle);
		}
	
	/*@Test
	public void crmImageLogoTest(){
		boolean flag = login.validateLogo();
		Assert.assertEquals(flag, true);
	
	}
	
	@Test
	public void loginTest(){
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}*/
	
	@AfterMethod
      public void abc(){
		driver.close();
	}
}
