package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScopePage {
	public WebDriver driver;
	public ScopePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By totalLinks=By.tagName("a");
	private By footer=By.id("gf-BIG");
	private By footerLinks=By.tagName("a");
	private By column=By.xpath("//table/tbody/tr/td[1]/ul");
	private By columnLinks=By.tagName("a");
	
	
	
	
	public List<WebElement> getLinks() 
	{
		return driver.findElements(totalLinks);
	}
	public WebElement getFooter() 
	{
		return driver.findElement(footer);
	}
	public List<WebElement> getFooterLinks() 
	{
		return getFooter().findElements(footerLinks);
	}
	public WebElement getColumn() 
	{
		return getFooter().findElement(column);
	}
	public List<WebElement> getColumnLinks() 
	{
		return getColumn().findElements(columnLinks);
	}
	
	
}
