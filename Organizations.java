package vtigerCRM1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommanUtils.WebDriverUtil;
import CommanUtils.excelUtil;
import CommanUtils.javaUtil;
import CommanUtils.listenerImplimentation;
import CommanUtils.propertyUtil;

@Listeners(listenerImplimentation.class)
public class Organizations {
	propertyUtil  putil = new propertyUtil();
	WebDriverUtil wdutil =new WebDriverUtil();
    excelUtil eutil = new  excelUtil();
	javaUtil jutil = new javaUtil();
	@Test
	public void OrganizationTest() throws IOException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		wdutil.maximize(driver);
		wdutil.implicitwait(driver);
		
		//To read data from Property File.
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		//to read the data from excel Sheet
		String ORGANAME =eutil.getDataFromExcel("Oraganization", 0, 1);
		String GROUP =eutil.getDataFromExcel("Oraganization", 1, 1);
		
		
		//to launch , pass the user name & password in login field.
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//To click on organization.
	    driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	   
	     //To click on  Create organization...[!]
		 driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
		 //To click on organization name.
		 driver.findElement(By.name("accountname")).sendKeys(ORGANAME+jutil.getRandomNumber());
		 
		 //To click on AssignedTo group.
		 driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		 
		 //In the drop down Select group
		 WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		 wdutil.handledropdown(dropdown, GROUP);
		 
		 //To click on save button
		 driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		 
		 //To take Screenshot.
		 Thread.sleep(2000);
		 wdutil.ScreenShot(driver,"Organization" );
		 
		 
		 Thread.sleep(2000);
		 //to mouse hover on img.
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wdutil.mouseHover(driver, img);
		 
		 //to click on Sign out.
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
}

}
