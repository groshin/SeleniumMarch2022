package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import junit.framework.Assert;
import pageObjects.locatorsPage;
import pageObjects.locatorsPage2;

public class Locators2 extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="getLoginDetails")
	public void validateLocators(String loginText) throws InterruptedException
	{
		driver.get(prop.getProperty("url3"));
		
		locatorsPage2 lp=new locatorsPage2(driver);
		Assert.assertEquals(loginText, lp.getLogin().getText());
		
		Assert.assertEquals(loginText, lp.getLoginParent().getText());
		
		driver.navigate().to(prop.getProperty("url4"));
		driver.navigate().back();
		driver.navigate().forward();
		
				
	}	
		
	@AfterTest
	public void teardown()
	{
		driver.close();
	}


	
	@DataProvider()
	
	public Object[][] getLoginDetails()
	{
		Object[][] data=new Object[1][1];
		data[0][0]="Login";
		
		
		return data;		
	}

}
