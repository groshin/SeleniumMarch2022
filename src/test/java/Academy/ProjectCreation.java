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
import pageObjects.LandingPages;
import pageObjects.LoginPages;
import pageObjects.administrationPage;
import pageObjects.gcmsAdministrationPage;



public class ProjectCreation extends base {
	public WebDriver driver;	
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest	
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
		
	}

	@Test(dataProvider="getData")
	
	public void loginToTheApplication(String Username, String Password) throws IOException, InterruptedException
	{	
		driver.get(prop.getProperty("url"));
		
		LoginPages lp=new LoginPages(driver);
			
		//LoginPage lp=new LoginPage(driver);
		lp.getUserName().sendKeys(Username);
		lp.getPassword().sendKeys(Password);		
		lp.getLogin().click();
	}
	
	@Test
	public void navigateToCreateProjectPage()
	{
		LandingPages lp=new LandingPages(driver);
		administrationPage ap=lp.getAdministrationPage();
		ap.getGCMSAdministration().click();
		gcmsAdministrationPage gcms=new gcmsAdministrationPage(driver);
		gcms.getCreateProject().click();
	}
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	@DataProvider	
	public Object[][] getData()
	{
		Object[][] data=new Object[1][2];
		data[0][0]="roshingeorge@ust-kpmg.com";
		data[0][1]="Password123*";
		
		return data;
	}	
}
