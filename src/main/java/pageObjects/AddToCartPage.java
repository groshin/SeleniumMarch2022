package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage {
	public WebDriver driver;
	public AddToCartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By products=By.cssSelector("h4.product-name");
	private By addToCart=By.xpath("//div[@class='product-action']/button");
	
	private By cart=By.cssSelector("img[alt='Cart']");
	private By proceedToCheckOut=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	private By promoCode=By.cssSelector("input.promoCode");
	private By applyButton=By.cssSelector("button.promoBtn");
	private By promoInfo=By.cssSelector("span.promoInfo");
	
	
	public List<WebElement> getProducts() 
	{
		return driver.findElements(products);
	}
	public List<WebElement> getAddToCart() 
	{
		return driver.findElements(addToCart);
	}
	
	public WebElement getCart() 
	{
		return driver.findElement(cart);
	}
	public WebElement getProceedToCheckOut() 
	{
		return driver.findElement(proceedToCheckOut);
	}
	public WebElement getPromoCode() 
	{
		return driver.findElement(promoCode);
	}
	public WebElement getApplyButton() 
	{
		return driver.findElement(applyButton);
	}
	public WebElement getPromoInfo()
	{
		return driver.findElement(promoInfo);
	}
	public By getPromoCodeWait()
	{
		return promoCode;
	}
	public By getPromoInfoWait()
	{
		return promoInfo;
	}
}
