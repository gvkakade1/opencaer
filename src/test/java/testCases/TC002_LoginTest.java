package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MyAccountPage;
import pageObjects.homePage;
import pageObjects.loginpage;
import testBase.baseClass;

public class TC002_LoginTest extends baseClass {


@Test(groups={"sanity","master"})
public void Login_Verify()
{
	logger.info("***** Starting TC_002 Login Test*****");
	
	try
	{
	
	//homepage
	homePage hp=new homePage(driver);   //jump to home page
	hp.clickmyaccount();
	hp.clicklogin();
	
	
	//login
	loginpage lp=new loginpage(driver);    //jump to login page and required login page 
	
	lp.setEmail(p.getProperty("email"));   // get it from config files
	lp.setPass(p.getProperty("pass"));   //get it from config file
	lp.logclick();
	
	//my account
	
	MyAccountPage myacc=new MyAccountPage(driver);
	
	boolean tar=myacc.ismyaccpageexist();
	
	Assert.assertEquals(tar, true,"Login Failed");

	//Assert.assertTrue(tar);
	
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	logger.info("***** Finished TC_002 Login Test******** ");
	
}
}
