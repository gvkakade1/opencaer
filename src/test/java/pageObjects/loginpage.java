package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends basePAge{

	public loginpage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement iemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement ipass;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement clogin;
	

	public void setEmail(String em)
	{
		iemail.sendKeys(em);
		
	}
	
	public void setPass(String pa)
	{
		ipass.sendKeys(pa);
	}

	public void logclick()
	{
		clogin.click();
	}

	
	

}

