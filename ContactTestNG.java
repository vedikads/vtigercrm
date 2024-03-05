package vtigerCRM1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommanUtils.WebDriverUtil;
import CommanUtils.baseClass;
import CommanUtils.excelUtil;
import CommanUtils.javaUtil;
import CommanUtils.propertyUtil;

public class ContactTestNG extends baseClass{
	
	 WebDriver driver;
	 
	
	propertyUtil putil=new propertyUtil();
	WebDriverUtil wutil=new WebDriverUtil();
	excelUtil eutil=new excelUtil();
	javaUtil jutil=new javaUtil();
	
	
	
	@Test
	public void contact() throws IOException, InterruptedException {
		// WebDriver driver=new ChromeDriver();
		//this.driver= new ChromeDriver();
		// wutil.maximize(driver);
		// wutil.implicitwait(driver);
		// String URL = putil.getDataFromPropertyFile("Url");
		// String USERNAME = putil.getDataFromPropertyFile("Username");
		// String PASSWORD = putil.getDataFromPropertyFile("Password");
		String FNAME =eutil.getDataFromExcel("Contact", 0, 1);
		String LNAME =eutil.getDataFromExcel("Contact", 1, 1);
	    String GROUP =eutil.getDataFromExcel("Contact", 2, 1);
	    String ORGNAME =eutil.getDataFromExcel("Contact", 3, 1);
		
	     
		// driver.get(URL);
		// driver.findElement(By.name("user_name")).sendKeys(USERNAME );
		// driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
		
		//To click on Contacts.
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//To click on + icon.
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		//To click on first name.
		 driver.findElement(By.name("firstname")).sendKeys(FNAME);
		 
		 //To click on last name.
		 driver.findElement(By.name("lastname")).sendKeys(LNAME);
		 
		 
		 //TO FAIL THE TEST SCRIPT
		//String actualurl = driver.getCurrentUrl();
		//String expectedurl = "http://localhost:8888/pune/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
		//Assert.assertEquals(actualurl, expectedurl);
		 
		 
		//To click on AssignedTo group or click on group radio button.
		 driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		 
		 
		 //To select on drop down.
		 WebElement dropdown=driver.findElement(By.name("assigned_group_id"));
		 wutil.handledropdown(dropdown, GROUP);
		 
		 //To click on organization name(+) button tf.
		 driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		 
		 
		 //Transferring the control parent url to parent url.  .
		wutil.switchTO(driver,"http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		 
		
		//To enter organization name  in searchtf.
		 driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		 
		 //To click on search now button.
		driver.findElement(By.name("search")).click();
		
		
		//To click on organization name[infosys]
		 driver.findElement(By.xpath("//a[text()='Infosys388']")).click();
		 
		 //To transfer control from child window to parent window.
		 wutil.switchTO(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		 
		//To click on save button
		 driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		 
		 //To take Screenshot.
		 //Thread.sleep(2000);
		 // wdutil.ScreenShot(driver,"Contact" );
		 
		
		Thread.sleep(2000);
		//Mousehover on image
		//WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		//wutil.mousehover(driver, image);
		
		//Click on Signout
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
		 
		
		
		 
	}

}