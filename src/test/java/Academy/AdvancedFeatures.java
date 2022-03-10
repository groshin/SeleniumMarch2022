package Academy;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.emulation.Emulation;
import org.testng.annotations.Test;

import Resources.base;
public class AdvancedFeatures extends base{
	public WebDriver driver;
	//public static Logger log=LogManager.getLogger(base.class.getName());
	
	@Test
	public void initialize() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		devTools.send(Emulation.setDeviceMetricsOverride(600,1000,50,true,Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));
		driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();
		Thread.sleep(3000);
		//------------------------
		//execute the CDP command to construct the own CDP functions		
	}
	
	@Test
	public void BasicAuthentication() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		ChromeDriver driver=new ChromeDriver();
		
		Predicate<URI> uriPredicate=uri -> uri.getHost().contains("httpbin.org");
		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo", "bar"));
		Thread.sleep(2000);
		driver.get("http://httpbin.org/basic-auth/foo/bar");
		
		
	}
}
