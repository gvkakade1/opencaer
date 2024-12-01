package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accountRegi extends basePAge {
	
	public accountRegi(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emai;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement ipass;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement Repass;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement subsc;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement iagree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement conti;

	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msg;
	
	
	
	
	public void getfname(String fn)
	{
		fname.sendKeys(fn);
		
	}
	public void getlname(String ln)
	{
		lname.sendKeys(ln);
	}
	
	public void getemail(String ema)
	{
		emai.sendKeys(ema);
		
	}

	public void getphone(String ph)
	{
		phone.sendKeys(ph);
	}
	
	public void passw(String pas)
	{
		ipass.sendKeys(pas);
	}
	
	public void repassw(String repas)
	{
		Repass.sendKeys(repas);
	}
	
	
	public void newslett()
	{
		subsc.click();
	}
	public void policy()
	{
		iagree.click();
	}
	
	public void continuebt()
	{
		conti.click();
	}
	
	public String Confirm()
	{
		try
		{
		return(msg.getText());
		}catch(Exception e)
		{
			return(e.getMessage());
		}
		}
	
}
