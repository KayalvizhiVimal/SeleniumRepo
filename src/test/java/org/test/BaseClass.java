package org.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	static WebDriver driver;
	static Select select;

	public static void main(String[] args) {
		//		browserLaunch("chrome");
	}
	public static void browserLaunch(String browser){
		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver","C:\\NewWorkspace\\SeleniumTraining\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "gecko":
			System.setProperty("webdriver.gecko.driver","C:\\NewWorkspace\\SeleniumTraining\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver","C:\\NewWorkspace\\SeleniumTraining\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Select valid browser");
		}
	}

	public static void urlLaunch(String url) {
		driver.get(url);
	}
	public static void browserMaximize() {
		driver.manage().window().maximize();
	}
	public static void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	public static void waitingTime() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static WebElement findById(String id) { 
		return driver.findElement(By.id(id));
	}
	public static WebElement findByName(String name) { 
		return driver.findElement(By.name(name));
	}
	public static WebElement findByXpath(String xpath) { 
		return driver.findElement(By.xpath(xpath));
	}
	public static void fillValues(WebElement id,String value) {
		id.sendKeys(value);
	}
	public static void buttonClick(WebElement id) {
		id.click();
	}
	public static String getTextValue(WebElement id) {
		String text = id.getText();
		return text;
	}
	public static String  getAttributeValue(WebElement id,String value) {
		String attribute = id.getAttribute(value);
		return attribute;
	}
	public static String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	public static String getTitleName() {
		return driver.getTitle();
	}
	public static void rightClick(WebElement id) {
		Actions action=new Actions(driver);
		action.contextClick(id).perform();
	}
	public static void selectDropdownByText(WebElement id,String value) {
		select=new Select(id);
		select.selectByVisibleText(value);
	}
	public static void selectDropdownByIndex(WebElement id,int index) {
		select=new Select(id);
		select.selectByIndex(index);
	}
	public static Object getTextByJS(WebElement Id) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return js.executeScript("arguments[0].innerText", Id);
	}
	
	public static void windowClose() {
		driver.close();
	}
	public static void windowQuit() {
		driver.quit();
	}


}
