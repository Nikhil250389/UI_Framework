package TestScanario;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.SetUp.BaseTest;

import com.Utilities.Utilities;

import com.pages.PaylaterLogin;

public class CreateRoleTest extends BaseTest {
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());

	PaylaterLogin login;

	@BeforeMethod
	public void setUP() throws InterruptedException, FileNotFoundException, IOException {
		log.info("launchBrowser");
		launchBrowser();
	}

	@Test
	public void Login() throws Exception {
		log.info("Login Positive test");
		login = new PaylaterLogin(driver);
		login.setUserName(Utilities.getPropertyValue(configProperty, "username"));
		login.enterPassword(Utilities.getPropertyValue(configProperty, "password"));
		login.clickLoginButton();
		
		
Thread.sleep(2000);
	//ResuableMethods rm= new ResuableMethods();
	//	HomePage hm= new HomePage(driver);
		
		//rm.waitForElementToBeVisible(driver.findElement(By.xpath("//div[@class='home-menu-column ng-star-inserted'][2]")));
	//	hm.clickManageTab();
		
	}
/*
	@Test(priority = 3)
	public void LoginPageTitle() throws Exception {
		log.info("Login PageTitle test");
		login = new PaylaterLogin(driver);
		String title=driver.getTitle();
		Assert.assertEquals(title, "Nikhil");
	}
	

	*/
	@AfterMethod
	public void tearDown() {
		System.out.println("I am clossing Browser ");
		driver.quit();
	}

}
