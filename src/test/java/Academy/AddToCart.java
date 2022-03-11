package Academy;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import junit.framework.Assert;
import pageObjects.AddToCartPage;
import pageObjects.locatorsPage;
import pageObjects.locatorsPage2;

public class AddToCart extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="getVeggiesNeeded")
	public void greenCart(String Item1,String Item2,String Item3,String Item4, String promoCode) throws InterruptedException
	{
		driver.get(prop.getProperty("url5"));
		
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		AddToCartPage ac=new AddToCartPage(driver);
		String[] itemsNeeded= {Item1,Item2,Item3,Item4};
		Integer count= itemsNeeded.length;
		List itemsNeededList=Arrays.asList(itemsNeeded);
		List<WebElement> products=ac.getProducts();
		int j=0;
		for(int i=0;i<products.size();i++)
		{
			String[] name=products.get(i).getText().split("-");
			String formattedName=name[0].trim();
			if(itemsNeededList.contains(formattedName))
			{
				ac.getAddToCart().get(i).click();
				j++;
			}
			
			if(j==count)
			{
				break;
			}
			
		}
		By getPromoCodeWait=ac.getPromoCodeWait();
		By getPromoInfoWait=ac.getPromoInfoWait();
		
		ac.getCart().click();
		ac.getProceedToCheckOut().click();
		w.until(ExpectedConditions.visibilityOfElementLocated(getPromoCodeWait));
		ac.getPromoCode().sendKeys(promoCode);
		ac.getApplyButton().click();
		w.until(ExpectedConditions.visibilityOfElementLocated(getPromoInfoWait));
		Assert.assertTrue(ac.getPromoInfo().isDisplayed());
		
		Thread.sleep(3000);
		System.out.println("This is for GIT Fifth message");
				
	}	
		
	@AfterTest
	public void teardown()
	{
		driver.close();
	}


	
	@DataProvider()
	
	public Object[][] getVeggiesNeeded()
	{
		Object[][] data=new Object[1][5];
		data[0][0]="Cucumber";
		data[0][1]="Brocolli";
		data[0][2]="Beetroot";
		data[0][3]="Carrot";
		data[0][4]="rahulshettyacademy";
		
		return data;		
	}

}
