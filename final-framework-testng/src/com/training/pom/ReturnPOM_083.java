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

public class ReturnPOM_083 {
	private WebDriver driver; 

	public ReturnPOM_083(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-order-id']")
	private WebElement orderidtext;
	
	@FindBy(xpath="//input[@id='input-customer']")
	private WebElement customertext;
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstnametext;		
			
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastnametext;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailtext;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephonetext;
	
		
	@FindBy(xpath="//input[@id='input-product']")
	private WebElement producttext;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement modeltext;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//tbody//tr[1]//td[1]//input[1]")
	private WebElement checkbox;
	
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	private WebElement deleteBtn;
	
	
	@FindBy(xpath="//span[@class='hidden-xs hidden-sm hidden-md']")
	private WebElement logoutBtn;
	
	
	
	
	public void sendeorderidtext(String orderidtext) {
		this.orderidtext.clear(); 
		this.orderidtext.sendKeys(orderidtext); 
	}

	public void sendcustomertext(String customertext) {
		this.customertext.clear(); 
		this.customertext.sendKeys(customertext); 
	}
	
	
		public void sendfirstnametext(String firstnametext) {
			this.firstnametext.clear(); 
			this.firstnametext.sendKeys(firstnametext); 
		}
		
		
		public void sendlastnametext(String lastnametext) {
			this.lastnametext.clear(); 
			this.lastnametext.sendKeys(lastnametext); 
		}
		
		public void sendemailnametext(String emailtext) {
			this.emailtext.clear(); 
			this.emailtext.sendKeys(emailtext); 
		}
		
		public void sendetelephonetext(String telephonetext) {
			this.telephonetext.clear(); 
			this.telephonetext.sendKeys(telephonetext); 
		}

		public void sendeproducttext(String producttext) {
			this.producttext.clear(); 
			this.producttext.sendKeys(producttext); 
		}

		public void sendemodeltext(String modeltext) {
			this.modeltext.clear(); 
			this.modeltext.sendKeys(modeltext); 
		}

		public void clicksaveBtn() {
			this.saveBtn.click(); 
		}
		
		public void clickcheckbox() {
			this.checkbox.click(); 
		}
		
		public void clickdeleteBtn() {
			this.deleteBtn.click(); 
		}
		
		public void clicklogoutBtn() {
			this.logoutBtn.click(); 
		}
		
		
		
}




