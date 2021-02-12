package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password) throws IOException
	{
		//LandingPage
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getlogin().click();
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();
		
	}	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	@DataProvider	
	public Object[][] getData()
	{
			//Row stand for how many different data type test should run
			//column stand for how many values per each test
			Object[][] data = new Object[2][2];
			//0th row
			data[0][0] = "nonrestricteduser@gmail.com";
			data[0][1] = "123456";
		
			//1st row
			data[1][0] = "restricteduser@gmail.com";
			data[1][1] = "456789";
			
			return data;		
					
	}

}
