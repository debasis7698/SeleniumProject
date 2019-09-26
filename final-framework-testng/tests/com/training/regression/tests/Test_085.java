package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.training.dataproviders.LoginDataProviders_085;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM_022;
import com.training.pom.DashBoardPOM_085;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Test_085 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_022 loginPOM;
	private DashBoardPOM_085 dashboardPOM;
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
		dashboardPOM = new DashBoardPOM_085(driver);
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




	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders_085.class)
	//@Test(priority = 2, dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders_082.class)

	//public void createReturn(String orderidtext, String customertext,String firstnametext,String lastnametext,String emailtext,String telephonetext,String producttext,String modeltext ) throws InterruptedException {
	public void checkorders(String orderidText, String orderstatus,String dateadded,String custtext,String totaltext,String datemodified ) throws InterruptedException {	
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		String s = dtf.format(now);
		System.out.println(s);
		screenShot.captureScreenShot("RTTC_085_Login done"+s);
		dashboardPOM.clicksalesIcon();
		dashboardPOM.clickordersLink();
		dashboardPOM.sendorderidText(orderidText);
		dashboardPOM.sendorderstatus(orderstatus);
		dashboardPOM.senddateadded(dateadded);
		dashboardPOM.sendcusttext(custtext);
		dashboardPOM.sendtotaltext(totaltext);
		dashboardPOM.senddatemodified(datemodified);
		System.out.println("Pass these values to the Input");
		System.out.println("OrderID: " + orderidText + " OrderStatus: " + orderstatus +  "Dateadded: " + dateadded +  "Customer: " + custtext +  "Total: " + totaltext +  "DateModified: " + datemodified );

		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		dashboardPOM.clickfilterBtn();
		screenShot.captureScreenShot("RTTC_085_Search done"+s);

		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		dashboardPOM.clicklogoutBtn();

	}	



	private void assertTrue(boolean equals) {
		// TODO Auto-generated method stub

	}
}



