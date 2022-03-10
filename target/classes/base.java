package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
public WebDriver driver;	
public Properties prop;	
public WebDriver initializeDriver() throws IOException
{
	prop=new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
	prop.load(fis);	
	//mvn test -Dbrowser=chrome
	//String browserName=System.getProperty("browser");//getting from maven. It will go maven and check
	String browserName=prop.getProperty("browser");//getting from data.properties
	System.out.println(browserName);
	String downloadPath=System.getProperty("user.dir"+"\\downloads");//1-file upload and download -autoIT
	if(browserName.contains("chrome"))
	{		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();//2
		chromePrefs.put("profile.default_content_settings.popups", 0);//3
		chromePrefs.put("download.default_directory", downloadPath);//4
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);//5
		
		/*//handling ssl certifications
		//options.setAcceptInsecureCerts(true);
		//block popup window
		//options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));*/
		if(browserName.contains("headless"))
		{
		  options.addArguments("--headless");
		}
		driver=new ChromeDriver(options);
	}
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	else if(browserName.equals("edge"))
	{
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\msedgedriver.exe");
		driver=new EdgeDriver();			
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;
}
public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source, new File(destinationFile));  
	return destinationFile;		
}


}
