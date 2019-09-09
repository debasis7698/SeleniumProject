package com.training.sanity.tests;

//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;

//import java.awt.List;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
import com.training.pom.DashBoardPOM_021;
import com.training.pom.CustomerPOM_021;
import com.training.pom.LoginPOM_022;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Test_021 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_022 loginPOM;
	private DashBoardPOM_021 dashboardPOM;
	private CustomerPOM_021 customerPOM;
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
		dashboardPOM = new DashBoardPOM_021(driver);
		customerPOM = new CustomerPOM_021(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//driver.quit();
	}

	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First021");
		dashboardPOM.clickcustomerIcon();
		screenShot.captureScreenShot("Second021");
		dashboardPOM.clickcustomerLink();
		screenShot.captureScreenShot("Third021");
		customerPOM.clickcheckbox();
		screenShot.captureScreenShot("Fourth021");
		//customerPOM.clickdeleteicon();
		screenShot.captureScreenShot("Fifth021");

		//WebElement radioBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/form/div/table/tbody/tr[4]/td[1]"));
		//radioBtn.click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//Deletebutton
		WebElement deletebtn = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/button"));	
		deletebtn.click();

		//Alert
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		WebElement alert =driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		String s=alert.getText();
		String expMsg = "Success: You have modified customers!";
		assertTrue(expMsg.equals(s));
		System.out.println(s);

		if (s.contains("Success: You have modified customers!"))
		{
			System.out.println("Customer deleted");
		}

	}

	private void assertTrue(boolean equals) {
		// TODO Auto-generated method stub
		
	}



}		




