package com.pages.NewPagesRepository;

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

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	private WebElement welcomeButton;

	@FindBy(xpath = "//div[@class='eFQ30H']")
	private List<WebElement> homePageHeader;

	@FindBy(xpath = "//div[@class='_2N81D7']")
	private List<WebElement> offerOnHomePage;
	
	@FindBy(xpath = "//div[contains(text(),'Min 55% Off')]")
	private WebElement min55off;

	@FindBy(xpath = "//a[contains(text(),'Full Sleeve Printed Men Sports Jacket')][1]")
	private WebElement min55offProduct;

	
	
	//a[contains(text(),'Full Sleeve Printed Men Sports Jacket')][1]
	
	
	
	
	public void enterPassword(String Password) {
		log.info("Enter password");
//		password.sendKeys(Password);

	}
/*
	public void clickManageTab() {
		log.info("clicking on Manage Tab");
		manageTab.click();
	}
	*/
	public void WelcomeButton() {
		log.info("clicking on the Welcome Button");
		welcomeButton.click();
	}


	public void Min55off() {
		log.info("clicking on the Min 55 % off");
		min55off.click();
	}

	public void Min55offProduct() {
		log.info("clicking on the Min 55 % off Product");
		min55offProduct.click();
	}


	public  WebElement Mi55off() {
		log.info("min55off displayed");
		return  min55off;
	}


	
	public List<WebElement> HomePageHeader() {
		log.info("HomePageHeader displayed");
		return  homePageHeader;
	}
	public List<WebElement> OfferOnHomePage() {
		log.info("HomePageHeader displayed");
		return  offerOnHomePage;
	}
	
	
}