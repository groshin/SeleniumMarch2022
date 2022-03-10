package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollandGridsPage {
	public WebDriver driver;
	public ScrollandGridsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By grids=By.cssSelector(".tableFixHead");
	private By amount=By.cssSelector(".tableFixHead td:nth-child(4)");
	private By total=By.cssSelector(".totalAmount");
	
	
	
	
	public WebElement getGrids() 
	{
		return driver.findElement(grids);
	}
	public List<WebElement> getAmount() 
	{
		return driver.findElements(amount);
	}
	public WebElement getTotal() 
	{
		return driver.findElement(total);
	}
}
