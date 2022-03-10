package Academy;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
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
import org.testng.asserts.SoftAssert;

import Resources.base;
import junit.framework.Assert;
import pageObjects.ActionsClassPage;
import pageObjects.AddToCartPage;
import pageObjects.BrokenLinksandSoftAssertionsPage;
import pageObjects.WindowHandlesPage;
import pageObjects.locatorsPage;
import pageObjects.locatorsPage2;

public class BrokenLinksandSoftAssertions extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyWindowHandles() throws InterruptedException, MalformedURLException, IOException
	{
		driver.get(prop.getProperty("url3"));
		
		BrokenLinksandSoftAssertionsPage bl=new BrokenLinksandSoftAssertionsPage(driver);
		
		List<WebElement> links=bl.getLinks();
		SoftAssert a=new SoftAssert();
		for(WebElement link:links)
		{
			String url=link.getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode=conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400, "The link with Text " +link.getText()+" is broken with code "+respCode);//it would report only when fails. ie respCode>400
			
			/*if(respCode>400)
			{
				System.out.println("The link with Text " +link.getText()+" is broken with code "+respCode);
				Assert.assertTrue(false);
			}*/
		}
	
		a.assertAll();
		
		Thread.sleep(2000);	
		
			
	}	
		
	@AfterTest
	public void teardown() 
	{
		driver.close();
	}


}
