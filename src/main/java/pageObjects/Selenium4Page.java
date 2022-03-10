package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Selenium4Page {
	public WebDriver driver;
	public Selenium4Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By name=By.cssSelector("[name='name']");
	private By labelDOF=By.xpath("//label[@for='dateofBirth']");
	private By labelIceCream=By.xpath("//label[(text()='Check me out if you Love IceCreams!')]");
	private By radio=By.cssSelector("#exampleCheck1");
	private By labelTagName=By.tagName("label");
	private By inputTagName=By.tagName("input");
	private By courses=By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']");
	
	public WebElement getName() 
	{
		return driver.findElement(name);
	}
	public WebElement getLabelDOF() 
	{
		return driver.findElement(labelDOF);
	}
	public WebElement getLabelIceCream() 
	{
		return driver.findElement(labelIceCream);
	}
	public WebElement getRadio() 
	{
		return driver.findElement(radio);
	}
	public By getLabelTagName() 
	{
		return labelTagName;
	}
	public By getInputTagName() 
	{
		return inputTagName;
	}
	public List<WebElement> getCourses() 
	{
		return driver.findElements(courses);
	}
	
}

	

