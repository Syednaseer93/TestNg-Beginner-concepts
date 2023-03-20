package com.testNG.concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class DataProviderDemo {
WebDriver driver;
@Test(dataProvider="givedata")
public void loginTest(String username,String pwd) {
	WebDriverManager.chromedriver().setup(); 
	driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.name("username")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(pwd);
	driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	String title=driver.getTitle();
	
	Assert.assertEquals("OrangeHRM", title);
}


@DataProvider(name="givedata")
public Object[][] getData()
{
	Object[][] data= {{"syed@gmail.com","1234"},{"naseer@gmail.com","2345"},{"john@gmail.com","9876"},{"Admin","admin123"}};
	return data;
	
}
@AfterMethod	
void tearDown()
{
	driver.quit();
}
	
}
