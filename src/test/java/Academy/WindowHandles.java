package Academy;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class WindowHandles extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(groups= {"Smoke"})
	public void verifyWindowHandles() throws InterruptedException, IOException
	{
		
		driver.get(prop.getProperty("url8"));
		
		WindowHandlesPage wh=new WindowHandlesPage(driver);
		wh.getBlinkingLink().click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		
		String emailId=wh.getUserNameText().getText().split("at")[1].trim().split(" ")[0];
		driver.close();
		driver.switchTo().window(parentId);
		wh.getEmailId().sendKeys(emailId);
		
		Thread.sleep(2000);	
		
			
	}	
		
	@AfterTest
	public void teardown() 
	{
		driver.close();
	}


}
