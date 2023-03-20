package com.testNG.concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class ParallelTesting {

	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
	//	driver=new ChromeDriver();		
	}
	@Test
	public void testLogo()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		WebElement logo=driver.findElement(By.xpath("/html/body/nav/div/a/img"));
		Assert.assertTrue(logo.isEnabled());	
	}
	@Test
	public void testTitle()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		String title=driver.getTitle();
		Assert.assertEquals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM", title);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
