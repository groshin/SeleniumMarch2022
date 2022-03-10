package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class gcmsAdministrationPage {
	public WebDriver driver;
	public gcmsAdministrationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	
	
	private By createProject=By.cssSelector("a[href*='Project/AddEdit']");
	
	

	public WebElement getCreateProject()
	{
		return driver.findElement(createProject);		
	}
	


}
