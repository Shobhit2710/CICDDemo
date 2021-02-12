package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	//We are making them private for encapsulation
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//div[contains(@class,'text-center')]/h2");
	private By Navbar = By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul/li[8]/a");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getlogin()
	{
		return driver.findElement(signin);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavigationBar()
	{
		return driver.findElement(Navbar);		
	}

}
