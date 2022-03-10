package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinksandSoftAssertionsPage {
	public WebDriver driver;
	public BrokenLinksandSoftAssertionsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By links=By.cssSelector("[class='gf-li'] a");

	public List<WebElement> getLinks() 
	{
		return driver.findElements(links);
	}
}
