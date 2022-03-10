package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class administrationPage {
	public WebDriver driver;
	public administrationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	
	
	private By gcmsAdministration=By.xpath("//span[text()='GCMS Administration']");
	
	

	public WebElement getGCMSAdministration()
	{
		return driver.findElement(gcmsAdministration);		
	}
	


}
