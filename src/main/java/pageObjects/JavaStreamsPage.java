package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaStreamsPage {
	public WebDriver driver;
	public JavaStreamsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By vegFruitNameHeader=By.xpath("//tr/th[1]");
	private By vegFruitName=By.xpath("//tr/td[1]");
	private By price=By.xpath("following-sibling::td[1]");
	private By nextButton=By.cssSelector("[aria-label='Next']");
	private By search=By.cssSelector("#search-field");
	
	public WebElement getVegFruitNameHeader() 
	{
		return driver.findElement(vegFruitNameHeader);
	}
	
	public List<WebElement> getVegFruitNames() 
	{
		return driver.findElements(vegFruitName);
	}
	
	public By getPrice() 
	{
		return price;
	}
	public WebElement getNextButton() 
	{
		return driver.findElement(nextButton);
	}
	public WebElement getSearch() 
	{
		return driver.findElement(search);
	}
	
}
