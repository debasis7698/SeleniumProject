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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;
import com.training.generics.ScreenShot;
import com.training.pom.DashBoardPOM_052;
import com.training.pom.AddCustomerPOM_052;
import com.training.pom.ReportsPOM_052;

import com.training.pom.LoginPOM_022;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Test_052 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_022 loginPOM;
	private DashBoardPOM_052 dashboardPOM;
	private AddCustomerPOM_052 addcustomerPOM;
	private ReportsPOM_052 reportsPOM;
	private static Properties properties;
	private ScreenShot screenShot;


	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM_022(driver); 
		dashboardPOM = new DashBoardPOM_052(driver);
		addcustomerPOM = new AddCustomerPOM_052(driver);
		reportsPOM = new ReportsPOM_052(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		

	}

	//@BeforeMethod
	//public void setUp() throws Exception {
		//driver = DriverFactory.getDriver(DriverNames.CHROME);
		//loginPOM = new LoginPOM_022(driver); 
		//dashboardPOM = new DashBoardPOM_052(driver);
		//addcustomerPOM = new AddCustomerPOM_052(driver);
		//reportsPOM = new ReportsPOM_052(driver);
		//baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		//driver.get(baseUrl);
	//}

	@AfterClass
	public void tearDown() throws Exception {
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//driver.quit();
	}
	@Test(priority=1)
	public void addrewardspoints() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First052");
		dashboardPOM.clickcustomerIcon();
		dashboardPOM.clickcustomerLink();
		dashboardPOM.clickeditcustIcon();
		addcustomerPOM.sendfirstName("Asmita"); 
		addcustomerPOM.clickaddAddress1();
		addcustomerPOM.sendpostcode("8796545");
		addcustomerPOM.clickrewardpoint();
		addcustomerPOM.senddesc("review");
		addcustomerPOM.sendpoints("50");
		addcustomerPOM.clickaddrewardptsBtn();
		
		//Alert after reward point
		
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				WebElement alert =driver.findElement(By.xpath("//div[@class='alert alert-success']"));
				String s=alert.getText();
				String expMsg = "Success: You have modified customers!";
				assertTrue(expMsg.equals(s));
				//System.out.println("The expected message is : "+expMsg);
				//System.out.println("The actual message is : "+s);

				System.out.println("The alert message is : "+s);

				if (s.contains("Success: You have modified customers!"))
				{
					System.out.println("The reward point have been added");
				}
		
				addcustomerPOM.clicksaveBtn();
				
				
				//Alert after save	
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				WebElement alert1 =driver.findElement(By.xpath("//div[@class='alert alert-success']"));
				String s1=alert1.getText();
				String expMsg1 = "Success: You have modified customers!";
				assertTrue(expMsg1.equals(s1));
				//System.out.println("The expected message is : "+expMsg);
				//System.out.println("The actual message is : "+s);

				System.out.println("The alert message is : "+s1);

				if (s1.contains("Success: You have modified customers!"))
				{
					System.out.println("The customer have been edited");
				}
				
	}
	
	@Test(priority=2)
	public void rewardsaddedtocustomers() throws InterruptedException {
			
				reportsPOM.clickreportsIcon();
				reportsPOM.clickcustLink();
				reportsPOM.clickrewardpointsLink();
				
			// Reward point list display
				WebElement rp =driver.findElement(By.xpath("//td[contains(text(),'Reward Points')]"));
				String s3=rp.getText();
				String expMsg3 = "Reward Points";
				Assert.assertEquals(expMsg3,s3);
				//System.out.println("The expected message is : "+expMsg);
				//System.out.println("The actual message is : "+s);

				System.out.println("The header of reward point list is : "+s3);

				if (s3.contains("Reward Points"))
				{
					System.out.println("List of Rewards added to the customer is displayed");
				}	
				
				
				
	}

	private void assertTrue(boolean equals) {
		// TODO Auto-generated method stub
		
	}

}








