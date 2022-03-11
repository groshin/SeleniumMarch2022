package Academy;



import java.io.IOException;



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

import pageObjects.ActionsFramesClassPage;


public class ActionsFramesTest extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="getValues")
	public void actionsVerify(String text) throws InterruptedException
	{
		driver.get(prop.getProperty("url7"));
		
		
		ActionsFramesClassPage ac=new ActionsFramesClassPage(driver);
		WebElement element=ac.getAccountList();
		WebElement searchBox=ac.getSearchTextbox();
		Actions a=new Actions(driver);
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys(text).doubleClick().build().perform();
		Thread.sleep(1000);
		a.moveToElement(element).contextClick().build().perform();
		
		Thread.sleep(1000);
		System.out.println("This is for GIT First message");
		System.out.println("This is for GIT Second message");
		System.out.println("This is for GIT Third message");
		System.out.println("This is for GIT Fourth message");
				
	}	
	
	@Test
	public void framesVerify() throws InterruptedException
	{
		driver.get(prop.getProperty("url9"));
		
		ActionsFramesClassPage ac1=new ActionsFramesClassPage(driver);
		
		
		
		driver.switchTo().frame(ac1.getFrame());
		
		Actions a=new Actions(driver);
		WebElement source=ac1.getSource();
		WebElement target=ac1.getTarget();
		
		a.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();//switch back from frames to normal window
		Thread.sleep(1000);
				
	}
		
	@AfterTest
	public void teardown()
	{
		driver.close();
	}


	
	@DataProvider()
	
	public Object[][] getValues()
	{
		Object[][] data=new Object[1][1];
		data[0][0]="hello";
		
		
		return data;		
	}

}
