package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class validateTitle extends base {
	public WebDriver driver;
	LandingPage l;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	
	public void initialize() throws IOException
	{		
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url1"));
		log.info("Navigated to Home Page");
	}
	@Test
	
	public void validateAppTitle() throws IOException
	{
		
		
		l=new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated text message");
	}
	
	@Test
	public void validateHeader() throws IOException
	{
		 	
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}
