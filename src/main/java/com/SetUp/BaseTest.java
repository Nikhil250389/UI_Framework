package com.SetUp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.Utilities.Utilities;

public class BaseTest {

	public static String configProperty = "./src/main/java/propertiesFiles/config.properties";
	public static Utilities utilities = new Utilities();
	String CHROME_KEY = Utilities.getPropertyValue(configProperty, "CHROME_KEY");
	String CHROME_VALUE = Utilities.getPropertyValue(configProperty, "CHROME_VALUE");
	String FIREFOX_KEY = Utilities.getPropertyValue(configProperty, "FIREFOX_KEY");
	String FIREFOX_VALUE = Utilities.getPropertyValue(configProperty, "FIREFOX_VALUE");
	String ITO = Utilities.getPropertyValue(configProperty, "ITO");
	String PLT = Utilities.getPropertyValue(configProperty, "PLT");

	/*private WebDriver driver;
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	
	public WebDriver getDriver() {
		
		return dr.get();
		
	}
	public void setWebdriver (WebDriver driver) {
		dr.set(driver);
	}
	*/
	protected static WebDriver driver = null;

	public void launchBrowser() throws FileNotFoundException, IOException {

		System.out.println("Ready to launch a browser");

		if (Utilities.getPropertyValue(configProperty, "browser").equalsIgnoreCase("chrome")) {
			System.out.println("**Launching Chrome Browser**");
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
		} else if (Utilities.getPropertyValue(configProperty, "browser").equalsIgnoreCase("firefox")) {
			System.out.println("**Launching firefox Browser**");
			System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
			driver = new FirefoxDriver();
		}

		
		//setWebdriver(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(ITO), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(PLT), TimeUnit.SECONDS);
		driver.get(Utilities.getPropertyValue(configProperty, "url"));
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destinationFile= System.getProperty("user.dir")+"\\FailedTestcaseScreenShot\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
	}

	

}
