package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

//import java.awt.List;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.IOException;

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
import com.training.pom.DashBoardPOM_025;

import com.training.pom.LoginPOM_022;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Test_025 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_022 loginPOM;
	private DashBoardPOM_025 dashboardPOM;
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
		dashboardPOM = new DashBoardPOM_025(driver);
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
		screenShot.captureScreenShot("First");
		dashboardPOM.clickreportIcon();
		dashboardPOM.clicksalesLink();
		dashboardPOM.clickreturnLink();
		dashboardPOM.clickfilterBtn();

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

			//System.out.println("The actual values are : "+actualval);
			//System.out.println("The expected values are : "+expectedval);
			Assert.assertTrue(expectedval.contains(actualval));
		}

		//Return display
		WebElement returns =driver.findElement(By.xpath("//td[contains(text(),'No. Returns')]"));
		String s=returns.getText();
		String expMsg = "No. Returns";
		Assert.assertEquals(expMsg,s);

		System.out.println("The header of returns is : "+s);

		if (s.contains("No. Returns"))
		{
			System.out.println("Total number of Product returns details for returned orders made in a week is displayed");
		}

	}

}




