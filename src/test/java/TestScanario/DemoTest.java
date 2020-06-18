package TestScanario;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Homepage;
import com.pages.SearchResult;

import Generic.BaseTest;

public class DemoTest extends BaseTest {

	@BeforeMethod
	public void setUP() throws InterruptedException {
		try {
			launchBrowser();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(enabled=false)
	public void test1() throws InterruptedException {
		Homepage hp = new Homepage(driver);
		Actions action = new Actions(driver);

		action.moveToElement(hp.searchtheproperty()).sendKeys("Western Cape").sendKeys(Keys.ENTER).build().perform();
     	WebDriverWait wait = new WebDriverWait(driver,10);
     	wait.until(ExpectedConditions.elementToBeClickable(hp.clickfindpropertyforsale()));
		hp.clickfindpropertyforsale().click();
		wait.until(ExpectedConditions.elementToBeClickable(hp.selectpropertytypes()));
		hp.selectpropertytypes().click();
		wait.until(ExpectedConditions.elementToBeClickable(hp.selecthouse()));
		hp.selecthouse().click();
		wait.until(ExpectedConditions.elementToBeClickable(hp.selecttownhouse()));
		hp.selecttownhouse().click();
		wait.until(ExpectedConditions.elementToBeClickable(hp.clickminpriceany()));
		hp.clickminpriceany().click();
		wait.until(ExpectedConditions.elementToBeClickable(hp.selectminprice()));
		hp.selectminprice().click();
		wait.until(ExpectedConditions.elementToBeClickable(hp.clickmaxpriceany()));
		hp.clickmaxpriceany().click();
		wait.until(ExpectedConditions.elementToBeClickable(hp.selectmaxprice()));
		hp.selectmaxprice().click();
		wait.until(ExpectedConditions.elementToBeClickable(hp.clickbedrromany()));
		hp.clickbedrromany().click();
		wait.until(ExpectedConditions.elementToBeClickable(hp.selectbedrooms()));
		hp.selectbedrooms().click();
		wait.until(ExpectedConditions.elementToBeClickable(hp.clickonsearchbutton()));
		hp.clickonsearchbutton().click();

	}

	@Test
public void test2() throws InterruptedException {
	Homepage hp = new Homepage(driver);
	Actions action = new Actions(driver);

	action.moveToElement(hp.searchtheproperty()).sendKeys("Western Cape.").sendKeys(Keys.ENTER).build().perform();
 	WebDriverWait wait = new WebDriverWait(driver,10);
 	wait.until(ExpectedConditions.elementToBeClickable(hp.clickfindpropertyforsale()));
	hp.clickfindpropertyforsale().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.selectpropertytypes()));
	hp.selectpropertytypes().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.selecthouse()));
	hp.selecthouse().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.selecttownhouse()));
	hp.selecttownhouse().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.clickminpriceany()));
	hp.clickminpriceany().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.selectminprice()));
	hp.selectminprice().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.clickmaxpriceany()));
	hp.clickmaxpriceany().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.selectmaxprice()));
	hp.selectmaxprice().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.clickbedrromany()));
	hp.clickbedrromany().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.selectbedrooms()));
	hp.selectbedrooms().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.selectbedrooms()));
	hp.clickonmorefilterbutton().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.clickonbathrooms()));
	hp.clickonbathrooms().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.selectonbathrooms()));
	hp.selectonbathrooms().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.clickonparkinggarage()));
	
	
	hp.clickonparkinggarage().click();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(hp.clickonparkingspacebutton()));
	hp.clickonparkingspacebutton().click();
	Thread.sleep(2000);
	hp.selectparkingspacecount().click();
	Thread.sleep(2000);
	
	wait.until(ExpectedConditions.elementToBeClickable(hp.clickonparkingtype()));
	hp.clickonparkingtype().click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(hp.selectparkingtypegarage()));
	hp.selectparkingtypegarage().click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(hp.clickonparkinggarage()));
	hp.clickonparkinggarage().click();
	
	wait.until(ExpectedConditions.elementToBeClickable(hp.selectispetfriendly()));
	hp.selectispetfriendly().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.selecthesflatlet()));
	hp.selecthesflatlet().click();
	
	hp.clickonsearchbutton().click();
	SearchResult sr= new SearchResult(driver);
	
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,100)");
	sr.clickonorderby().click();
	wait.until(ExpectedConditions.elementToBeClickable(hp.selectispetfriendly()));
	sr.selectmostrecent().click();
	
	
	
	
	
	
}}