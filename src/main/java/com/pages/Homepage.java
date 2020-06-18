package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class Homepage extends BaseTest {

	public WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@id='SearchBarPlaceHolder']")
	WebElement search;

	@FindBy(xpath = "//label[text()='Property Type']/..//img")
	WebElement propertyany;

	@FindBy(xpath = "(//span[@class='p24_blueCheckbox'])[1]")
	WebElement house;

	@FindBy(xpath = "(//span[@class='p24_blueCheckbox'])[3]")
	WebElement townhouse;

	@FindBy(xpath = "//span[text()='Min Price']/..//img")
	WebElement minpriceany;

	@FindBy(xpath = "(//span[contains(text(),\"R 100\")])[1]")
	WebElement minprice;

	@FindBy(xpath = "//span[text()='Max Price']/..//img")
	WebElement maxpriceany;

	@FindBy(xpath = "(//div[@id=\"PriceTo\"]//ul//li)[3]")
	WebElement maxprice;

	@FindBy(xpath = "//label[text()='Bedrooms']/..//img[1]")
	WebElement bedroomany;

	@FindBy(xpath = "(//span[contains(text(),\"2+\")])[1]")
	WebElement bedroomnumbers;
    
	@FindBy(xpath= "//h1[text()='Find Property for Sale']")
	WebElement findpropertyforsale;
	
    @FindBy(xpath= "//button[@id='SearchBarHomeSubmit']")
	WebElement searchbutton;
    
    @FindBy(xpath= "//span[@class='js_text']")
    WebElement morefilter;
    

    @FindBy(xpath= "//label[text()='Bathrooms']/..//img[1]")
    WebElement bathrooms;
    
    @FindBy(xpath= "(//div[@id=\"Baths\"]//ul//li)[2]")
    WebElement bathroomnumbers;
	

    @FindBy(xpath= "//label[text()=\"Parking / Garage\"]/..//img[@alt='Parking / Garage']")
    WebElement parkinggarage;
    

    @FindBy(xpath= " //div[@id='ParkingSpaces']//button")
    WebElement cparkingspace;
    

    @FindBy(xpath= "(//div[@id='ParkingSpaces']//ul//li)[3]")
    WebElement sparkingspace;
  

    @FindBy(xpath= "//div[@id='GarageOnly']//button")
    WebElement parkingtype;
    

    @FindBy(xpath= "(//div[@id='GarageOnly']//ul/li)[3]")
    WebElement parkingtypegarage;
    
    @FindBy(xpath= "//input[@id='IsPetFriendly']/../..")
    WebElement ispetfriendly;
    

    @FindBy(xpath= "//input[@id='HasFlatlet']/../..")
    WebElement hasflatet;
    
	public WebElement searchtheproperty() {
		return search;
	}

	public WebElement selectpropertytypes() {
		return propertyany;
	}

	public WebElement selecthouse() {
		return house;
	}

	public WebElement selecttownhouse() {
		return townhouse;
	}

	public WebElement clickminpriceany() {
		return minpriceany;
	}

	public WebElement selectminprice() {
		return minprice;
	}

	public WebElement clickmaxpriceany() {
		return maxpriceany;
	}

	public WebElement selectmaxprice() {
		return maxprice;
	}
	public WebElement clickbedrromany() {
		return bedroomany;
	}
	public WebElement selectbedrooms() {
		return bedroomnumbers;

	}
	public WebElement clickfindpropertyforsale() {
		return findpropertyforsale;
	}
	public WebElement clickonsearchbutton() {
		return searchbutton ;
	}
	public WebElement clickonmorefilterbutton() {
		return morefilter ;
	}

	public WebElement clickonbathrooms() {
		return bathrooms ;
		
}

	public WebElement selectonbathrooms() {
		return bathroomnumbers ;
}

	public WebElement clickonparkinggarage() {
		return parkinggarage ;
	}

	public WebElement clickonparkingspacebutton() {
		return cparkingspace;
	}
	public WebElement selectparkingspacecount() {
		return sparkingspace;
	}

	public WebElement clickonparkingtype() {
		return parkingtype;
	}
	public WebElement selectparkingtypegarage() {
		return parkingtypegarage;
	}
	public WebElement selectispetfriendly() {
		return ispetfriendly;
	}
	public WebElement selecthesflatlet() {
		return hasflatet;
	}
}