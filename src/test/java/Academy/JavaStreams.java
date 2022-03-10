package Academy;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
import org.testng.asserts.SoftAssert;

import Resources.base;import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import junit.framework.Assert;
import pageObjects.AddToCartPage;
import pageObjects.BrokenLinksandSoftAssertionsPage;
import pageObjects.JavaStreamsPage;
import pageObjects.WindowHandlesPage;
import pageObjects.locatorsPage;
import pageObjects.locatorsPage2;

public class JavaStreams extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
	}
	
	@SuppressWarnings("deprecation")
	@Test(groups= {"Smoke"})
	public void verifyStreams() throws IOException
	{

		driver.get(prop.getProperty("url14"));
		
		JavaStreamsPage jsp=new JavaStreamsPage(driver);
		jsp.getVegFruitNameHeader().click();
		List<WebElement> elementsList=jsp.getVegFruitNames();
		List<String> originalList=elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));
		
		//pagination and find the price of rice from web table
		By getPrice=jsp.getPrice();
		List<String> price;
		do
		{
			List<WebElement> rows=jsp.getVegFruitNames();
			price=rows.stream().filter(s->s.getText().contains("Rice")).map(s->getVeggiesPrice(s,getPrice))
				.collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			if(price.size()<1)
			{
				jsp.getNextButton().click();
			}
		}while(price.size()<1);
	}
	
	@Test
	public void verifyFiltering()
	{
		driver.get(prop.getProperty("url14"));
		JavaStreamsPage js=new JavaStreamsPage(driver);
		js.getSearch().sendKeys("Rice");
		List<WebElement> veggies=js.getVegFruitNames();
		List<WebElement> filteredlist=veggies.stream().filter(veg->veg.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(filteredlist.size(),veggies.size());
		
	}
	
	
		
	private String getVeggiesPrice(WebElement s, By getPrice) {
		// TODO Auto-generated method stub
		String getPrices=s.findElement(getPrice).getText();
		return getPrices;
	}

	@AfterTest
	public void teardown() 
	{
		driver.close();
	}
}
