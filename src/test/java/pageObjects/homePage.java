package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePAge {
	
	//constructor
	
	public homePage(WebDriver driver)
	{
		super(driver);
	}
	
	

@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement linkmy;
@FindBy(xpath="//a[normalize-space()='Register']")
WebElement accReg;

@FindBy(xpath="//a[normalize-space()='Login']")
WebElement logi;



	
	//locators
	
	//action class
	
public void clickmyaccount()
{
linkmy.click();	
}
public void clickRegister()
{
accReg.click();	
}

public void clicklogin()
{
logi.click();	
}


}
