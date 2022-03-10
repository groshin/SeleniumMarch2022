package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class locatorsPage {
	public WebDriver driver;
	public locatorsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By userName=By.id("inputUsername");
	private By password=By.name("inputPassword");
	private By signIn=By.className("signInBtn");
	private By errorMessageInvalidlogin=By.cssSelector("p.error");
	private By forgotPassword=By.linkText("Forgot your password?");
	private By forgotName=By.xpath("//input[@placeholder='Name']");
	private By email=By.cssSelector("input[placeholder='Email']");
	private By emailXp=By.xpath("//input[@type='text'][2]");
	private By emailCs=By.cssSelector("input[type='text']:nth-child(3)");
	private By phoneNumber=By.xpath("//form/input[3]");
	private By resetLogin=By.cssSelector(".reset-pwd-btn");
	private By resetMessage=By.cssSelector("form p");
	
	private By gotoLogin=By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]");
	private By name=By.cssSelector("#inputUsername");
	private By pass=By.cssSelector("[type*='pass']");
	private By remindUserName=By.id("chkboxOne");
	private By sign=By.xpath("//button[contains(@class,'submit')]");
	
	private By succesMessage=By.tagName("p");
	private By firstMessage=By.cssSelector("div[class='login-container'] h2");
	
	private By logOut=By.xpath("//button[text()='Log Out']");
	
	private By forgotPWDParialLT=By.partialLinkText("password");
	
	public WebElement getUserName() 
	{
		return driver.findElement(userName);
	}
	public WebElement getPassword() 
	{
		return driver.findElement(password);
	}
	
	public WebElement getSignIn() 
	{
		return driver.findElement(signIn);
	}
	public WebElement getErrorMessageInvalidlogin() 
	{
		return driver.findElement(errorMessageInvalidlogin);
	}
	
	public WebElement getForgotPassword() 
	{
		return driver.findElement(forgotPassword);
	}
	public WebElement getForgotName() 
	{
		return driver.findElement(forgotName);
	}
	
	public WebElement getEmail() 
	{
		return driver.findElement(email);
	}
	public WebElement getEmailXp() 
	{
		return driver.findElement(emailXp);
	}
	public WebElement getEmailCs() 
	{
		return driver.findElement(emailCs);
	}
	public WebElement getPhoneNumber() 
	{
		return driver.findElement(phoneNumber);
	}
	public WebElement getResetLogin() 
	{
		return driver.findElement(resetLogin);
	}
	public WebElement getResetMessage() 
	{
		return driver.findElement(resetMessage);
	}
	public WebElement getGotoLogin() 
	{
		return driver.findElement(gotoLogin);
	}
	public WebElement getName() 
	{
		return driver.findElement(name);
	}
	public WebElement getPass() 
	{
		return driver.findElement(pass);
	}
	public WebElement getRemindUserName() 
	{
		return driver.findElement(remindUserName);
	}
	
	public WebElement getSignI() 
	{
		return driver.findElement(sign);
	}
	
	public WebElement getSuccesMessage() 
	{
		return driver.findElement(succesMessage);
	}
	
	public WebElement getFirstMessage() 
	{
		return driver.findElement(firstMessage);
	}
	public WebElement getLogOut()
	{
		return driver.findElement(logOut);
	}	
	public WebElement getForgotPWDParialLT()
	{
		return driver.findElement(forgotPWDParialLT);
	}
	
}
