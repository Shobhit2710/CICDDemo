package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base{
	public WebDriver driver; //This is for avoiding overridden of driver if we "parallel" execution in testng
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void validateTitle() throws IOException
	{

		//LandingPage
		LandingPage l = new LandingPage(driver);
		String Actual = l.getTitle().getText();
		String Expected = "FEATURED COURSES";
		Assert.assertEquals(Actual, Expected);
		log.info("Successfully validated the text message");
		
	}	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
			

}
