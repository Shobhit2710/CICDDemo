package stepE2EDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class stepDefination extends base{
	public WebDriver driver;
	LoginPage lp;
    @Given("^Intialize the browser with chrome$")
    public void intialize_the_browser_with_chrome() throws Throwable {
    	
    	driver = initializeDriver();
    }
    
    @And("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
        driver.get(strArg1);
    }

    @And("^Click on Login link in home page to land on secure sign in page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
    	LandingPage l = new LandingPage(driver);
		l.getlogin().click();
    }
    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String strArg1, String strArg2) throws Throwable {
		lp = new LoginPage(driver);
		lp.getEmail().sendKeys(strArg1);
		lp.getPassword().sendKeys(strArg2);
		lp.getLogin().click();
    }

    @Then("^Verify that user is not succesfully logged in$")
    public void verify_that_user_is_not_succesfully_logged_in() throws Throwable {
    	lp.getText();
}
}