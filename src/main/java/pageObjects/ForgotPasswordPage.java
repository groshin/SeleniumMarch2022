package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	public WebDriver driver;
	public ForgotPasswordPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	
	
	private By email=By.cssSelector("[id='user_email']");
	private By sendMeInstructions=By.cssSelector("[type='submit']");
	
	
	

	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}

	public WebElement sendMeIns()
	{
		return driver.findElement(sendMeInstructions);
	}
	
	

}
