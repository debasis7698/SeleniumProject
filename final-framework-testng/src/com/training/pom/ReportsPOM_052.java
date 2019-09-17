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

public class ReportsPOM_052 {
	private WebDriver driver; 

	public ReportsPOM_052(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//i[@class='fa fa-bar-chart-o fw']")
	private WebElement reportsIcon;
		
	@FindBy(xpath="//a[@class='parent'][contains(text(),'Customers')]")
	private WebElement custLink;
	
	@FindBy(xpath="//a[contains(text(),'Reward Points')]")
	private WebElement rewardpointsLink;
	
	
			
	public void clickreportsIcon() {
		this.reportsIcon.click(); 
	}
	
	public void clickcustLink() {
		this.custLink.click(); 
	}
	
	public void clickrewardpointsLink() {
		this.rewardpointsLink.click(); 
	}
	
	
}

	




