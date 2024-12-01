package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.baseClass;

public class ExtenReportManger implements ITestListener  {
	
	
	    public ExtentSparkReporter spartreprt;
		public ExtentReports extentR;
		public ExtentTest testR;
		
		String repName;
		public void onStart(ITestContext context) 
		{
			/*SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			Date dt=new Date();
			String currentdatetimestamp=df.format(dt);
			*/
			
			String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			repName="Test-Report-"+timeStamp+".html";  
			
			//set look and fill 
			spartreprt=new ExtentSparkReporter(".\\reports\\"+repName);
			//location of report
			
			spartreprt.config().setDocumentTitle("OpenCart Automation Report");
			spartreprt.config().setReportName("Open Cart Fucntional Testing");
			spartreprt.config().setTheme(Theme.DARK);
			
			
			//populate the common info
			extentR=new ExtentReports();
			extentR.attachReporter(spartreprt);
			
			extentR.setSystemInfo("Computer Name", "Local host");
			extentR.setSystemInfo("Envirnoment", "QA");
			extentR.setSystemInfo("Project", "CFMS");
			extentR.setSystemInfo("Portal", "PArtner Portal");
			extentR.setSystemInfo("Tester", "Ganesh Kakade");
			extentR.setSystemInfo("Browser", "Chrome");
			extentR.setSystemInfo("OS", "Window 10");
			
			//ITestContext testContext;
			//used to include the groups name in the report
			List<String> includedGroups=context.getCurrentXmlTest().getIncludedGroups();
			if(!includedGroups.isEmpty())
			{
				extentR.setSystemInfo("Groups", includedGroups.toString());
			}
		
		
		}
		
		
		public void onTestSuccess(ITestResult result) 
		{

			testR=extentR.createTest(result.getTestClass().getName());//Create new entry in the report
		
			testR.assignCategory(result.getMethod().getGroups());
			
			
			testR.log(Status.PASS, result.getName()+"Got Sucessfully Executed");  //update status pas/fail
			
			
		  }
		public void onTestFailure(ITestResult result)
		{
		    
			testR=extentR.createTest(result.getTestClass().getName());
			testR.assignCategory(result.getMethod().getGroups());
			
			testR.log(Status.FAIL, "Test Case Failed is"+result.getName());
			testR.log(Status.FAIL, "Test Case Failed cause is"+result.getThrowable().getMessage());
		
		
			
			try
			{
				String imgpath=new baseClass().captureScreen(result.getName());
				testR.addScreenCaptureFromPath(imgpath);
				
			}catch(IOException e)
			{
				e.printStackTrace();
				
			}			
		  }

		public void onTestSkipped(ITestResult result) 
		{
			testR=extentR.createTest(result.getClass().getName());
			testR.assignCategory(result.getMethod().getGroups());
			
			
			testR.log(Status.SKIP, "Test Case Skipped is"+result.getName());
			testR.log(Status.INFO, result.getThrowable().getMessage());
		}

		
		 
		public void onFinish(ITestContext context) {
				
			    extentR.flush();
			
			    String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
			    File extentReport=new File(pathOfExtentReport);
		try
		{
			    Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		
		}
		
		
		
	}

	
	


