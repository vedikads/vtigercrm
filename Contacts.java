package vtigerCRM1;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommanUtils.WebDriverUtil;
import CommanUtils.excelUtil;
import CommanUtils.listenerImplimentation;
import CommanUtils.propertyUtil;


@Listeners(listenerImplimentation.class)
public class Contacts {
	propertyUtil  putil = new propertyUtil();
	WebDriverUtil wdutil =new WebDriverUtil();
    excelUtil eutil = new  excelUtil();

	
	@Test
	public void ContactTest() throws IOException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		//To maximize the screen.
		wdutil.maximize(driver);
		
		//To apply implicit wait.
		wdutil.implicitwait(driver);
		
		//To read data from Property File.
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		//To read the data from excel Sheet
		String FNAME =eutil.getDataFromExcel("Contact", 0, 1);
		String LNAME =eutil.getDataFromExcel("Contact", 1, 1);
	    String GROUP =eutil.getDataFromExcel("Contact", 2, 1);
	    String ORGNAME =eutil.getDataFromExcel("Contact", 3, 1);
		
		//To launch , pass the user name & password in login field.
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//To click on Contacts.
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//To click on + icon.
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		//To click on first name.
		 driver.findElement(By.name("firstname")).sendKeys(FNAME);
		 
		 //To click on last name.
		 driver.findElement(By.name("lastname")).sendKeys(LNAME);
		 	 
		 //To fail the testScript.
	 
		 String actualurl = driver.getCurrentUrl();
		 String expectedurl = " http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab";
		 Assert.assertEquals(actualurl, expectedurl);
		 
		//To click on AssignedTo group or click on group radio button.
		 driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		 
		 
		 //To select on drop down.
		 WebElement dropdown=driver.findElement(By.name("assigned_group_id"));
		 wdutil.handledropdown(dropdown, GROUP);
		 
		 //To click on organization name(+) button tf.
		 driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		 
		 
		 //Transferring the control parent url to parent url.  .
		wdutil.switchTO(driver,"http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		 
		
		//To enter organization name  in searchtf.
		 driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		 
		 //To click on search now button.
		driver.findElement(By.name("search")).click();
		
		
		//To click on organization name[infosys]
		 driver.findElement(By.xpath("//a[text()='Infosys388']")).click();
		 
		 //To transfer control from child window to parent window.
		 wdutil.switchTO(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		 
		//To click on save button
		 driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		 
		 //To take Screenshot.
		 //Thread.sleep(2000);
		 // wdutil.ScreenShot(driver,"Contact" );
		 
		 
		 Thread.sleep(2000);
		 //To mouse hover on img.
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wdutil.mouseHover(driver, img);
		 
		 //To click on Sign out.
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		 
}

}
