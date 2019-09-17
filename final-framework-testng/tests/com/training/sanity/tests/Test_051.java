package com.training.sanity.tests;

//import static org.testng.Assert.assertEquals;

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
import com.training.pom.DashBoardPOM_051;
import com.training.pom.CustomerGroupsPOM_051;
import com.training.pom.AddCustomerPOM_051;
import com.training.pom.LoginPOM_022;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Test_051 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_022 loginPOM;
	private DashBoardPOM_051 dashboardPOM;
	private CustomerGroupsPOM_051 customergroupPOM;
	private AddCustomerPOM_051 addcustomerPOM;
	private static Properties properties;
	private ScreenShot screenShot;


	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM_022(driver); 
		dashboardPOM = new DashBoardPOM_051(driver);
		customergroupPOM = new CustomerGroupsPOM_051(driver);
		addcustomerPOM = new AddCustomerPOM_051(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);

	}

	//@BeforeMethod
	//public void setUp() throws Exception {
		//driver = DriverFactory.getDriver(DriverNames.CHROME);
		//loginPOM = new LoginPOM_022(driver); 
		//dashboardPOM = new DashBoardPOM_051(driver);
		//customergroupPOM = new CustomerGroupsPOM_051(driver);
		//addcustomerPOM = new AddCustomerPOM_051(driver);
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
	public void CreateCustomerGroup() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First051");
		dashboardPOM.clickcustomerIcon();
		dashboardPOM.clickcustomergroupLink();
		dashboardPOM.clickaddNewIcon();
		customergroupPOM.sendcustgrnameText("privileged customer");
		customergroupPOM.senddesc("privileged customer desc");
		customergroupPOM.clickradiobtnYes();
		customergroupPOM.clicksaveBtn();
		//dashboardPOM.clickcustomerIcon();
		//dashboardPOM.clickcustomerLink();
		
		// Alert for Customer Group Addition
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement alert =driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		String s=alert.getText();
		String expMsg = "Success: You have modified customer groups!";
		assertTrue(expMsg.equals(s));
		//System.out.println("The expected message is : "+expMsg);
		//System.out.println("The actual message is : "+s);

		System.out.println("The alert message is : "+s);

		if (s.contains("Success: You have modified customer groups!"))
		{
			System.out.println("The Group name has been added in Customer Group List");
		}
		
	}
		
	@Test(priority=2)
	public void CreateCustomer() throws InterruptedException {
	
		dashboardPOM.clickcustomerIcon();
		dashboardPOM.clickcustomerLink();
		dashboardPOM.clickaddnewBtn();
		
	// Customer Group List box	selection
	
				WebElement we=driver.findElement(By.name("customer_group_id"));
				Select s1=new Select(we);
				s1.selectByVisibleText ("privileged customer");
			
			// Customer addition	
				addcustomerPOM.sendfirstName("aaamanzoor");
				addcustomerPOM.sendlastName("mehadi");
				addcustomerPOM.sendemail("man2@gmail.com"); // to change
				addcustomerPOM.sendtelephone("9876543210");
				addcustomerPOM.sendpassword("manzoor1");
				JavascriptExecutor jse = (JavascriptExecutor)driver; 
				jse.executeScript("window.scrollBy(0,200)");
				addcustomerPOM.sendconfirm("manzoor1");
				jse.executeScript("window.scrollBy(0,-200)");
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				addcustomerPOM.clickaddAddress();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				addcustomerPOM.sendfirstName1("aaamanzoor");
				addcustomerPOM.sendlastName1("mehadi");
				addcustomerPOM.sendaddress1("yeshwanthapur");
				addcustomerPOM.sendaddress2("bangalore");
				addcustomerPOM.sendcity("bangalore");
				JavascriptExecutor jte = (JavascriptExecutor)driver; 
				jte.executeScript("window.scrollBy(0,200)");
								
				addcustomerPOM.sendpostcode("560022");
		
			// Country List box selection
				WebElement cn=driver.findElement(By.id("input-country1"));
				Select s2=new Select(cn);
				s2.selectByVisibleText ("India");
				
			// Region/State List box selection
				WebElement rg=driver.findElement(By.id("input-zone1"));
				Select s3=new Select(rg);
				s3.selectByVisibleText ("Karnataka");
				jte.executeScript("window.scrollBy(0,-200)");
				
				addcustomerPOM.clicksaveBtn();
				
				// Customer detail save alert
				
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				WebElement alert1 =driver.findElement(By.xpath("//div[@class='alert alert-success']"));
				String s4=alert1.getText();
				String expMsg1 = "Success: You have modified customers!";
				assertTrue(expMsg1.equals(s4));
				//System.out.println("The expected message is : "+expMsg);
				//System.out.println("The actual message is : "+s);

				System.out.println("The alert message is : "+s4);

				if (s4.contains("Success: You have modified customers!"))
				{
					System.out.println("The Customer have been added");
				}	
				
				

	}

	private void assertTrue(boolean equals) {
		// TODO Auto-generated method stub
		
	}

}






