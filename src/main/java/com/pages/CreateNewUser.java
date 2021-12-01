package com.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SetUp.BaseTest;

public class CreateNewUser extends BaseTest {

	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	public WebDriver driver;

	public CreateNewUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='mat-form-field-wrapper'][1]")
	private List<WebElement> roleType;

	@FindBy(xpath = "//div[@class='home-menu-column ng-star-inserted'][2]")
	private WebElement manageTab;

	@FindBy(xpath = "//div[@class='sub-menu-column ng-star-inserted'][2]")
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

	public List<WebElement> selectRoleType() {
		log.info("Select role type");
		return  roleType;
	}
}