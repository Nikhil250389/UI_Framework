package Generic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	
	public static String configProperty="./src/main/java/propertiesFiles/config.properties";
	protected static  Utilities utilities = new Utilities();
	String CHROME_KEY=utilities.getPropertyValue(configProperty, "CHROME_KEY");
	String CHROME_VALUE=utilities.getPropertyValue(configProperty, "CHROME_VALUE");
	String ITO=utilities.getPropertyValue(configProperty, "ITO");
    String PLT=utilities.getPropertyValue(configProperty, "PLT");
	

     protected static WebDriver driver=null;
  
public void launchBrowser() throws FileNotFoundException, IOException {

System.out.println("Ready to launch a browser");

if(utilities.getPropertyValue(configProperty, "browser").equalsIgnoreCase("chrome")){
System.out.println("**Launching Chrome Browser**");
System.setProperty(CHROME_KEY,CHROME_VALUE);
driver= new ChromeDriver();
}
else if(utilities.getPropertyValue(configProperty, "browser").equalsIgnoreCase("firefox")){
System.out.println("**Launching Chrome Browser**");
System.setProperty(CHROME_KEY,CHROME_VALUE);
driver= new FirefoxDriver();
}

driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(Long.parseLong(ITO),TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(Long.parseLong(PLT), TimeUnit.SECONDS);
driver.get(utilities.getPropertyValue(configProperty, "url"));
}

@AfterMethod(alwaysRun=true)
public void tearDown() {
System.out.println("I am clossing Browser ");
//driver.quit();
}

	

}
