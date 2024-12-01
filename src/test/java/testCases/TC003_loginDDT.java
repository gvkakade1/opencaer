package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MyAccountPage;
import pageObjects.homePage;
import pageObjects.loginpage;
import testBase.baseClass;
import utilities.DataProviderss;

//data valid  login sucess    PASS  logout
//data valid    login unsecess   Fail
//data invalid   login sucess   Fail logout
//data invalid   login unsucess   PASS

public class TC003_loginDDT extends baseClass
{
	
	
	@Test(dataProvider="logindata",dataProviderClass=DataProviderss.class,groups="sanity")  //getting data providers from diff. class
	public void verify_loginddt(String email,String pass, String exp)
	{
		
		logger.info("***** TEsting TC003_LoginDBT******");
		
		
		try
		{
		
		//home page
		homePage hp=new homePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		
		//login page
		loginpage lp=new loginpage(driver);
		lp.setEmail(email);
		lp.setPass(pass);
		
		lp.logclick();
		
		//myaccount

		MyAccountPage macc=new MyAccountPage(driver);
		boolean tp=macc.ismyaccpageexist();
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(tp==true)
			{
				macc.clicklogout();
				Assert.assertTrue(true);
				logger.info("---Valid username and Valid PASS");
			}
			else
			{
				Assert.assertTrue(false);	
			}	
		}
		else if(exp.equalsIgnoreCase("invalid"))
		{
			if(tp==true)
			{
				macc.clicklogout();
				Assert.assertTrue(false);		
				logger.info("---InValid username OR PASS");
			}
			else
			{
				Assert.assertTrue(true);
				
			}
		
		}
		
		
		}catch(Exception e)
		{
			Assert.fail();
		}
	
}
}