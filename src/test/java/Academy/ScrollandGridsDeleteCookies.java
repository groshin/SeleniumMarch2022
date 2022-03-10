package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;



import Resources.base;
import junit.framework.Assert;
import pageObjects.ScrollandGridsPage;


public class ScrollandGridsDeleteCookies extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed("seesionKey");
	}
	
	@Test(dataProvider="getLoginDetails")
	public void verifyScrolling(String loginText) throws InterruptedException
	{
		driver.get(prop.getProperty("url3"));
		ScrollandGridsPage sg=new ScrollandGridsPage(driver);
		//WebElement grids=sg.getGrids();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		int sum=0;
		List<WebElement> amounts=sg.getAmount();
		for(int i=0;i<amounts.size();i++)
		{
			sum=sum+Integer.parseInt(amounts.get(i).getText());
		}
		int total=Integer.parseInt(sg.getTotal().getText().split(":")[1].trim());
		Assert.assertEquals(sum, total);
		
		
		
				
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
