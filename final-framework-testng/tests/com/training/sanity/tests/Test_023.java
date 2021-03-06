package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

//import java.awt.List;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import com.training.pom.DashBoardPOM_023;

import com.training.pom.LoginPOM_022;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Test_023 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_022 loginPOM;
	private DashBoardPOM_023 dashboardPOM;
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
		dashboardPOM = new DashBoardPOM_023(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First023");
		dashboardPOM.clickreportIcon();
		screenShot.captureScreenShot("Second023");
		dashboardPOM.clicksalesLink();
		screenShot.captureScreenShot("Third023");
		dashboardPOM.clicktaxLink();
		screenShot.captureScreenShot("Fourth023");
		dashboardPOM.clickfilterBtn();
		screenShot.captureScreenShot("Fifth023");


		// Group List box

		WebElement we=driver.findElement(By.id("input-group"));
		Select s1=new Select(we);
		s1.selectByVisibleText ("Weeks");
		List<WebElement> lst=s1.getOptions();
		System.out.println(" Group List options are : "+ lst.size());
		String expectedval = ("Years Months Weeks Days");
		boolean flag=false;
		for (int i=0;i<lst.size();i++)

		{
			String actualval=(lst.get(i).getText());
			//Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			if(expectedval.equals(actualval))
			{
				s1.selectByVisibleText(expectedval);
				flag=true;
				break;

			}

			//System.out.println("The actual values are : "+actualval);
			//System.out.println("The expected values are : "+expectedval);
			Assert.assertTrue(expectedval.contains(actualval));
		}

		// Tax display
		WebElement tax =driver.findElement(By.xpath("//td[contains(text(),'Tax Title')]"));
		String s=tax.getText();
		String expMsg = "Tax Title";
		Assert.assertEquals(expMsg,s);


		System.out.println("The header of tax details is : "+s);

		if (s.contains("Tax Title"))
		{
			System.out.println("Total number of tax for orders made in a week is displayed");
		}


	}


}



