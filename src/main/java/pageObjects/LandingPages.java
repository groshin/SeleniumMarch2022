package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPages {
	public WebDriver driver;
	public LandingPages(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	
	
	private By administration=By.cssSelector("a[href*='Administration']");
	
	

	public administrationPage getAdministrationPage()
	{
		driver.findElement(administration).click();
		administrationPage ap=new administrationPage(driver);
		return ap;
	}
	


}
