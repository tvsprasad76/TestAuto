package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.utilities.TestUtil;

public class TestBase {
 public static WebDriver driver;
 public static Properties prop;
 
 public TestBase()
 {
	 try {
		 prop = new Properties();
		 FileInputStream ip = new FileInputStream("C:\\Users\\TVS PRASAD\\workspace\\HashMapPractice\\FreeCRMTestAutomationPOM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		 prop.load(ip);
	 }
	 catch(FileNotFoundException e)
	 {e.printStackTrace();
 }
	 catch(IOException e)
	 {		 e.printStackTrace();
	 }
 }
 public  static void initialize(){
	String browserName =  prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","C:/chromedriver/chromedriver.exe");	
		driver = new ChromeDriver();
	}
	else if (browserName.equals("firefox")){
		System.setProperty("webdriver.gecko.driver","C:/Users/TVS PRASAD/Desktop/Selenium-3.4.0/geckodriver-v0.20.0-win64/geckodriver.exe");	
		driver = new FirefoxDriver();
	}	else System.out.println("FAILED");
 
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
	
 
 
 }

}
