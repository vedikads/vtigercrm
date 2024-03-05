package CommanUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class baseClass {
  	

		WebDriver driver = new ChromeDriver();	
		propertyUtil putil = new propertyUtil();
		WebDriverUtil wutil = new WebDriverUtil();
		
		@BeforeSuite
		public void BS() 
		{
		     System.out.println("Connect to Data Base");
		}
		
		@BeforeClass
	   public void BC() throws IOException 
		{
		//@Beforeclass annotation is used to launch Application.
			String URL = putil.getDataFromPropertyFile("Url");
			wutil.maximize(driver);
			wutil.implicitwait(driver);
			driver.get(URL);
	     }
		
		@BeforeMethod
	   public void BM() throws IOException 
		{
			//@Beforemethod is used to login to the application
			String USERNAME =putil.getDataFromPropertyFile("Username");
			String PASSWORD = putil.getDataFromPropertyFile("Password");
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
		}
		
		@AfterMethod
	   public void AM() throws InterruptedException 
		{
			//@AfterMethod is used to logout from the application
			Thread.sleep(2000);
			WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
			wutil.mouseHover(driver, image);
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		}
		
		@AfterClass
	  public void AC() 
		{
			//@Afterclass is used to close the browser
			// WebDriver driver;
			 driver.quit();	
		}
		
		@AfterSuite
	   public void AS() {
			System.out.println("Disconnect From Data Base");
		}
			
		

	}
	
