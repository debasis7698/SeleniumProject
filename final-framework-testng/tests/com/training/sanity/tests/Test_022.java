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

//import com.google.common.collect.ImmutableList;
import com.training.generics.ScreenShot;
import com.training.pom.DashBoardPOM_022;

import com.training.pom.LoginPOM_022;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Test_022 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_022 loginPOM;
	private DashBoardPOM_022 dashboardPOM;
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
		dashboardPOM = new DashBoardPOM_022(driver);
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
		screenShot.captureScreenShot("First022");
		dashboardPOM.clickreportIcon();
		screenShot.captureScreenShot("Second022");
		dashboardPOM.clicksalesLink();
		screenShot.captureScreenShot("Third022");
		dashboardPOM.clickordersLink();
		screenShot.captureScreenShot("Fourth022");
		screenShot.captureScreenShot("Fifth022");
		dashboardPOM.clickfilterBtn();
		screenShot.captureScreenShot("Sixth022");





		// Group List box

		WebElement we=driver.findElement(By.id("input-group"));
		Select s1=new Select(we);
		s1.selectByVisibleText ("Weeks");
		List<WebElement> lst=s1.getOptions();
		System.out.println("Group List options are : "+ lst.size());
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


			//System.out.println("The actual values of group list are : "+actualval);
			//System.out.println("The expected values of group list are : "+expectedval);
			Assert.assertTrue(expectedval.contains(actualval));
		}

		// Order display
		WebElement order =driver.findElement(By.xpath("//td[contains(text(),'No. Orders')]"));
		String s=order.getText();
		String expMsg = "No. Orders";
		Assert.assertEquals(expMsg,s);
		//System.out.println("The expected message is : "+expMsg);
		//System.out.println("The actual message is : "+s);

		System.out.println("The header of order details is : "+s);

		if (s.contains("No. Orders"))
		{
			System.out.println("Total number of orders made in a week is displayed");
		}



	}




}

