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

public class AddCustomerPOM_051 {
	private WebDriver driver; 

	public AddCustomerPOM_051(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-firstname")
	private WebElement firstName;
		
	@FindBy(id="input-lastname")
	private WebElement lastName;

	@FindBy(id="input-email")
	private WebElement email;	
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirm;
	
	//@FindBy(xpath="//html/body/div/div/div[2]/div/div[2]/form/div/div[1]/div/div[1]/ul/li[2]/a/i")
	@FindBy(xpath="//i[@class='fa fa-plus-circle']")
	private WebElement addAddress;
	
	@FindBy(id="input-firstname1")
	private WebElement firstName1;
		
	@FindBy(id="input-lastname1")
	private WebElement lastName1;
	
	
	@FindBy(id="input-address-11")
	private WebElement address1;
	
	@FindBy(id="input-address-21")
	private WebElement address2;
	
	@FindBy(id="input-city1")
	private WebElement city;
	
	@FindBy(id="input-postcode1")
	private WebElement postcode;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
		private WebElement saveBtn;
	
	
	
	public void sendfirstName(String firstName) {
		this.firstName.clear(); 
		this.firstName.sendKeys(firstName); 
	}
	
	public void sendlastName(String lastName) {
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
	public void sendpassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password);
	}
	
	public void sendconfirm(String confirm) {
		this.confirm.clear(); 
		this.confirm.sendKeys(confirm);
	}
	
	public void clickaddAddress() {
		this.addAddress.click(); 
	}
	
	public void sendfirstName1(String firstName1) {
		this.firstName1.clear(); 
		this.firstName1.sendKeys(firstName1); 
	}
	
	public void sendlastName1(String lastName1) {
		this.lastName1.clear(); 
		this.lastName1.sendKeys(lastName1); 
	}
	
	
	
	
	
	public void sendaddress1(String address1) {
		this.address1.clear(); 
		this.address1.sendKeys(address1);
	}
	
	public void sendaddress2(String address2) {
		this.address2.clear(); 
		this.address2.sendKeys(address2);
	}
	
	public void sendcity(String city) {
		this.city.clear(); 
		this.city.sendKeys(city);
	}
	
	public void sendpostcode(String postcode) {
		this.postcode.clear(); 
		this.postcode.sendKeys(postcode);
	}
	
	public void clicksaveBtn() {
		this.saveBtn.click(); 
	}
	
	
	
	
	
}

	


