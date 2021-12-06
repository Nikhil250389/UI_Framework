package com.pages.NewPagesRepository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SetUp.BaseTest;

public class MyntraMenHome extends BaseTest {

	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	public WebDriver driver;

	public MyntraMenHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class=' column-base']")
	private List<WebElement> bestDealOnTopBrand;

	@FindBy(xpath = "//h4[contains(text(),'Biggest Deals On Top Brands')]")
	private WebElement biggestDealBrand;

	@FindBy(xpath = "//div[@class='container-base myx-stretch    ']")
	private List<WebElement> menHomePageProducts;
	
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


	
	public WebElement  BiggestDealBrand() {
		log.info("Biggest Deal Brand Headers on Men Page");
		return  biggestDealBrand;
	}
	public List<WebElement> MenBestDealOnTopBrand() {
		log.info("Total Men best Deal On Top Brand product");
		return  menHomePageProducts;
	}
	
	
}