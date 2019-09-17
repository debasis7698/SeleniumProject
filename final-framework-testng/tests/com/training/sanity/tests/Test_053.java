package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

//import java.awt.List;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.training.pom.DashBoardPOM_053;
import com.training.pom.OrderPOM_053;


import com.training.pom.LoginPOM_022;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Test_053 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_022 loginPOM;
	private DashBoardPOM_053 dashboardPOM;
	private OrderPOM_053 orderPOM;
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
		dashboardPOM = new DashBoardPOM_053(driver);
		orderPOM= new OrderPOM_053(driver);
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
	public void validInvoice() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First053");
		dashboardPOM.clickorderIcon();
		dashboardPOM.clickorderLink();
		JavascriptExecutor jse = (JavascriptExecutor)driver; 
		jse.executeScript("window.scrollBy(0,300)");
		orderPOM.clickviewIcon();
		orderPOM.clickgenerateIcon();
		
		//-------------------------------------------------------------
		// validate Invoice is created
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement inv =driver.findElement(By.xpath("//td[@id='invoice']"));
		String s=inv.getText();
		String expMsg = "INV";
		assertTrue(s.contains(expMsg));
		//System.out.println("The expected message is : "+expMsg);
		//System.out.println("The actual message is : "+s);

		System.out.println("The invoice have been generated");

		
		
		
		
		//----------------------------------------------------------------
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		JavascriptExecutor jte = (JavascriptExecutor)driver; 
		jte.executeScript("window.scrollBy(0,300)");
		
		// Order status list box
		WebElement we=driver.findElement(By.name("order_status_id"));
		Select order=new Select(we);
		order.selectByVisibleText ("Complete");
		
	      orderPOM.clickaddhistBtn();
	      
		//Alert for add history 
	   	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			WebElement alert =driver.findElement(By.xpath("//div[@class='alert alert-success']"));
			String s1=alert.getText();
			String expMsg1 = "Success: You have modified orders!";
			assertTrue(expMsg1.equals(s1));
			//System.out.println("The expected message is : "+expMsg);
			//System.out.println("The actual message is : "+s);

			System.out.println("The alert message is : "+s1);

			if (s1.contains("Success: You have modified orders!"))
			{
				System.out.println("The Order have been modified");
			}
		
		

	}

	private void assertTrue(boolean equals) {
		// TODO Auto-generated method stub
		
	}

}






