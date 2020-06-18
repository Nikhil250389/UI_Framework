package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class SearchResult extends BaseTest {

	public WebDriver driver;

	public SearchResult(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//i[@class=\"fa fa-caret-down\"]")
	WebElement orderby;

	@FindBy(xpath = "//div[@class=\"btn-group open\"]//ul/li/a[text()=\"Most recent\"]")
	WebElement mostrecent;
	
	public WebElement clickonorderby() {
		return orderby;
	}

	public WebElement selectmostrecent() {
		return mostrecent;
	}

}
