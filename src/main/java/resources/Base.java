package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {
	
	public static Logger log=LogManager.getLogger(Base.class.getSimpleName());

public WebDriver driver;
public Properties prop;
	public WebDriver intializeDriver() throws IOException {
	 prop= new Properties();
	FileInputStream fis= new FileInputStream("C:\\Users\\841233\\Selenium\\E2EProject\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String browsername=prop.getProperty("browser");
//	System.out.println(browsername);
	log.info(browsername);
	
	 String url1=prop.getProperty("url");
//	System.out.println(url1);
	log.info(url1);
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver84\\chromedriver.exe");
		 driver= new ChromeDriver();
		
		
			
	}
	else if(browsername.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.27.0\\geckodriver.exe");
		 driver = new FirefoxDriver();
	}
	else if(browsername.equals("IE"))
	{
		
	}
	
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
	return driver;
}
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException 
	{
		TakesScreenshot tc= (TakesScreenshot) driver;
		File source=tc.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		System.out.println(destinationFile);
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}