package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindowHandlesPage {
	public WebDriver driver;
	public WindowHandlesPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By blinkingLink=By.cssSelector(".blinkingText");
	private By text=By.cssSelector(".im-para.red");
	private By emailId=By.cssSelector("#username");	
	
	public WebElement getBlinkingLink() 
	{
		return driver.findElement(blinkingLink);
	}
	public WebElement getUserNameText() 
	{
		return driver.findElement(text);
	}
	public WebElement getEmailId() 
	{
		return driver.findElement(emailId);
	}
	
}
