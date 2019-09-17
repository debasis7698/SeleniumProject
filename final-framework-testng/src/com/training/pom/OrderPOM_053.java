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

public class OrderPOM_053 {
	private WebDriver driver; 

	public OrderPOM_053(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//tr[14]//td[8]//a[1]//i[1]")
	private WebElement viewIcon;
		
	@FindBy(xpath="//button[@id='button-invoice']//i[@class='fa fa-cog']")
	private WebElement generateIcon;
	
	@FindBy(xpath="//button[@id='button-history']//i[@class='fa fa-plus-circle']")
	private WebElement addhistBtn;
	
	
		public void clickviewIcon() {
		this.viewIcon.click(); 
	}
	
		public void clickgenerateIcon() {
			this.generateIcon.click(); 
		}
	
		public void clickaddhistBtn() {
			this.addhistBtn.click(); 
		}
	
	
	}

