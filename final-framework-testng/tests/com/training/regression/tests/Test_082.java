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
import com.training.dataproviders.LoginDataProviders_082;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM_022;
import com.training.pom.ReturnPOM_082;
import com.training.pom.DashBoardPOM_082;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Test_082 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_022 loginPOM;
	private DashBoardPOM_082 dashboardPOM;
	private ReturnPOM_082 returnPOM;
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
		dashboardPOM = new DashBoardPOM_082(driver);
		returnPOM = new ReturnPOM_082(driver);
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




	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders_082.class)
	//@Test(priority = 2, dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders_082.class)

	public void createReturn(String orderidtext, String customertext,String firstnametext,String lastnametext,String emailtext,String telephonetext,String producttext,String modeltext ) throws InterruptedException {

		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		String s3 = dtf.format(now);
		System.out.println(s3);
		screenShot.captureScreenShot("RTTC_082_Login done"+s3);
		screenShot.captureScreenShot("First082");
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

		// Alert after return create 
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement alert =driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		String s=alert.getText();
		String expMsg = "Success: You have modified returns!";
		assertTrue(expMsg.equals(s));
		//System.out.println("The expected message is : "+expMsg);
		//System.out.println("The actual message is : "+s);

		System.out.println("The alert message after create return is : "+s);

		if (s.contains("Success: You have modified returns!"))
		{
			System.out.println("Return created");
		}
		screenShot.captureScreenShot("Second082");
		screenShot.captureScreenShot("RTTC_082_Return created"+s3);
		returnPOM.clickcheckbox();
		JavascriptExecutor jte = (JavascriptExecutor)driver; 
		jte.executeScript("window.scrollBy(0,-200)");
		returnPOM.clickdeleteBtn();

		// Alert after return delete
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		WebElement alert1 =driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		String s1=alert1.getText();
		String expMsg1 = "Success: You have modified returns!";
		assertTrue(expMsg1.equals(s1));
		System.out.println("The alert message after delete return is : "+s1);

		if (s.contains("Success: You have modified returns!"))
		{
			System.out.println("Return deleted");
		}
		screenShot.captureScreenShot("RTTC_082_Return deleted"+s3);
		Thread.sleep(2000);
		returnPOM.clicklogoutBtn();




	}

	private void assertTrue(boolean equals) {
		// TODO Auto-generated method stub

	}
}


