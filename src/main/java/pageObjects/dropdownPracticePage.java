package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dropdownPracticePage {
	public WebDriver driver;
	public dropdownPracticePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By staticDropDown=By.id("ctl00_mainContent_DropDownListCurrency");
	
	private By loopingDropDown=By.xpath("//div[@id='divpaxinfo']");
	private By incrementDropDown=By.xpath("//span[@id='hrefIncAdt']");
	private By doneButton=By.xpath("//input[@id='btnclosepaxoption']");
	
	private By fromDropDown=By.name("ctl00_mainContent_ddl_originStation1_CTXT");
	private By blrValue=By.xpath("//a[@value='BLR']");
	private By toDropDown=By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");	
	private By toDropDown_Chennai=By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']");
	
	private By country=By.cssSelector("input[id='autosuggest']");
	private By listOfCountries=By.cssSelector("li[class='ui-menu-item'] a");
	
	public WebElement getStaticDropDown() 
	{
		return driver.findElement(staticDropDown);
	}
	
	
	public WebElement getPassengers()
	{
		return driver.findElement(loopingDropDown);
	}
	
	public WebElement getIncrement()
	{
		return driver.findElement(incrementDropDown);
	}
	public WebElement getDone()
	{
		return driver.findElement(doneButton);
	}
	
	public WebElement getFrom()
	{
		return driver.findElement(fromDropDown);
	}
	
	public WebElement getFromValueBLR()
	{
		return driver.findElement(blrValue);
	}
	
	public WebElement getTo()
	{
		return driver.findElement(toDropDown);
	}
	
	public WebElement getToValueChennai()
	{
		return driver.findElement(toDropDown_Chennai);
	}
	
	public WebElement getCountry()
	{
		return driver.findElement(country);
	}
	
	public List<WebElement> listOfCountries()
	{
		return driver.findElements(listOfCountries);
	}
	

}
