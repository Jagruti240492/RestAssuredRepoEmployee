package com.EmplyeesAPIUtilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter	
{
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{
		//specifying the location of HTML report
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/MyReports.html");
		
		htmlreporter.config().setDocumentTitle("Automation Report");//title of the report
		
		htmlreporter.config().setReportName("RestAPI Testing Report"); //name of the report
		
		htmlreporter.config().setTheme(Theme.DARK); //setting the theme
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Project name", "Employee Database API");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "jagruti");	
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName()); //create new entry in the report
		test.log(Status.PASS, "Test Case passed is "+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName()); //create new entry in the report
		test.log(Status.FAIL, "Test Case Failed is "+result.getName()); //add name in extent report
		test.log(Status.FAIL, "Test Case Failed is "+result.getThrowable()); //add error/exception in an extent report
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName()); //create new entry in the report
		test.log(Status.SKIP, "Test Case Skipped is "+result.getName()); 
	}
	
	public void onFinish(ITestResult result)
	{
		extent.flush();
	}
	
	
}
