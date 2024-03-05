package CommanUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class listenerImplimentation implements ITestListener{
	
	ExtentReports reports;
	public WebDriver driver;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName()	;	
		
		//Add the message in report.
		Reporter.log(methodName+"TestScrip execution is started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
        String methodName = result.getMethod().getMethodName()	;
        
      //Add the message in report.
	  //Reporter.log(methodName+"TestScrip execution is passed",true);
        
        //ExtentTest test = new ExtentTest();
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName()	;	
		
		//Add the message in report.
		Reporter.log( methodName+"TestScrip execution is failed.  "+message,true);
		
		WebDriverUtil wutil = new WebDriverUtil();
		try {
			wutil.ScreenShot(driver, "Contacts");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName()	;	
		
		//Add the message in report.
		Reporter.log( methodName+"TestScrip execution is skipped",true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//String methodName = result.getMethod().getMethodName()	;	
		//Reporter.log( methodName+"To start the TestScrip execution",true);
		//Reporter.log("To start the TestScrip execution",true);
		
		javaUtil jutil = new javaUtil();
		
		//use ExtentSparkReporter class just to configure Extent report.
		ExtentSparkReporter reporter = new	ExtentSparkReporter("./extentreport/report"+jutil.getRandomNumber()+	".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("OrganizationTest");
		
		//Create the object of ExtentReports class.it is use to generate the report.
		 reports = new ExtentReports();
		
		//use to attach/add the configurations to extent report
		reports.attachReporter(reporter);
		
		//use to add extra information like Os, browser version,browser name, Author name ,etc.
		reports.setSystemInfo("OS", "Window");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("ChromeVersion", "121");
		reports.setSystemInfo("Author", "Vedika");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//String methodName = result.getMethod().getMethodName()	;	
		//Reporter.log( methodName+"TestScrip execution is finished",true);
		//Reporter.log("TestScrip execution is finished",true);
		reports.flush();
		
	}
	

}
