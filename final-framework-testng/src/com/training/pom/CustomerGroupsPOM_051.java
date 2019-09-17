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

public class CustomerGroupsPOM_051 {
	private WebDriver driver; 

	public CustomerGroupsPOM_051(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Customer Group Name']")
	private WebElement custgrnameText;
		
	@FindBy(xpath="//textarea[@id='input-description1']")
	private WebElement desc;
	
	
	@FindBy(xpath= "//div[@class='col-sm-10']//label[1]")
	private WebElement radiobtnYes;			
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement saveBtn;
	

		
	public void sendcustgrnameText(String custgrnameText) {
		this.custgrnameText.clear(); 
		this.custgrnameText.sendKeys(custgrnameText); 
	}
	
	public void senddesc(String desc) {
		this.desc.clear(); 
		this.desc.sendKeys(desc);
	}
		
	public void clickradiobtnYes() {
		this.radiobtnYes.click();
	}
	
		
		public void clicksaveBtn() {
			this.saveBtn.click(); 	
		
		
						
		}
}

	



