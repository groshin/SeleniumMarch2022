package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPages {
	public WebDriver driver;
	public LoginPages(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	
	
	private By userName=By.cssSelector("[id='UserName']");
	private By password=By.cssSelector("[type='password']");
	private By login=By.cssSelector("[value='Sign In']");	
	
	
	public WebElement getUserName()
	{
		return driver.findElement(userName);
	}

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	

}
