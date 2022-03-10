package Academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import junit.framework.Assert;
import pageObjects.alertsPage;
import pageObjects.controlsPracticePage;
import pageObjects.dropdownPracticePage;

public class Alerts extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="getJavaAlerts")
	public void validateJavaAlerts(String name, String message) throws InterruptedException
	{
		driver.get(prop.getProperty("url3"));
		
		alertsPage ap=new alertsPage(driver);
		ap.getName().sendKeys(name);
		ap.getAlertButton().click();
		
		Assert.assertTrue(driver.switchTo().alert().getText().contains(name));
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000l);
		
		ap.getConfirmButton().click();		
		Assert.assertTrue(driver.switchTo().alert().getText().contains(message));
		driver.switchTo().alert().dismiss();
		
		Thread.sleep(2000l);		
	}	
		
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

	
	
	
	@DataProvider()
	
	public Object[][] getJavaAlerts()
	{
		Object[][] data=new Object[1][2];
		data[0][0]="Roshin";
		data[0][1]="Hello , Are you sure you want to confirm?";
		
		return data;		
	}

}
