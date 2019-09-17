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

public class AddOrderPOM_054 {
	private WebDriver driver; 

	public AddOrderPOM_054(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="firstname")
	private WebElement firstName; 
	
	@FindBy(name="lastname")
	private WebElement lastName;	
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="telephone")
	private WebElement telephone;
	
	@FindBy(id="button-customer")
	private WebElement continueBtn;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement quantity;
	
	@FindBy(xpath="//button[@id='button-product-add']")
	private WebElement addprdtBtn;
	
	
	//button[@id='button-product-add']
	
	
	public void sendFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}
	
	public void sendLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	
	}
	
	public void sendemail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	
	}
	public void sendtelephone(String telephone) {
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
		
}
	
	public void clickcontinueBtn() {
		this.continueBtn.click(); 
	}
	
	public void sendquantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
		
}
	public void clickaddprdtBtn() {
		this.addprdtBtn.click(); 
	}
	
	
	
	
	
}

