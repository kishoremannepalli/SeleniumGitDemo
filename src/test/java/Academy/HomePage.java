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
import resources.Base;

public class HomePage extends Base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getSimpleName());

	@BeforeTest
	public void initialize() throws IOException {
		driver=intializeDriver();
		
	}
	
	@Test(dataProvider="getData")
	public void basPageNavigation(String username,String pwd) throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
	//	driver=intializeDriver();
	
		//driver.get("http://www.qaclickacademy.com/");
				
		LandingPage lp=new LandingPage(driver);
		lp.cancelPopUp();	
		lp.login().click();
		LoginPage loginPage= new LoginPage(driver);
		loginPage.userId().sendKeys(username);
		loginPage.password().sendKeys(pwd);
		loginPage.logIn().click();
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[2][2];
		data[0][0]="Test123@gmail.com";
		data[0][1]="Test";
		data[1][0]="Test12345@gmail.com";
		data[1][1]="2345";
		
		return data;
	}
	
	
	
}
