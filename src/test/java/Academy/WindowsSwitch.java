package Academy;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class WindowsSwitch extends Base {

	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getSimpleName());
	@BeforeTest
	public void initialize() throws IOException {
		driver=intializeDriver();
		log.info("driver intialized");
	}

	@Test()
		public void windowSwitch() throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			
			//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver84\\chromedriver.exe");
			
			//WebDriver driver = new ChromeDriver();
		driver.get(prop.getProperty("url1"));
			driver.findElement(By.xpath("//span[contains(text(),'Crews Manual')]")).click();
			Set<String> ids = driver.getWindowHandles();
			Iterator<String> it = ids.iterator();

			String parentId = it.next();
			String childId = it.next();
			driver.switchTo().window(childId);

			driver.findElement(By.xpath("//span[contains(text(),'Search by Keyword')]")).click();
			WebElement search = driver.findElement(By.cssSelector("input#tbSearch"));
			Actions a = new Actions(driver);
			a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("sequence").sendKeys(Keys.ENTER).perform();

			// search.sendKeys("sequence");
			// driver.findElement(By.xpath("//input[@id='btnSearch']")).click();

			Set<String> abc = driver.getWindowHandles();// To go to new window opened by child window.
			int j=abc.size();
			Iterator<String> it1 = abc.iterator();
			
			int k=0;
			while (it1.hasNext()) {
				driver.switchTo().window(it1.next());

				System.out.println(driver.getTitle());
				k++;
				if(j==k)
				{
				
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[4]/table[1]/tbody[1]/tr[74]/td[3]/a[1]")).click();
				
				}
			
				
				
			}
			
			//second option to use while loop.
			
			/*while (it1.hasNext()) {
				driver.switchTo().window(it1.next());

				System.out.println(driver.getTitle());
				
				
				}
			driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[4]/table[1]/tbody[1]/tr[74]/td[3]/a[1]")).click();*/
		
		
		}

	@AfterTest
	public void close()
	{
		driver.quit();
		
	}
	
	
	
}
