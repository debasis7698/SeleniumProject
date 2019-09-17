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

public class DashBoardPOM_055 {
	private WebDriver driver; 

	public DashBoardPOM_055(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement catalogIcon;
		
	@FindBy(xpath="//a[contains(text(),'Manufacturers')]")
	private WebElement manufLink;
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addnewIcon;
	
	@FindBy(xpath="//input[@id='input-name']")
	private WebElement mannameTxt;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement saveIcon;
	
	@FindBy(xpath="//li[@class='active open']//a[contains(text(),'Products')]")
	private WebElement productLink;
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addnewprdIcon;
	
	
	
	
	
	//button[@class='btn btn-primary']
	
	//input[@id='input-name']
		public void clickcatalogIcon() {
		this.catalogIcon.click(); 
	}
	
		public void clickmanufLink() {
			this.manufLink.click(); 
		}
	
		public void clickaddnewIcon() {
			this.addnewIcon.click(); 
		}
		
		public void sendmanname(String mannameTxt) {
			this.mannameTxt.clear(); 
			this.mannameTxt.sendKeys(mannameTxt); 
		}
		
		public void clicksaveIcon() {
			this.saveIcon.click(); 
		}
	
		public void clickproductLink() {
			this.productLink.click(); 
		}
		
		public void clickaddnewprdIcon() {
			this.addnewprdIcon.click(); 
		}
		
		
		
	}

