package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

import resources.Base;

public class ValidateTitle extends Base{
	
	public WebDriver driver;
public static Logger log=LogManager.getLogger(Base.class.getSimpleName());

	@BeforeTest
	public void initialize() throws IOException {
		driver=intializeDriver();
		log.info("driver intialized");
	}
	
	@Test()
	public void webElementsCheck() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Url got invoked");
		log.info("Navigated to Home");
		//driver.get(prop.getProperty("url"));
				
		LandingPage lp=new LandingPage(driver);
		lp.cancelPopUp();	
		//We are making this step failed intentionally to capture the failure with on test failure method from TESTNG
		Assert.assertEquals(lp.getTitle().getText(),"FEATURED1 COURSES");
		Assert.assertTrue(lp.navigationBar().isDisplayed());
	
		lp.login().click();
		log.info("successfull");
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
