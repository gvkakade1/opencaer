package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.accountRegi;
import pageObjects.homePage;
import testBase.baseClass;

public class tc001_accountRegistrationTest extends baseClass{

	
	
	@Test(groups={"regression","master"})
	public void TestAccountRegi()
	{
		
		logger.info("<----Starting Test tc001_accountRegistrationTest----->");
		
		try {
	homePage hm=new homePage(driver);
	hm.clickmyaccount();
	logger.info("<----Clicked on My Account Link----->");

	hm.clickRegister();
	
	logger.info("<----Clicked on My Register Link----->");
	
	accountRegi acr=new accountRegi(driver);
	
	logger.info("<----Providing customer info----->");
		acr.getfname(randomeString().toUpperCase());
		acr.getlname(randomeString().toUpperCase());
		acr.getemail(randomeString()+"@gmail.com");
		acr.getphone(randomeNumber());
		acr.passw("Abc@123");
		acr.repassw("Abc@123");
		acr.newslett();
		acr.policy();
		acr.continuebt();
		
		logger.info("<----Validating expected message----->");
	String cm=acr.Confirm();
	Assert.assertEquals(cm, "Your Account Has Been Created!");
		
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("DEbug Log");
			Assert.fail();
		}
		
		logger.info("<----Testing is Finished------>");
		}
	
	
	
	
	
	
	
}
