package Academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import junit.framework.Assert;
import pageObjects.alertsPage;
import pageObjects.locatorsPage;

public class Locators extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "getLoginDetails")
	public void validateLocators(String name, String errorMessage, String email, String phoneNumber, String resetPwd,
			String pass, String successMess, String message, String last) throws InterruptedException {
		driver.get(prop.getProperty("url4"));

		locatorsPage lp = new locatorsPage(driver);
		lp.getUserName().sendKeys(name);
		lp.getPassword().sendKeys(name);
		lp.getSignIn().click();
		Assert.assertEquals(errorMessage, lp.getErrorMessageInvalidlogin().getText());
		lp.getForgotPassword().click();

		Thread.sleep(1000l);
		lp.getForgotName().sendKeys(name);
		lp.getEmail().sendKeys(name);
		lp.getEmailXp().clear();
		lp.getEmailCs().sendKeys(email);
		lp.getPhoneNumber().sendKeys(phoneNumber);
		Thread.sleep(1000l);
		lp.getResetLogin().click();
		Assert.assertEquals(resetPwd, lp.getResetMessage().getText());
		String newPassword = getRestPassword(driver, lp.getResetMessage().getText());
		Assert.assertEquals(pass, newPassword);

		Thread.sleep(1000l);
		lp.getGotoLogin().click();
		Thread.sleep(1000l);
		lp.getName().sendKeys(name);
		lp.getPass().sendKeys(newPassword);
		lp.getRemindUserName().click();
		lp.getSignI().click();

		Thread.sleep(2000l);
		Assert.assertEquals(successMess, lp.getSuccesMessage().getText());
		Assert.assertEquals(message.concat(name).concat(last), lp.getFirstMessage().getText());
		Thread.sleep(1000);
		lp.getLogOut().click();
		Thread.sleep(1000l);
		lp.getForgotPWDParialLT().click();
		Thread.sleep(1000l);
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	public String getRestPassword(WebDriver driver, String passwordText) {
		String[] getPassword = passwordText.split("'");
		String password = getPassword[1].split("'")[0];
		return password;
	}

	@DataProvider()

	public Object[][] getLoginDetails() {
		Object[][] data = new Object[1][9];
		data[0][0] = "Rahul";
		data[0][1] = "* Incorrect username or password";
		data[0][2] = "john@abc.com";
		data[0][3] = "9400299467";
		data[0][4] = "Please use temporary password 'rahulshettyacademy' to Login.";
		data[0][5] = "rahulshettyacademy";
		data[0][6] = "You are successfully logged in.";
		data[0][7] = "Hello ";
		data[0][8] = ",";

		return data;
	}

}
