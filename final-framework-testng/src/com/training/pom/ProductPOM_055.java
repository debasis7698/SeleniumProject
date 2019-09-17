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

public class ProductPOM_055 {
	private WebDriver driver; 

	public ProductPOM_055(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement prdtName;
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement metatagtitle;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement datatab;
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement modeltxtBox;
	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement pricetxtBox;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement qtytxtBox;
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement link;
	
	//@FindBy(xpath="//input[@id='input-manufacturer']")
	//private WebElement manufacturerTxt;
	
	//@FindBy(xpath="//input[@id='input-category']")
	//private WebElement categoriesTxt;
	
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Attribute')]")
	private WebElement attributeTab;
	
	
	@FindBy(xpath="//li[@class='active']//a[contains(text(),'Option')]")
	private WebElement optionTab;
	
	
	//@FindBy(xpath="//li[@class='active']//a[contains(text(),'Recurring')]")
	@FindBy(xpath="//html/body/div[1]/div/div[2]/div/div[2]/form/ul/li[6]/a")
	private WebElement recurringTab;
	
	
	
	
	@FindBy(xpath="//a[contains(text(),'Discount')]")
	private WebElement discountTab;
	
	@FindBy(xpath="//a[contains(text(),'Special')]")
	private WebElement specialTab;
	
	@FindBy(xpath="//a[contains(text(),'Image')]")
	private WebElement imageTab;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Reward Points')]")
	private WebElement rewardpointTab;
	
	@FindBy(xpath="//a[contains(text(),'Design')]")
	private WebElement designTab;
	
	
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement saveBtn;
	
	
	public void sendprdtName(String prdtName) {
		this.prdtName.clear(); 
		this.prdtName.sendKeys(prdtName); 
	}
	
	
	public void sendmetatagtitle(String metatagtitle) {
		this.metatagtitle.clear(); 
		this.metatagtitle.sendKeys(metatagtitle); 
	}
	
	public void clickdatatab() {
		this.datatab.click(); 
	}
	
	
	public void sendmodeltxtBox(String modeltxtBox) {
		this.modeltxtBox.clear(); 
		this.modeltxtBox.sendKeys(modeltxtBox); 
	}
		
	public void sendpricetxtBox(String pricetxtBox) {
		this.pricetxtBox.clear(); 
		this.pricetxtBox.sendKeys(pricetxtBox); 
	}
		
	public void sendqtytxtBox(String qtytxtBox) {
		this.qtytxtBox.clear(); 
		this.qtytxtBox.sendKeys(qtytxtBox); 
	}	
		
	public void clicklink() {
		this.link.click(); 
	}	
	//public void sendmanufacturerTxt(String manufacturerTxt) {
		//this.manufacturerTxt.clear(); 
		//this.manufacturerTxt.sendKeys(manufacturerTxt); 
	//}
	
	public void clickattributetab() {
		this.attributeTab.click(); 
	}
	public void clickoptionTab() {
		this.optionTab.click(); 
	}
	
	public void clickrecurringTab() {
		this.recurringTab.click(); 
	}
	
	public void clickdiscountTab() {
		this.discountTab.click(); 
	}
	
	public void clickspecialTab() {
		this.specialTab.click(); 
	}
	public void clickimageTab() {
		this.imageTab.click(); 
	}
	public void clickrewardpointTab() {
		this.rewardpointTab.click(); 
	}
	public void clickdesignTab() {
		this.designTab.click(); 
	}
	
	
	
	public void clicksaveBtn() {
		this.saveBtn.click(); 
		
		
		
		
	}
	
		
	}

