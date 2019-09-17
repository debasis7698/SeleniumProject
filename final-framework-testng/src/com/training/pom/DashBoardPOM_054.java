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

public class DashBoardPOM_054 {
	private WebDriver driver; 

	public DashBoardPOM_054(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//i[@class='fa fa-shopping-cart fw']")
	private WebElement salesIcon;
		
	@FindBy(xpath="//*[@id=\"menu-sale\"]/ul/li[1]/a")
	private WebElement ordersLink;

	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addnewIcon;	
	
	
		public void clicksalesIcon() {
		this.salesIcon.click(); 
	}
	public void clickordersLink() {
		this.ordersLink.click(); 
	}
	
	public void clickaddnewIcon() {
		this.addnewIcon.click(); 
	}
	
	
	
	
	}
