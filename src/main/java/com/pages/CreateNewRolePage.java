package com.pages;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SetUp.BaseTest;

public class CreateNewRolePage extends BaseTest {

	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	public WebDriver driver;

	public CreateNewRolePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='logged-person-content']")
	private WebElement homepageIconName;

	@FindBy(xpath = "//*[@id='mat-select-76']")
	private WebElement roleType;
	@FindBy(xpath = "//*[@id='mat-select-84']")
	private WebElement transfrableList;

	@FindBy(xpath = "//*[@id='mat-input-194']")
	private WebElement roleName;
	@FindBy(xpath = "//*[@id='mat-input-195']")
	private WebElement roleDiscription;
	@FindBy(xpath = "//*[@id='mat-select-85']")
	private WebElement defaultWalletTypeId;
	
	@FindBy(xpath = "//input[@id='mat-checkbox-21-input']")
	private WebElement autoActiveCheckBox;
	

	@FindBy(xpath = "//input[@id='mat-checkbox-24-input']")
	private WebElement forbidOviousCheckbox;
	
	//input[@id='mat-checkbox-24-input']

	//button[@class='mat-fab mat-accent']
	public void enterPassword(String Password) {
		log.info("Enter password");
//		password.sendKeys(Password);

	}
	public void DefaultWalletTypeId() {
		log.info("Select Default Wallet TypeId from dropdown");
		defaultWalletTypeId.click();
	}
	public void selectRoleType() {
		log.info("Select Role Type from dropdown");
		roleType.click();
	}
	
	public void TransfrableList() {
		log.info("Select transfrableList from dropdown");
		transfrableList.click();
	}
	
	public void AutoActiveCheckBox() {
		log.info("Select Auto Active CheckBox");
		Boolean aV=autoActiveCheckBox.isSelected();
		System.out.print("Auto Check box is :"+ aV );
		if(aV.equals("True"))
		{
			autoActiveCheckBox.click();
			}

	}
	
	public void ForbidOviousCheckbox() {
		log.info("Select forbid Ovious Checkbox CheckBox");
		Boolean aV=forbidOviousCheckbox.isSelected();
		System.out.print("forbid Ovious Checkbox is :"+ aV );
		if(aV.equals("True"))
		{
			forbidOviousCheckbox.click();
			}

	}
	public void enterRoleName(String RoleName) {
		log.info("Enter RoleName");
		roleName.sendKeys(RoleName);
	}

	public void enterRoleDiscriptions(String RoleDiscription) {
		log.info("Enter Role Discription");
		roleDiscription.sendKeys(RoleDiscription);
	}
/*
	public WebElement createbutton() {
		log.info("Enter password");
		return createbutton;

	}
*/
	public WebElement HomePageIconName() {
		log.info("Home page User Icon name");
		return  homepageIconName;
	}
}