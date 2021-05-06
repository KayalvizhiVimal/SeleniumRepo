package org.com.junit;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.test.BaseClass;

public class JavaUnitSample extends BaseClass {
	@BeforeClass
	public static void beforeClass() {
		browserLaunch("chrome");
	}
	@AfterClass
	public static void afterClass() {
		windowQuit();
	}
	@Before
	public  void before() {

	}
	@After
	public  void after() {
		Date d =new Date();
		System.out.println(d);
	}
	@Test
	public  void test1() {
		urlLaunch("https://adactinhotelapp.com/");
		findById("username").sendKeys("Vimalchandar4344");
		findById("password").sendKeys("Vimal@4344");
		findById("login").click();
	}
	@Test
	public  void test2() {
		selectDropdownByText(findById("location"),"London");
		selectDropdownByText(findById("hotels"),"Hotel Sunshine");
		selectDropdownByText(findById("room_type"),"Standard");
		selectDropdownByText(findById("room_nos"),"1 - One");
		findById("Submit").click();
	}
	@Test
	public void test3() {
		findById("radiobutton_0").click();
		findById("continue").click();
	}
	@Test
	public void test4() {
		findById("first_name").sendKeys("KayalVizhi");
		findById("last_name").sendKeys("Muthu");
		findById("address").sendKeys("Chennai");
		findById("cc_num").sendKeys("4355699988559879");
		selectDropdownByText(findById("cc_type"), "VISA");
		selectDropdownByText(findById("cc_exp_month"), "July");
		selectDropdownByText(findById("cc_exp_year"), "2022");
		findById("cc_cvv").sendKeys("100");
		findById("book_now").click();

	}
	@Test
	public void test5() {
		waitingTime();
		String attribute = findByXpath("//input[@name='order_no']").getAttribute("value");
		System.out.println(attribute);
	}
}
