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

public class DashBoardPOM_051 {
	private WebDriver driver; 

	public DashBoardPOM_051(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//html/body/div[1]/nav/ul/li[7]/a")
	private WebElement customerIcon;
		
	@FindBy(xpath="//a[contains(text(),'Customer Groups')]")
	private WebElement customergroupLink;
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addnewIcon;
	
	@FindBy(xpath="//html/body/div[1]/nav/ul/li[7]/ul/li[1]/a")
	private WebElement customerLink;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a/i")
	private WebElement addnewBtn;
	
		
	public void clickcustomerIcon() {
		this.customerIcon.click(); 
	}
	
	public void clickcustomergroupLink() {
		this.customergroupLink.click();
	}
	
		public void clickaddNewIcon() {
			this.addnewIcon.click(); 
		}
		
		public void clickcustomerLink() {
			this.customerLink.click(); 
		}
		
		public void clickaddnewBtn() {
			this.addnewBtn.click(); 
		}
		
		
		
				
		}

	



