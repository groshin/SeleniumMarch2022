package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class locatorsPage2 {
	public WebDriver driver;
	public locatorsPage2(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By login=By.xpath("//header/div/button[1]/following-sibling::button[1]");
	private By loginParent=By.xpath("//header/div/button[1]/parent::div/button[2]");
	
	
	
	
	public WebElement getLogin() 
	{
		return driver.findElement(login);
	}
	public WebElement getLoginParent() 
	{
		return driver.findElement(loginParent);
	}
}
