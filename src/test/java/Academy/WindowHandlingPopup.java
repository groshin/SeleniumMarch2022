package Academy;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import junit.framework.Assert;
import pageObjects.ActionsClassPage;
import pageObjects.AddToCartPage;
import pageObjects.WindowHandlesPage;
import pageObjects.locatorsPage;
import pageObjects.locatorsPage2;

public class WindowHandlingPopup extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyWindowHandles() throws InterruptedException, IOException
	{
		driver.get(prop.getProperty("url15"));
		driver.findElement(By.linkText("Basic Auth")).click();
		Thread.sleep(2000);
					
	}	
		
	@AfterTest
	public void teardown() 
	{
		driver.close();
	}


}
