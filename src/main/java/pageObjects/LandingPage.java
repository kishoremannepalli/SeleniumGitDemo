package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {

	
	public WebDriver driver;
	
	
	/*@FindBy(xpath="//button[contains(text(),'NO THANKS')]")
	WebElement cancel;
	
	@FindBy(css=("a[href*='sign in']"))
	WebElement signin;*/
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	By cancel=By.xpath("//button[contains(text(),'NO THANKS')]");
	@FindBy(xpath="//span[contains(text(),'Login')]")
			WebElement login;
	@FindBy(tagName="h2")
	WebElement title;
	@FindBy(xpath="/html[1]/body[1]/header[1]/div[2]")
	WebElement navbar;
	

	By popup=By.xpath("//button[contains(text(),'NO THANKS')]");

	
	public List<WebElement> getPopupsize()
	{
		return driver.findElements(popup);
	}
	
	public WebElement getPopup() {
		return driver.findElement(popup);
	}
	public WebElement login()
	{
		return login;
	}
	public Actions cancelPopUp() {
		// TODO Auto-generated method stub
		Actions a=new Actions(driver);
		a.sendKeys(Keys.CANCEL);
		return null;
	}
	public WebElement getTitle()
	{
	return title;
	}
	
	
	
	public WebElement navigationBar()
	{
		return navbar;
	}
	
}
