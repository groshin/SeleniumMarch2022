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
import pageObjects.dropdownPracticePage;

public class ControlsDropDowns extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="getStatic")
	public void validateStaticDropDown(String USCur, String AFGCur, String INDCu)
	{
		driver.get(prop.getProperty("url2"));
		
		dropdownPracticePage ddsp=new dropdownPracticePage(driver);
		WebElement currency=ddsp.getStaticDropDown();
		Select dd=new Select(currency);
		dd.selectByIndex(3);
		Assert.assertEquals(dd.getFirstSelectedOption().getText(), USCur);
		
		dd.selectByVisibleText(AFGCur);
		Assert.assertEquals(dd.getFirstSelectedOption().getText(), AFGCur);
		
		dd.selectByValue(INDCu);
		Assert.assertEquals(dd.getFirstSelectedOption().getText(), INDCu);				
	}
	
	@Test(dataProvider="getLoopingDropDown")
	
	public void loopingDropDown(String defaultPassenger, Integer Count, String TotalPassenger) throws InterruptedException
	{
		driver.get(prop.getProperty("url2"));
		Thread.sleep(2000l);
		dropdownPracticePage lddP=new dropdownPracticePage(driver);
		WebElement passengers=lddP.getPassengers();
		Assert.assertEquals(passengers.getText(), defaultPassenger);
		passengers.click();
		Thread.sleep(2000l);
		Count=1;
		while(Count<5)
		{
			lddP.getIncrement().click();
			Count++;
		}
		Assert.assertEquals(passengers.getText(), TotalPassenger);		
	}
	
	@Test(dataProvider="getDynamicDropDown")
	
	public void dynamicDropDown(String fromValue, String toValue) throws InterruptedException
	{
		driver.get(prop.getProperty("url2"));
		dropdownPracticePage dd=new dropdownPracticePage(driver);
		Thread.sleep(1000l);
		dd.getFrom().click();
		dd.getFromValueBLR().click();
		dd.getToValueChennai().click();
		Assert.assertEquals(fromValue, dd.getFrom().getAttribute("value"));
		Assert.assertEquals(toValue, dd.getTo().getAttribute("value"));
		Thread.sleep(2000l);
	}
	
	@Test(dataProvider="getAutoSuggestiveDropDown")
	public void autoSuggestiveDropDown(String contryName, String expectedCountry ) throws InterruptedException	
	{
		driver.get(prop.getProperty("url2"));
		dropdownPracticePage as=new dropdownPracticePage(driver);
		as.getCountry().sendKeys(contryName);
		List<WebElement> options=as.listOfCountries();
		
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase(expectedCountry))
			{
				option.click();
				break;
			}		  
		}
		Assert.assertEquals(expectedCountry, as.getCountry().getAttribute("value"));
		Thread.sleep(2000l);
		
	}

	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

	
	
	
	@DataProvider()
	
	public Object[][] getStatic()
	{
		Object[][] data=new Object[1][3];
		data[0][0]="USD";
		data[0][1]="AED";
		data[0][2]="INR";
		
		return data;		
	}
	
	@DataProvider()	
	public Object[][] getLoopingDropDown()
	{
		Object[][] data=new Object[1][3];
		data[0][0]="1 Adult";
		data[0][1]= 4;
		data[0][2]="5 Adult";
		
		return data;
	}
	
	@DataProvider()
	public Object[][] getDynamicDropDown()
	{
		Object[][] data=new Object[1][2];
		data[0][0]="Bengaluru (BLR)";
		data[0][1]="Chennai (MAA)";
		return data;
	}
	
	@DataProvider()
	public Object[][] getAutoSuggestiveDropDown()
	{
		Object[][] data=new Object[1][2];
		data[0][0]="ind";
		data[0][1]="India";
		return data;
	}
	
	

}
