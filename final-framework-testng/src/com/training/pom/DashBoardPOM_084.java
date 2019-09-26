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

public class DashBoardPOM_084 {
	private WebDriver driver; 

	public DashBoardPOM_084(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//i[@class='fa fa-tags fw']")
	private WebElement catalogIcon;
	
		
	//@FindBy(xpath="//li[@class='active open']//a[contains(text(),'Products')]")
	@FindBy(xpath="//html/body/div[1]/nav/ul/li[3]/ul/li[2]/a")
	
	//*[@id="menu-catalog"]/ul/li[2]/a
	// /html/body/div[1]/nav/ul/li[3]/ul/li[2]/a
	
	private WebElement productLink;
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addnewprdIcon;
	
	
	
	
		public void clickcatalogIcon() {
		this.catalogIcon.click(); 
	}
	
		
		public void clickproductLink() {
			this.productLink.click(); 
		}
		
		public void clickaddnewprdIcon() {
			this.addnewprdIcon.click(); 
		}
		
		
		
	}


