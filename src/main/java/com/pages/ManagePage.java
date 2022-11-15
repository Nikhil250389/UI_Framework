package com.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SetUp.BaseTest;

public class ManagePage extends BaseTest {

	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	public WebDriver driver;

	public ManagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[contains(text(),'Deposit Management')]")
	private WebElement depositManagementModule;

	@FindBy(xpath = "//div[@class='home-menu-column ng-star-inserted']")
	private List<WebElement> homePageAllModule;

	@FindBy(xpath = "//div[contains(text(),'Manage')]")
	private WebElement manageTab;

	
	
	
	


	public WebElement depositManagementModule() {
		log.info("Click On User Management module");
		return depositManagementModule;

	}

	
	
}