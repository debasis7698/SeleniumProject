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

public class AddCustomerPOM_052 {
	private WebDriver driver; 

	public AddCustomerPOM_052(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-firstname")
	private WebElement firstName;
		
	
	
	@FindBy(xpath="//a[contains(text(),'Address 1')]")
	private WebElement addAddress1;
	
	
	@FindBy(id="input-postcode1")
	private WebElement postcode;
	
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Reward Points')]")
	private WebElement rewardpoint;
	
	@FindBy(xpath="//input[@id='input-reward-description']")
	private WebElement desc;
	
	@FindBy(xpath="//input[@id='input-points']")
	private WebElement points;
	
	@FindBy(xpath="//button[@id='button-reward']")
	private WebElement addrewardptsBtn;
	
	@FindBy(xpath="//div[@class='pull-right']//button[@class='btn btn-primary']")
	private WebElement saveBtn;
	
	
	
	public void sendfirstName(String firstName) {
		this.firstName.clear(); 
		this.firstName.sendKeys(firstName); 
	}
	
			
	public void clickaddAddress1() {
		this.addAddress1.click(); 
	}
	
	
	
	
	public void sendpostcode(String postcode) {
		this.postcode.clear(); 
		this.postcode.sendKeys(postcode);
	}
	
		
	public void clickrewardpoint() {
		this.rewardpoint.click(); 
		
	}
	
	public void senddesc(String desc) {
		this.desc.clear(); 
		this.desc.sendKeys(desc); 
	}
	
	public void sendpoints(String points) {
		this.points.clear(); 
		this.points.sendKeys(points); 
	}
	public void clickaddrewardptsBtn() {
		this.addrewardptsBtn.click(); 
	}
	
	public void clicksaveBtn() {
	this.saveBtn.click(); 
	}
	
	
	
}

	



