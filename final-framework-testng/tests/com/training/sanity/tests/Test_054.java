package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

//import java.awt.List;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import browser.BrowserGetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;
import com.training.generics.ScreenShot;
import com.training.pom.DashBoardPOM_054;
import com.training.pom.AddOrderPOM_054;

import com.training.pom.LoginPOM_022;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Test_054 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_022 loginPOM;
	private DashBoardPOM_054 dashboardPOM;
	private AddOrderPOM_054 addorderPOM;
	private static Properties properties;
	private ScreenShot screenShot;


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM_022(driver); 
		dashboardPOM = new DashBoardPOM_054(driver);
		addorderPOM = new AddOrderPOM_054(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First054");
		dashboardPOM.clicksalesIcon();
		dashboardPOM.clickordersLink();
		dashboardPOM.clickaddnewIcon();
		JavascriptExecutor jse = (JavascriptExecutor)driver; 
		jse.executeScript("window.scrollBy(0,400)");
		addorderPOM.sendFirstName("aaa1");
		addorderPOM.sendLastName("deb");
		addorderPOM.sendemail("aaa1@gmail.com");
		addorderPOM.sendtelephone("9876543210");
		addorderPOM.clickcontinueBtn();
		
	// Choose product textbox
					
					driver.findElement(By.xpath("//input[@id='input-product']]")).sendKeys("Lorem ipsum dolor sit amet");
					Actions act=new Actions(driver);
					act.sendKeys(Keys.ENTER).perform();
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
		addorderPOM.sendquantity("1");
		addorderPOM.clickaddprdtBtn();
		

	}

}





