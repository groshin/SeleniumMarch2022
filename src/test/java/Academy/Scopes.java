package Academy;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import junit.framework.Assert;
import pageObjects.ScopePage;
import pageObjects.locatorsPage;
import pageObjects.locatorsPage2;

public class Scopes extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void validateLocators() throws InterruptedException
	{
		driver.get(prop.getProperty("url3"));
		
		ScopePage sp=new ScopePage(driver);
		Integer Count1=sp.getLinks().size();
		//System.out.println(Count1);
		
		Integer Count2=sp.getFooterLinks().size();
		//System.out.println(Count2); 
		
		Integer Count3=sp.getColumnLinks().size();
		//System.out.println(Count3);
		
		for(int i=1;i<Count3;i++)
		{
			String clickonlinktab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			sp.getColumnLinks().get(i).sendKeys(clickonlinktab);
		}
		
		Set<String> window=driver.getWindowHandles();
		Iterator<String>it=window.iterator();
		String parentID=it.next();
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());
		while(it.hasNext())
		{				
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			driver.close();
		}	
		driver.switchTo().window(parentID);
	}	
		
	@AfterTest
	public void teardown()
	{
		driver.close();
	}


}
