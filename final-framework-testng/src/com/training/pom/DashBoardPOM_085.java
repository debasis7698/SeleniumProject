package com.training.pom;

//import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DashBoardPOM_085 {
	private WebDriver driver; 

	public DashBoardPOM_085(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//i[@class='fa fa-shopping-cart fw']")
	private WebElement salesIcon;
	
	//@FindBy(xpath="//li[@class='active open']//a[contains(text(),'Orders')]")
	@FindBy(xpath="/html/body/div[1]/nav/ul/li[6]/ul/li[1]/a")
	
	//*[@id="menu-sale"]/ul/li[1]/a
	// /html/body/div[1]/nav/ul/li[6]/ul/li[1]/a
	private WebElement ordersLink;
	
	@FindBy(xpath="//input[@id='input-order-id']")
	//@FindBy(id="input-order-id")
	//@FindBy(xpath="//*[@id=\"input-order-id\"]")
	//*[@id="input-order-id"]
	
	//*[@id="input-order-id"]
	private WebElement orderidText;
	
	@FindBy(xpath="//select[@id='input-order-status']")
	private WebElement orderstatus;
	
	@FindBy(xpath="//input[@id='input-date-added']")
	private WebElement dateadded;
	
	@FindBy(xpath="//input[@id='input-customer']")
	private WebElement custtext;
	
	@FindBy(xpath="//input[@id='input-total']")
	private WebElement totaltext;
	
	@FindBy(xpath="//input[@id='input-date-modified']")
	private WebElement datemodified;
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filterBtn;
	
	
	
	
	//span[@class='hidden-xs hidden-sm hidden-md']
	//button[@id='button-filter']
	//input[@id='input-total']
	//input[@id='input-date-modified']
	//span[@class='hidden-xs hidden-sm hidden-md']
	
	@FindBy(xpath="//span[@class='hidden-xs hidden-sm hidden-md']")
	private WebElement logoutBtn;
	
		public void clicksalesIcon() {
		this.salesIcon.click(); 
	}
		
			
		public void clickordersLink() {
			this.ordersLink.click(); 
		}
		
		public void sendorderidText(String orderidText) {
			this.orderidText.clear(); 
			this.orderidText.sendKeys(orderidText); 
		}
		
		public void sendorderstatus(String orderstatus) {
			//this.orderstatus.clear(); 
			this.orderstatus.sendKeys(orderstatus); 
		}
		
		public void senddateadded(String dateadded) {
			this.dateadded.clear(); 
			this.dateadded.sendKeys(dateadded); 
		}
		
		public void sendcusttext(String custtext) {
			this.custtext.clear(); 
			this.custtext.sendKeys(custtext); 
		}
		
		public void sendtotaltext(String totaltext) {
			this.totaltext.clear(); 
			this.totaltext.sendKeys(totaltext); 
		}
		public void senddatemodified(String datemodified) {
			this.datemodified.clear(); 
			this.datemodified.sendKeys(datemodified); 
		}
		
		public void clickfilterBtn() {
			this.filterBtn.click(); 
		}
		
		public void clicklogoutBtn() {
			this.logoutBtn.click(); 
		}


		
		
	}



