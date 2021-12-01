package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SetUp.BaseTest;

public class HomePage extends BaseTest {

	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='logged-person-content']")
	private WebElement homepageIconName;

	@FindBy(xpath = "//div[@class='home-menu-column ng-star-inserted'][2]")
	private WebElement manageTab;

	@FindBy(xpath = "//div[@class='sub-menu-column ng-star-inserted'][2].")
	private WebElement userTab;
	@FindBy(xpath = "//button[@class='mat-fab mat-accent']")
	private WebElement createbutton;

	//button[@class='mat-fab mat-accent']
	public void enterPassword(String Password) {
		log.info("Enter password");
//		password.sendKeys(Password);

	}

	public void clickManageTab() {
		log.info("clicking on Manage Tab");
		manageTab.click();
	}
	public void userTab() {
		log.info("clicking on User Tab");
		userTab.click();
	}



	public WebElement createbutton() {
		log.info("Enter password");
		return createbutton;

	}

	public WebElement HomePageIconName() {
		log.info("Home page User Icon name");
		return  homepageIconName;
	}
	public WebElement ManageTab() {
		log.info("ManageTab");
		return  manageTab;
	}
}