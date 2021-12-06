package TestScanario.AutomationPractic;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SetUp.BaseTest;
import com.Utilities.ResuableMethods;
import com.Utilities.Utilities;
import com.pages.PaylaterLogin;
import com.pages.NewPagesRepository.HomePage;

public class TestLogin extends BaseTest {
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());

	PaylaterLogin login;
	HomePage hp;
	WebDriverWait wait ;
	@BeforeMethod
	public void setUP() throws InterruptedException, FileNotFoundException, IOException {
		log.info("launchBrowser");
		launchBrowser();
		hp = new HomePage(driver);
		hp.WelcomeButton();
	}

	@Test
	public void genericHeaderXpath() throws Exception {
		log.info("Generic Header Xpath Positive test");
		List<WebElement> allAttribute = new ArrayList<WebElement>();
		// List<String> allAttributeValue = new ArrayList<String>();
		allAttribute = hp.HomePageHeader();
		for (WebElement el : allAttribute) {
			// allAttributeValue.add(el.getText().trim());
			if (el.getText().equalsIgnoreCase("Travel")) {
				el.click();

			}
		}
	}

	@Test
	public void ValidateHomePageOffer() throws Exception {
		log.info("Generic Validate Home Page Offer Positive test");
		List<WebElement> allAttribute = new ArrayList<WebElement>();
        allAttribute = hp.OfferOnHomePage();
		for (WebElement el : allAttribute) {
			if (el.getText().equalsIgnoreCase("Fashion For Everyone")) {
				el.isDisplayed();
			}
		}
	}
	
	@Test
	public void validateByAddProductToCart()
	{
		
		log.info("Validating By Add Product To Cart Positive test");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	WebElement min=hp.Mi55off();
	js.executeScript("arguments[0],scrollIntoView(true)",min);
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", hp.Mi55off());
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("hp.Min55off()")));
		hp.Min55off();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("hp.Min55offProduct()")));
		
		hp.Min55offProduct();
		
		
		
	}
/*
	@AfterMethod
	public void tearDown() {
		System.out.println("I am clossing Browser ");
		driver.quit();
	}
*/
}