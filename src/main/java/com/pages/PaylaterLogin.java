package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SetUp.BaseTest;

public class PaylaterLogin extends BaseTest {


	public WebDriver driver;

	public PaylaterLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='mat-form-field-infix']//input[@id='mat-input-0']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='mat-input-1']")
	WebElement password;

	@FindBy(xpath = "//button[@class='mat-raised-button mat-accent']")
	WebElement loginNowButton;

	public void enterPassword(String Password) {
		// log.info("Enter password");
		password.sendKeys(Password);
		
	}
	

	public void clickLoginButton() {
		// log.info("clicing on create new bank button");
		loginNowButton.click();
	}

	public void setUserName(String name) {
		// log.info("setting userName...");

		userName.sendKeys(name);
	}


public WebElement Password() {
	// log.info("Enter password");
	return password;
	
}

public WebElement UserName() {
	// log.info("Enter password");
	return userName;
	}}