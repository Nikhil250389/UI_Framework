package TestScanario;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SetUp.BaseTest;
import com.Utilities.Utilities;
import com.pages.PaylaterLogin;

public class TestLogin extends BaseTest {
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
	}

	@Test(priority = 2)
	public void LoginPageTitle() throws Exception {
		log.info("Login PageTitle test");
		login = new PaylaterLogin(driver);
		String title=driver.getTitle();
		Assert.assertEquals(title, "Nikhil");
	}
	
/*	
	
	@Test(priority = 2, dataProvider = "getData")
	public void rendomLogin(String username, String password) throws Exception {
		log.info("Rendom Testing");
		login = new PaylaterLogin(driver);
		login.setUserName(username);
		login.enterPassword(password);
		login.clickLoginButton();
		
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "Nikhil";
		data[0][1] = "9876543";

		data[1][0] = "Neha";
		data[1][1] = "9876543";

		return data;
*/
	
	@AfterMethod
	public void tearDown() {
		System.out.println("I am clossing Browser ");
		driver.quit();
	}

}
