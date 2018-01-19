package generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
	
	public RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,primaryWindowHandle;
	
	public GenericMethods(RemoteWebDriver driver){
		
		this.driver = driver;
		
	}
	
	
	
	public GenericMethods() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will launch the browser in local machine and maximize the browser and set the
	 * wait for 30 seconds and load the url
	 * @param url - The url with http or https
	 * 
	 */
	public void invokeApp(String browser) {
		
		
		
		try {
			//DesiredCapabilities dc = new DesiredCapabilities();
			//dc.setBrowserName(browser);
			//dc.setPlatform(Platform.WINDOWS);

			if(browser.equalsIgnoreCase("chrome")){
					//Map<String, Object> prefs = new HashMap<String, Object>();
		        	// Set the notification setting it will override the default setting
					//prefs.put("profile.default_content_setting_values.notifications", 2);
					// Create object of ChromeOption class
					ChromeOptions options = new ChromeOptions();
					// Set the experimental option
					//options.setExperimentalOption("prefs", prefs);
					options.addArguments("--disable-notifications");
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
					driver = new ChromeDriver(options);
				}else if(browser.equalsIgnoreCase("firefox")){
					FirefoxProfile ffprofile = new FirefoxProfile();
					ffprofile.setPreference("dom.webnotifications.enabled", false);
					System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
					driver = new FirefoxDriver(ffprofile);
				}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);
			primaryWindowHandle = driver.getWindowHandle();		
			}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will close all the browsers
	 */
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * This method will enter the value to the text field using id attribute to locate
	  */
	public void enterById(String idValue, String data) {
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			} catch (NoSuchElementException e) {
				
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will enter the value to the text box using name attribute to locate the element
	 */
	
	public void enterByName(String nameValue, String data){
		try{
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will enter the value to the text box using ClassName attribute to locate the element
	 */
	public void enterByClassName(String classnameValue, String data){
		try{
			driver.findElement(By.name(classnameValue)).clear();
			driver.findElement(By.name(classnameValue)).sendKeys(data);
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will enter the value to the text box using xpath attribute to locate the element
	 */
	public void enterByXpath(String xpathValue, String data){
		try{
			//driver.findElement(By.name(xpathValue)).clear();
			driver.findElement(By.name(xpathValue)).sendKeys(data);
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will enter the value to the text box using css attribute to locate the element
	 */
	public void enterByCss(String cssValue, String data){
		try{
			driver.findElement(By.name(cssValue)).clear();
			driver.findElement(By.name(cssValue)).sendKeys(data);
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will click the element using id as locator
	 */
	public void clickById(String id) {
		try{
			driver.findElement(By.id(id)).click();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will click the element using Name as locator
	 */
	public void clickByName(String name) {
		try{
			driver.findElement(By.name(name)).click();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will click the element using ClassName as locator
	 */
	public void clickByClassName(String className) {
		try{
			driver.findElement(By.className(className)).click();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will click the element using xpath as locator
	 */
	public void clickByXpath(String xpath) {
		try{
			driver.findElement(By.xpath(xpath)).click();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will click the element using css as locator
	 */
	public void clickByCss(String css) {
		try{
			driver.findElement(By.cssSelector(css)).click();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will click the element using linkText as locator
	 */
	public void clickByLinkText(String linkText) {
		try{
			driver.findElement(By.linkText(linkText)).click();
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will mouse over on the element using xpath as locator
	 */
	public void mouseOverByXpath(String xpathVal) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will mouse over on the element using css as locator
	 */
	public void mouseOverByCss(String cssVal) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.cssSelector(cssVal))).build().perform();
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will mouse over on the element using Class Name as locator
	 */
	public void mouseOverByClassName(String classNameVal) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.className(classNameVal))).build().perform();
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will mouse over on the element using Class Name as locator
	 */
	public void mouseOverByLinkText(String linkTextVal) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkTextVal))).build().perform();
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * This method will switch the focus to last window
	 */
	
	public void switchToLastWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * This method will switch the focus to parent window
	 */
	
	public void switchToParentWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * This method will switch to alert and accept
	 */
	
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * This method will switch to alert and dismiss
	 */
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will return the text of the element using id as locator
	  */
	public String getTextById(String idVal) {
		String bReturn = "";
		try{
			return driver.findElementById(idVal).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bReturn; 
	}
	
	/**
	 * This method will return the text of the element using xpath as locator
	 */
	public String getTextByXpath(String xpathVal){
		String bReturn = "";
		try{
			return driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bReturn; 
	}
	
	/*
	 * This method will return list of web elements using xpath as locator
	 */
	public List<WebElement> getElmentsByXpath(String xpathVal){
		List<WebElement> list = null;
		try{
			return driver.findElements(By.xpath(xpathVal));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/*
	 * This method will return list of web elements using tag name as locator
	 */
	
	public List<WebElement> getElmentsTagName(String tagName){
		List<WebElement> list = null;
		try{
			return driver.findElements(By.tagName(tagName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * This method will return webelement based on given locator.
	 */
	
	public WebElement getElementByClassName(String className){
		
		WebElement element = null;
		
		try{
			return driver.findElement(By.className(className));
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return element;
		
	}
	
	/*
	 * This method will return webelement based on given locator xpath.
	 */
	
	public WebElement getElementByXpath(String xpath){
		
		WebElement element = null;
		
		try{
			return driver.findElement(By.xpath(xpath));
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return element;
		
	}
	
	public void wait(int seconds){
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void exlicitWait(int seconds, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	/**
	 * This method will verify the given text matches in the element text
	  */
	public boolean verifyTextByXpath(String xpath, String text){
		boolean bReturn = false;
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.equalsIgnoreCase(text)){
				bReturn = true;
			}else{
				bReturn = false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bReturn;
	}
	
	
	

	

}
