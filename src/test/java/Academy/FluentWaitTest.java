package Academy;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.FluentWaitPage;


public class FluentWaitTest extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void validateFluentWait() throws InterruptedException
	{
		driver.get(prop.getProperty("url6"));
		
		FluentWaitPage fw=new FluentWaitPage(driver);
		fw.getStartButton().click();
		final WebElement element=fw.getHellowWorld();
		
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        		.withTimeout(Duration.ofSeconds(30))
		        .pollingEvery(Duration.ofSeconds(3))
		        .ignoring(NoSuchElementException.class);
        
		 WebElement foo=wait.until(new Function<WebDriver, WebElement>()
		 {		    	
		    public WebElement apply(WebDriver driver) 
		    {
		    		if(element.isDisplayed())
		    		{
		    			return element;
		    		}
		    		else
		    			return null;
		    	}
		    		    	
		    });
		 System.out.println(element.getText());
		
	}
		

	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
