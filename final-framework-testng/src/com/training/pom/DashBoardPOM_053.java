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

public class DashBoardPOM_053 {
	private WebDriver driver; 

	public DashBoardPOM_053(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//i[@class='fa fa-shopping-cart fw']")
	private WebElement orderIcon;
		
	//@FindBy(xpath="//li[@class='active open']//a[contains(text(),'Orders')]") ///
	@FindBy(xpath="//html/body/div[1]/nav/ul/li[6]/ul/li[1]/a")
	
	private WebElement orderLink;
	
	
		public void clickorderIcon() {
		this.orderIcon.click(); 
	}
	
		public void clickorderLink() {
			this.orderLink.click(); 
		}
	
	
	
	
	}

