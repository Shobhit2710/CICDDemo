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

public class ValidateNavigationBar extends base{
	public WebDriver driver;//this will help even if main driver is static
	public static Logger log = LogManager.getLogger(base.class.getName());
@BeforeTest
public void initialize() throws IOException
{
	driver = initializeDriver();
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}
	
@Test
public void validateNavigationBar() throws IOException
{
	//LandingPage
	LandingPage l = new LandingPage(driver);
	Assert.assertTrue(l.getNavigationBar().isDisplayed());
	log.info("Successfully navigated");
}	
	
@AfterTest
public void teardown()
{
	driver.close();
}
		
}
