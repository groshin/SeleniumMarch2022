package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends base {
	public WebDriver driver;	
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest	
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		
	}

	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username, String Password, String text) throws IOException, InterruptedException
	{	
		driver.get(prop.getProperty("url1"));
		LandingPage l=new LandingPage(driver);
		LoginPage lp=l.getLogin();
		
		
		
		//LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);	
		
		
		log.info(text);
		
		lp.getLogin().click();
		
		ForgotPasswordPage fp=lp.forgotPassword();
		fp.getEmail().sendKeys(Username);	
		fp.sendMeIns().click();
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	@DataProvider	
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		data[0][0]="non-restricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="QA1";
		
		
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456789";
		data[1][2]="QA2";

		
		
		return data;
	}
	
	
}
