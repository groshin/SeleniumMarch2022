package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FluentWaitPage {
	public WebDriver driver;
	public FluentWaitPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By startButton=By.cssSelector("[id='start'] button");
	private By hellowWorld=By.cssSelector("div[id='finish'] h4");
	
	
	public WebElement getStartButton() 
	{
		return driver.findElement(startButton);
	}
	public WebElement getHellowWorld()
	{
		return driver.findElement(hellowWorld);
	}
}
