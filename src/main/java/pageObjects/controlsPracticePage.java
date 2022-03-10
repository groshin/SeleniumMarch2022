package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class controlsPracticePage {
	public WebDriver driver;
	public controlsPracticePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By seniorCitizen=By.cssSelector("input[id*='SeniorCitizenDiscount']");
	private By toatlCheckBox=By.cssSelector("input[type='checkbox']");
	
	private By departDate=By.cssSelector("#ctl00_mainContent_view_date1");
	private By currentDate=By.cssSelector(".ui-datepicker-days-cell-over.ui-datepicker-today");
	
	private By returnDate=By.cssSelector("#Div1");
	private By roundTrip=By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']");
	
	private By dateOfTravel=By.xpath("//*[@id='travel_date']");
	
	private By months=By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']");
	
	private By nextMonth=By.cssSelector("[class='datepicker-days'] th[class='next']");
	private By days=By.className("day");
	
	
	public WebElement getSeniorCitizen() 
	{
		return driver.findElement(seniorCitizen);
	}
	public List<WebElement> getTotalCheckBox() 
	{
		return driver.findElements(toatlCheckBox);
	}
	
	public WebElement getDepartDate() 
	{
		return driver.findElement(departDate);
	}
	public WebElement getCurrentDate() 
	{
		return driver.findElement(currentDate);
	}
	
	public WebElement getReturnDate() 
	{
		return driver.findElement(returnDate);
	}
	public WebElement getRoundTrip() 
	{
		return driver.findElement(roundTrip);
	}
	
	public WebElement getDateOfTravel() 
	{
		return driver.findElement(dateOfTravel);
	}
	
	public WebElement getMonth() 
	{
		return driver.findElement(months);
	}
	public WebElement getNextMonth() 
	{
		return driver.findElement(nextMonth);
	}
	
	public List<WebElement> getDays() 
	{
		return driver.findElements(days);
	}
	
	
	
}
