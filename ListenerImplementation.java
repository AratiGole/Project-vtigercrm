package vtigercrm;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commonUtils.JavaUtil;

public class ListenerImplementation implements ITestListener{
	ExtentReports reports;
	
	public void onTestStart(ITestResult result) {
		//System.out.println("Testscript execution is started");
//		Reporter.log("Testscript executin is started");
	String methodName=result.getMethod().getMethodName();
	Reporter.log(methodName+"Testscript execution is stareted",true);
	
		
		
		
		}
	
	public void onTestSuccess(ITestResult result) {
		//System.out.println("Testscript execution is Passed");
	    String methodName=result.getMethod().getMethodName();
	    
	    // Add massage in report
	  //  Reporter.log(methodName+"Testscript execution is Passed",true);
		
	    
	}
	public void onTestFailure(ITestResult  result) {
		//System.out.println("Testscript execution is failed");
		String message=result.getThrowable().toString();
		String methodName= result.getMethod().getMethodName();
		// Add massage in report
		Reporter.log(methodName+"Testscript execution is failed"+message, true);
		
		
		
		
		
	}
	
	public void onTestSkipped(ITestResult  result) {
		//System.out.println("Testscript execution is skipped");
		String methodName= result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is skipped", true);
		
	}
	
	public void  onTestFailedButWithSuccessPercentage(ITestResult result) {
		
	}
	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	public void onstart(ITestContext context) {
		//System.out.println("To start the execution ");
		//Reporter.log("To start the execution ",true);
		
		//*****use of ExtentSparkerReports class just to configure Extent report
		
				// call getRandomNumber() from class JavaUtils  class from package commonUtils
				
				JavaUtil jUtil= new JavaUtil();
				ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report"+jUtil.getRandomNumber()+".html");
				reporter.config().setDocumentTitle("vtigercrm");
				reporter.config().setTheme(Theme.STANDARD);
				reporter.config().setReportName("OrganizationTest");
				
				
				// use ExtentReports to generate extentreport 
				reports=new  ExtentReports();
				
				// use to add extra information like os, broweser version , browser name, Author name etc.
				reports.setSystemInfo("OS", "window");
				reports.setSystemInfo("Browser", "Chrome");
				reports.setSystemInfo("ChromeVersion", "12");
				reports.setSystemInfo("Author", "Arati");
				
				
		
	}
	
	public void onFinish(ITestContext  context) {
		//System.out.println("To finish the execution");
		//Reporter.log("To finish the execution,true");
		reports.flush();
	}

}
