package Academy;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import Resources.base;

import pageObjects.Selenium4Page;


public class Selenium4 extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void relativeLocators()
	{
		driver.get(prop.getProperty("url12"));
		
		Selenium4Page sl=new Selenium4Page(driver);
		WebElement nameEditBox=sl.getName();
		WebElement dof=sl.getLabelDOF();
		WebElement iceCreamLable=sl.getLabelIceCream();
		WebElement rb1=sl.getRadio();
		By lableTN=sl.getLabelTagName();
		By inputTN=sl.getInputTagName();
				
		System.out.println(driver.findElement(with(lableTN).above(nameEditBox)).getText());
		driver.findElement(with(inputTN).below(dof)).click();
		driver.findElement(with(inputTN).toLeftOf(iceCreamLable)).click();
		System.out.println(driver.findElement(with(lableTN).toRightOf(rb1)).getText());
		
	}	
	
	@Test
	public void verifyOpeningNewWindow() throws IOException
	{
		driver.get(prop.getProperty("url12"));
		
		driver.switchTo().newWindow(WindowType.WINDOW);//can use either WindowType.TAB or WindowType.WINDOW
		
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		String parentID=it.next();
		String chileID=it.next();
		
		driver.switchTo().window(chileID);		
		driver.get(prop.getProperty("url13"));
		Selenium4Page sl=new Selenium4Page(driver);
		
		
		String courseName=sl.getCourses().get(1).getText();
		driver.switchTo().window(parentID);
		sl.getName().sendKeys(courseName);
		
		//Taking webelement partial screen shot using selenium
		WebElement name=sl.getName();
		
		File file=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		//Gettiong height and width
		
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		
		
		
	}
		
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}


}
