package TestScanario;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SetUp.BaseTest;
import com.Utilities.ResuableMethods;
import com.Utilities.Utilities;
import com.pages.CreateNewUser;
import com.pages.HomePage;
import com.pages.PaylaterLogin;

public class createLender extends BaseTest {
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());

	PaylaterLogin login;

	@BeforeMethod
	public void setUP() throws InterruptedException, FileNotFoundException, IOException {
		log.info("launchBrowser");
		launchBrowser();
	}

	@Test(priority = 1)
	public void Login() throws Exception {
		log.info("Login Positive test");
		login = new PaylaterLogin(driver);
		login.setUserName(Utilities.getPropertyValue(configProperty, "username"));
		login.enterPassword(Utilities.getPropertyValue(configProperty, "password"));
		login.clickLoginButton();
	}

	@Test(priority = 2)
	public void Homepage() throws Exception {
		log.info("Validating Home page Icon name");
		HomePage hp = new HomePage(driver);
		ResuableMethods rm = new ResuableMethods();
		rm.waitForElementToBeVisible(hp.HomePageIconName());
		hp.HomePageIconName().isDisplayed();
		hp.clickManageTab();
	//	rm.waitForElementToBeVisible(hp.clickManageTab());
		hp.clickManageTab();
		rm.waitForElementToBeVisible(hp.createbutton());
		hp.createbutton().click();
		CreateNewUser cnu = new CreateNewUser(driver);
	//	rm.waitForElementToBeVisible(cnu.selectRoleType());
		List<WebElement> roleList = cnu.selectRoleType();
		for (int i = 0; i < roleList.size(); i++) {
			String elementText = roleList.get(i).getText();
			if (elementText.contains("Institutional Lender")) {
				cnu.selectRoleType().get(i).click();
			}}
		
		
	}
	

	
	@AfterMethod
	public void tearDown() {
		System.out.println("I am clossing Browser ");
		driver.quit();
	}

}
