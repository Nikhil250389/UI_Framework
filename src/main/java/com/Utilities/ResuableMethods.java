package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SetUp.BaseTest;



public class ResuableMethods extends BaseTest {
	Map<Object,Object> globalHashMap = new HashMap<Object,Object>();
	
	
	public void waitForElementToBeVisible(WebElement password) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(password));
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}
	
	public void selectFirstValue(WebElement element){
		Select dropdown = new Select(element);
		dropdown.selectByIndex(0);
	}
	
	public String getSelectedValue(WebElement element) {
		Select dropdown = new Select(element);
		return dropdown.getFirstSelectedOption().getText().trim();
	}
	
	protected String[] getDropDownValues(WebElement element) {
		List<WebElement> allOptions = new Select(element).getOptions();
		String[] labels = new String[allOptions.size()];
		for (int i = 0; i < allOptions.size(); i++) {
			labels[i] = allOptions.get(i).getText();
		}
		return labels;
	}
	
	protected void selectDropDownByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}
	
	public static String takeScreenShot() throws IOException {
		String screenShotFileName = System.getProperty("user.dir") + "\\src\\test\\java\\ScreenShot\\"
				+ DateTimeFormatter.ofPattern("yyyy-MM-dd''HHmmss").format(LocalDateTime.now()) + ".png";
		System.out.println(screenShotFileName);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(screenShotFileName));
		return screenShotFileName;
	}
		
	public void mapPut(Object key,Object value) {
		globalHashMap.put(key, value);
	}
	
	public Object mapGet(Object key) {
		return globalHashMap.get(key);
	}
	
	public WebElement getDynamicWebElement(String xpathValue, String substitutionValue ) {
        return driver.findElement(By.xpath(xpathValue.replace("<data>", substitutionValue)));
	}
	
	public ArrayList<String> findAllValues(String element) {
		List<WebElement> allAttribute = new ArrayList<WebElement>();
		List<String> allAttributeValue = new ArrayList<String>();
		allAttribute = driver.findElements(By.xpath(element));

		for(WebElement el : allAttribute) {
			allAttributeValue.add(el.getText().trim());
		}
		return  (ArrayList<String>) allAttributeValue;
		
	}

	public void refresh() {
		driver.navigate().refresh();
	}
	
	public void clickUsingJavaScriptExecutor(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
    public String getCurrentDateTime(String format) {
    	DateFormat df = new SimpleDateFormat(format);
		Date date = new Date();
		return df.format(date);
    }
        
    public int findElements(String element) {    	
		return driver.findElements(By.xpath(element)).size();
    	
    }
    
    public void waitFor(int second) {
    	try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
	private static JavascriptExecutor js() {
		return (JavascriptExecutor) driver;
	}
	
	public static String script(String strScript) {
		return js().executeScript(strScript).toString();
	}
	
	public boolean isPageLoaded() {
		return "complete".equals(script("return document.readyState"));
	}
	
	protected void openNewTab(String url) {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		driver.get(url);
	}
	
	protected void mouseOver(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
	
	public void uploadFile(WebElement element,String path) {
        element.sendKeys(path);
	}
	
}
