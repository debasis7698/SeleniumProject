package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders_083;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM_022;
import com.training.pom.ReturnPOM_083;
import com.training.pom.DashBoardPOM_083;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Test_083 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_022 loginPOM;
	private DashBoardPOM_083 dashboardPOM;
	private ReturnPOM_083 returnPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		
		
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM_022(driver);
		dashboardPOM = new DashBoardPOM_083(driver);
		returnPOM = new ReturnPOM_083(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
		public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	//@Test(priority=1)
	//public void addReturn() throws InterruptedException {
		//loginPOM.sendUserName("admin");
		//loginPOM.sendPassword("admin@123");
		//loginPOM.clickLoginBtn(); 
		//screenShot.captureScreenShot("First082");
		//dashboardPOM.clicksalesIcon();
		//dashboardPOM.clickreturnLink();
		//dashboardPOM.clickaddnewIcon();
		
	
	//}
	
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders_083.class)
	//@Test(priority = 2, dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders_083.class)
	
	public void createReturn(String orderidtext, String customertext,String firstnametext,String lastnametext,String emailtext,String telephonetext,String producttext,String modeltext ) throws InterruptedException {
		
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		String s3 = dtf.format(now);
		System.out.println(s3);
		screenShot.captureScreenShot("RTTC_083_Login done"+s3);
		
		
		dashboardPOM.clicksalesIcon();
		dashboardPOM.clickreturnLink();
		dashboardPOM.clickaddnewIcon();
			
		//loginPOM.sendUserName(userName);
		//loginPOM.sendPassword(password);
		returnPOM.sendeorderidtext(orderidtext);
		returnPOM.sendcustomertext(customertext);
		returnPOM.sendfirstnametext(firstnametext);
		returnPOM.sendlastnametext(lastnametext);
		returnPOM.sendemailnametext(emailtext);
		returnPOM.sendetelephonetext(telephonetext);
		returnPOM.sendeproducttext(producttext);
		returnPOM.sendemodeltext(modeltext);
		JavascriptExecutor jse = (JavascriptExecutor)driver; 
		jse.executeScript("window.scrollBy(0,-200)");
		returnPOM.clicksaveBtn();
		
		// Alert after return not created 
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				WebElement alert =driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
				String s=alert.getText();
				String expMsg = "Warning: Please check the form carefully for errors!";
				assertTrue(expMsg.equals(s));
				//System.out.println("The expected message is : "+expMsg);
				//System.out.println("The actual message is : "+s);

				System.out.println("The alert message after return not created : "+s);

				if (s.contains("Warning: Please check the form carefully for errors!"))
				{
					System.out.println("Return not created");
				}
		
				screenShot.captureScreenShot("RTTC_083_Return not created"+s3);
		        
				
				
				
	}

	private void assertTrue(boolean equals) {
		// TODO Auto-generated method stub
		
	}
}
	

