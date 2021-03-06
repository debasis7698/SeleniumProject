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
import com.training.pom.DashBoardPOM_084;
import com.training.pom.ProductPOM_084;

import com.training.pom.LoginPOM_022;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Test_084old {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_022 loginPOM;
	private DashBoardPOM_084 dashboardPOM;
	private ProductPOM_084 productPOM;
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
		//dashboardPOM = new DashBoardPOM_084(driver);
		dashboardPOM = new DashBoardPOM_084(driver);
		productPOM = new ProductPOM_084(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//driver.quit();
	}
	@Test
	public void createProductTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First053");
		dashboardPOM.clickcatalogIcon();
		screenShot.captureScreenShot("Second053");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			dashboardPOM.clickproductLink();
			screenShot.captureScreenShot("Third053");
			dashboardPOM.clickaddnewprdIcon();
			productPOM.sendprdtName(" aaa MRF BAT");
			JavascriptExecutor jse = (JavascriptExecutor)driver; 
			jse.executeScript("window.scrollBy(0,200)");
			productPOM.sendmetatagtitle("Cricket Bat");
			jse.executeScript("window.scrollBy(0,-200)");
			productPOM.clickdatatab();
			productPOM.sendmodeltxtBox("SKU-012");
			JavascriptExecutor jte = (JavascriptExecutor)driver; 
			jte.executeScript("window.scrollBy(0,200)");
			productPOM.sendpricetxtBox("500");
			productPOM.sendqtytxtBox("50");
			jte.executeScript("window.scrollBy(0,-200)");
			productPOM.clicklink();
			//productPOM.sendmanufacturerTxt("aaa Manufacturer");
			
			//---------------------------------------------------------------------
			
			// Manufacturer test box list of options			
			//driver.findElement(By.xpath("//input[@id='input-manufacturer']")).click();
			//driver.findElement(By.xpath("//input[@id='input-manufacturer']")).sendKeys(("aaa Manufacturer"),(Keys.DOWN),(Keys.DOWN)); 
			
			
			//Actions act=new Actions(driver);
			//act.sendKeys(Keys.TAB).perform();
			//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			//act.sendKeys(Keys.DOWN).perform();
			//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			//act.sendKeys(Keys.DOWN).perform();
			//act.click();
			//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			//JavascriptExecutor js = (JavascriptExecutor)driver;                
			//js.executeScript("document.querySelector(\"input[placeholder='Manufacturer']\").value='aaa Manufacturer'");
			//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			//------------------------------------------------------------------------------------
			
			// Categories test box list of options
			//driver.findElement(By.xpath("//input[@id='input-category']")).click();
			//driver.findElement(By.xpath("//input[@id='input-category']")).sendKeys(("EARRINGS"),(Keys.DOWN));
			
			//Actions act1=new Actions(driver);
			//act1.sendKeys(Keys.ENTER).perform();
			//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			//act1.sendKeys(Keys.DOWN).perform();
			//act1.click();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor)driver;                
			js.executeScript("document.querySelector(\"input[placeholder='Categories']\").value='aaa Sports'");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			
			//---------------------------------------------------------------------------
			
			//driver.findElement(By.xpath("//input[@id='input-manufacturer']")).sendKeys("aaa Manufacturer");
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.findElement(By.xpath("//a[contains(text(),'aaa Manufacturer']")).click();
			
			
			
			
			productPOM.clickattributetab();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			productPOM.clickattributetab();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			productPOM.clickrecurringTab();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			productPOM.clickdiscountTab();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			productPOM.clickspecialTab();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			productPOM.clickimageTab();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			productPOM.clickrewardpointTab();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			productPOM.clickdesignTab();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			
			
			JavascriptExecutor jpe = (JavascriptExecutor)driver; 
			jpe.executeScript("window.scrollBy(0,-250)");
			
			productPOM.clicksaveBtn();
			
	// Alert for Product modification
			
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			WebElement alert2 =driver.findElement(By.xpath("//div[@class='alert alert-success']"));
			String s2=alert2.getText();
			String expMsg2 = "Success: You have modified products!";
			assertTrue(expMsg2.equals(s2));
			
			System.out.println("The alert message is : "+s2);

			if (s2.contains("Success: You have modified products!"))
			{
				System.out.println("The product have been added");
			}
			
			//productPOM.clicklogoutBtn();
			
			//Product search
	
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			JavascriptExecutor jt = (JavascriptExecutor)driver;                
			//jt.executeScript("document.querySelector(\"input[@id='input-name']\").value='aaa MRF BAT'");
			
			//jt.executeScript("document.querySelector(\"input[placeholder='Product Name']\").value='aaa MRF BAT'");
			jt.executeScript("document.querySelector(\"input[placeholder='Price']\").value='500'");
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			productPOM.clickfilterBtn();
			
			//Product display
							WebElement order =driver.findElement(By.xpath("//tbody//tr[1]//td[3]"));
							String s=order.getText();
							String expMsg = "aaa MRF BAT";
							Assert.assertEquals(expMsg,s);
							//System.out.println("The expected message is : "+expMsg);
							//System.out.println("The actual message is : "+s);

							System.out.println("The product displayed is : "+s);

							if (s.contains("aaa MRF BAT"))
							{
								System.out.println("The product is displayed");
							}

							else
							{
								System.out.println("No product exist with selected criteria");
							}	
			
			
			
	
	}

	private void assertTrue(boolean equals) {
		// TODO Auto-generated method stub
	
		
		
		
		
		
	}

}







