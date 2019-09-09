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

public class DashBoardPOM_024 {
	private WebDriver driver; 

	public DashBoardPOM_024(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//html/body/div[1]/nav/ul/li[10]/a/i")
	private WebElement reportIcon;
		
	@FindBy(xpath="//a[contains(text(),'Sales')]")
	private WebElement salesLink;

	@FindBy(xpath="//a[contains(text(),'Shipping')]")
	private WebElement shippingLink;
	
	@FindBy(id="button-filter")
	private WebElement filterBtn;
	
	
	
		
		public void clickreportIcon() {
		this.reportIcon.click(); 
	}
	public void clicksalesLink() {
		this.salesLink.click(); 
	}
	public void clickshippingLink() {
		this.shippingLink.click(); 
	}
		
		public void clickfilterBtn() {
			this.filterBtn.click(); 
		}
			
	
	}

