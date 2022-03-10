package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsFramesClassPage {
	public WebDriver driver;
	public ActionsFramesClassPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By accountList=By.cssSelector("a[id='nav-link-accountList']");
	private By searchTextbox=By.xpath("//input[@id='twotabsearchtextbox']");
	private By frame=By.cssSelector("iframe.demo-frame");
	private By source=By.cssSelector("#draggable");
	private By target=By.cssSelector("div.ui-widget-header.ui-droppable");
		
	
	public WebElement getAccountList() 
	{
		return driver.findElement(accountList);
	}
	public WebElement getSearchTextbox() 
	{
		return driver.findElement(searchTextbox);
	}
	public WebElement getFrame() 
	{
		return driver.findElement(frame);
	}
	public WebElement getSource() 
	{
		return driver.findElement(source);
	}
	public WebElement getTarget() 
	{
		return driver.findElement(target);
	}
	
}
