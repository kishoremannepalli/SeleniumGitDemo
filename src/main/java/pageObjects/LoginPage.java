package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='user_email']")
	WebElement userid;
	@FindBy(xpath="//input[@id='user_password']")
	WebElement password;
	@FindBy(xpath="//input[@name='commit']")
	WebElement login;
	
	
	public WebElement userId()
	{
		return userid;
		
	}
	
	public WebElement password()
	{
		return password;
		
	}
	
	public WebElement logIn()
	{
		return login;
		
	}
	
}
