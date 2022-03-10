package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class alertsPage {
	public WebDriver driver;
	public alertsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By name=By.cssSelector("input[id='name']");
	private By alertButton=By.cssSelector("input[id='alertbtn']");
	private By confirmButton=By.cssSelector("input[id='confirmbtn']");
	
	
	public WebElement getName() 
	{
		return driver.findElement(name);
	}
	public WebElement getAlertButton() 
	{
		return driver.findElement(alertButton);
	}
	
	public WebElement getConfirmButton() 
	{
		return driver.findElement(confirmButton);
	}
}
