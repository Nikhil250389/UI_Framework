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
import com.pages.NewPagesRepository.MyntraHome;
import com.pages.NewPagesRepository.MyntraMenHome;

public class MyntraHomeTest extends BaseTest {
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());

	PaylaterLogin login;
	MyntraHome mp;
	WebDriverWait wait;

	@BeforeMethod
	public void setUP() throws InterruptedException, FileNotFoundException, IOException {
		log.info("launchBrowser");
		launchBrowser();
		mp = new MyntraHome(driver);
		// hp.WelcomeButton();
	}
	@Test(priority = 1)
	public void verifybyclickonHomeheaderManlink() throws Exception {
		log.info("Verify by click on Home header Man link Positive test");
		List<WebElement> allAttribute = new ArrayList<WebElement>();
		allAttribute = mp.HomePageHeader();
		for (WebElement el : allAttribute) {

			if (el.getText().equalsIgnoreCase("Men")) {
				Thread.sleep(2000);
				el.click();
			}}}
	
	@Test(priority = 2)
	public void verifyBySelectMenProducts() throws Exception {
		log.info("Generic Header Xpath Positive test");
		List<WebElement> allAttribute = new ArrayList<WebElement>();
		allAttribute = mp.HomePageHeader();
		for (WebElement el2 : allAttribute) {
         if (el2.getText().equalsIgnoreCase("Men")) {
				Thread.sleep(2000);
				el2.click();
				
				MyntraMenHome mh= new MyntraMenHome(driver);
				JavascriptExecutor js = (JavascriptExecutor) driver;
			
			WebElement BiggestDealBrand=mh.BiggestDealBrand();
				js.executeScript("arguments[0].scrollIntoView();", BiggestDealBrand);
				 
				List<WebElement> allMenBestDealBrand = new ArrayList<WebElement>();
				List<String> allAttributeValue = new ArrayList<String>();
				allMenBestDealBrand = mh.MenBestDealOnTopBrand();
				for (WebElement eh : allMenBestDealBrand) {
					 allAttributeValue.add(eh.getText().trim());
				}
		    /*     if (eh.getText().equalsIgnoreCase("Men")) {
						Thread.sleep(2000);
						eh.click();
				*/
				
				System.out.println(allAttributeValue);
						}}}
	
	
		

/*	
	@AfterMethod public void tearDown() {
  System.out.println("I am clossing Browser "); driver.quit(); }
*/
}
