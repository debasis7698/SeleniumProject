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

public class DashBoardPOM_021 {
	private WebDriver driver; 

	public DashBoardPOM_021(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//html/body/div[1]/nav/ul/li[7]/a")
	private WebElement customerIcon;
		
	@FindBy(xpath="//html/body/div[1]/nav/ul/li[7]/ul/li[1]/a")
	private WebElement customerLink;
	
	
	//FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div/table/tbody/tr[1]/td[1]/input")
	//@FindBy(xpath="/html/body/div[1]/div/div[2]/div/div[2]/form/div/table/tbody/tr[1]/td[1]")
	
	//private WebElement checkbox;
	
	//@FindBy(xpath="/html/body/div[1]/div/div[1]/div/div/button")
	//private WebElement deleteicon;
		
	public void clickcustomerIcon() {
		this.customerIcon.click(); 
	}
	public void clickcustomerLink() {
		this.customerLink.click(); 
	}
	//public void clickdeleteicon() {
	//this.deleteicon.click(); 
	//}
	
	
		}
	


