package TestScanario.AutomationPractic;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.SetUp.BaseTest;

import com.pages.HomePage;
import com.pages.ManagePage;
import com.pages.PaylaterLogin;

public class UserManagementTest extends BaseTest {
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());

	PaylaterLogin login;
	HomePage hp;
	WebDriverWait wait;
	ManagePage mp;

	@BeforeMethod
	public void setUP() throws InterruptedException, FileNotFoundException, IOException {
		log.info("launchBrowser");
		launchBrowser();
		hp = new HomePage(driver);
		log.info("User login the application with valid username and password");
		hp.enterUserName().sendKeys("nikhil");
		hp.enterPassword().sendKeys("nikhil@8");
		hp.loginButton().click();
	}

	@Test(priority = 1)
	public void depositManagementTest() {
		log.info("Validate the deposit Management Tab");
		hp.ManageTab().click();
		mp= new ManagePage(driver);
		mp.depositManagementModule().isDisplayed();
		mp.depositManagementModule().click();

	}

	@Test(priority = 2)
	public void loginTest() {
		log.info("Enter User Positive Value");
		hp.enterUserName().sendKeys("ayush");
		hp.enterPassword().sendKeys("kushal@123");
		hp.loginButton().click();

	}

	@Test(priority = 3)
	public void loginTestWithInvalidUserName() {
		log.info("Enter User Negative Value");
		hp.enterUserName().sendKeys("ayush");
		hp.enterPassword().sendKeys("kushal@123");
		hp.loginButton().click();
		hp.WarningPopUpMessage().isDisplayed();

	}

	@Test(priority = 4)
	public void loginTestWithInvalidPassword() {
		log.info("Enter User Negative password Value");
		hp.enterUserName().sendKeys("ayush");
		hp.enterPassword().sendKeys("kushal@12");
		hp.loginButton().click();
		hp.InvalidPasswordWarningMessage().isDisplayed();

	}


/*
 * @Test public void genericHeaderXpath() throws Exception {
 * log.info("Generic Header Xpath Positive test"); List<WebElement> allAttribute
 * = new ArrayList<WebElement>(); // List<String> allAttributeValue = new
 * ArrayList<String>(); allAttribute = hp.HomePageHeader(); for (WebElement el :
 * allAttribute) { // allAttributeValue.add(el.getText().trim()); if
 * (el.getText().equalsIgnoreCase("Travel")) { el.click();
 * 
 * } } }
 * 
 * @Test public void ValidateHomePageOffer() throws Exception {
 * log.info("Generic Validate Home Page Offer Positive test"); List<WebElement>
 * allAttribute = new ArrayList<WebElement>(); allAttribute =
 * hp.OfferOnHomePage(); for (WebElement el : allAttribute) { if
 * (el.getText().equalsIgnoreCase("Fashion For Everyone")) { el.isDisplayed(); }
 * } }
 * 
 * @Test public void validateByAddProductToCart() {
 * 
 * log.info("Validating By Add Product To Cart Positive test");
 * JavascriptExecutor js = (JavascriptExecutor) driver;
 * js.executeScript("window.scrollBy(0,1000)"); WebElement min=hp.Mi55off();
 * js.executeScript("arguments[0],scrollIntoView(true)",min);
 * //((JavascriptExecutor)driver).executeScript(
 * "arguments[0].scrollIntoView();", hp.Mi55off()); wait = new
 * WebDriverWait(driver,5);
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "hp.Min55off()"))); hp.Min55off();
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "hp.Min55offProduct()")));
 * 
 * hp.Min55offProduct();
 * 
 * 
 * 
 * }
 *
 
 @AfterMethod public void tearDown() {
 System.out.println("I am clossing Browser "); 
 driver.quit(); }
 
 }
 */
}