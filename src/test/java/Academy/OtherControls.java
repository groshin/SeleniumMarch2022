package Academy;

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
import pageObjects.controlsPracticePage;
import pageObjects.dropdownPracticePage;

public class OtherControls extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(groups= {"Smoke"},dataProvider="getCheckBox")
	public void validateCheckBox(Integer count) throws InterruptedException, IOException
	{
		
		driver.get(prop.getProperty("url2"));
		
		controlsPracticePage cb=new controlsPracticePage(driver);
		Assert.assertFalse(cb.getSeniorCitizen().isSelected());
		cb.getSeniorCitizen().click();
		Assert.assertTrue(cb.getSeniorCitizen().isSelected());
		List<WebElement> total=cb.getTotalCheckBox();
		Integer tot=total.size();
		Assert.assertEquals(count,tot);
		Thread.sleep(2000l);		
	}
	
	@Test
	public void chooseCurrentDate() throws InterruptedException
	{
		driver.get(prop.getProperty("url2"));
		controlsPracticePage dc=new controlsPracticePage(driver);
		dc.getDepartDate().click();
		dc.getCurrentDate().click();	
		Thread.sleep(2000l);
	}
	
	@Test	
	public void verifyControlEnabled() throws InterruptedException
	{
		driver.get(prop.getProperty("url2"));
		controlsPracticePage ce=new controlsPracticePage(driver);
		Assert.assertTrue(ce.getReturnDate().getAttribute("style").contains("0.5"));
		ce.getRoundTrip().click();
		Assert.assertTrue(ce.getReturnDate().getAttribute("style").contains("1"));
		Thread.sleep(2000l);		
	}
	
	@Test
	public void verifyAnyDates() throws InterruptedException
	{
		driver.get(prop.getProperty("url10"));
		controlsPracticePage cp=new controlsPracticePage(driver);
		cp.getDateOfTravel().click();
		WebElement month=cp.getMonth();
		while(!month.getText().contains("June"))
		{
			cp.getNextMonth().click();
			
		}
		Thread.sleep(3000);
		int Count=cp.getDays().size();
		for(int i=0;i<Count;i++)
		{
			String text=cp.getDays().get(i).getText();
			if(text.equalsIgnoreCase("20"))
			{
				cp.getDays().get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
	}
	@Test
	public void handlingSSLCertification() throws InterruptedException
	{
		driver.get(prop.getProperty("url11"));
		System.out.println(driver.getTitle());
		//Use the below one in base.java
		//options.setAcceptInsecureCerts(true);
		Thread.sleep(3000);
		
	}
		
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

	
	
	
	@DataProvider()
	
	public Object[][] getCheckBox()
	{
		Object[][] data=new Object[1][1];
		data[0][0]=6;
		
		return data;		
	}

}
