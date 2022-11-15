package com.pages;

import java.util.List;

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

	@FindBy(xpath = "//div[@class='logo']")
	private WebElement homepageLogo;

	@FindBy(xpath = "//input[@id='mat-input-0']")
	private WebElement userName;

	@FindBy(xpath = "//input[@id='mat-input-1']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@class='mat-raised-button mat-accent']")
	private WebElement loginNowButton;

	@FindBy(xpath = "//*[contains(text(),'Invalid Crediantials')]")
	private WebElement warningPopUpMessage;

	@FindBy(xpath = "//*[contains(text(),'Invalid Crediantials')]")
	private WebElement invalidPasswordWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'Ayush')]")
	private WebElement homePageLogo;
	

	@FindBy(xpath = "//div[@class='home-menu-column ng-star-inserted']")
	private List<WebElement> homePageAllModule;

	@FindBy(xpath = "//div[contains(text(),'Manage')]")
	private WebElement manageTab;

	
	
	
	//div[@class='home-menu-column ng-star-inserted']
	
	public void enterPassword(String Password) {
		log.info("Enter password");
//		password.sendKeys(Password);

	}
/*
	public void clickManageTab() {
		log.info("clicking on Manage Tab");
		manageTab.click();
	}
	
	public void userTab() {
		log.info("clicking on User Tab");
		userTab.click();
	}
*/

	public WebElement ManageTab() {
		log.info("Click on Manage Tab");
		return manageTab;

	}
	public WebElement loginButton() {
		log.info("Click on Login Now Button");
		return loginNowButton;

	}

	public WebElement HomePageLogo() {
		log.info("Home page User logo name");
		return  homepageLogo;
	}
	
	public WebElement LogoHomePage() {
		log.info("Home page logo name");
		return  homePageLogo;
	}
	public WebElement enterUserName() {
		log.info("Enter user Name");
		return  userName;
	}
	public WebElement enterPassword() {
		log.info("Enter user password");
		return  password;
	}
	public WebElement WarningPopUpMessage() {
		log.info("Warning PopUp Message");
		return  warningPopUpMessage;
	}
	public WebElement InvalidPasswordWarningMessage() {
		log.info("invalid password Warning PopUp Message");
		return  invalidPasswordWarningMessage;
	}
	
	public List<WebElement> HomePageAllModuleList() {
		log.info("Fatching Home Page All Module list");
		return  homePageAllModule;
	}
	
}