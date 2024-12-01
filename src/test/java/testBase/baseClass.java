package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;  //log4j
import org.apache.logging.log4j.Logger;     //log4j

public class baseClass {
	
public static WebDriver driver;	
public Logger logger;

public Properties p;
	@BeforeClass(groups= {"sanity","regression","master","datadriven"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws InterruptedException, IOException
	{
		
		FileReader file=new FileReader("./src//test/resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver=new ChromeDriver();break;
		case "edge" : driver=new EdgeDriver();break;
		case "firefox" : driver=new FirefoxDriver();break;
		default: System.out.println("Invalid Browser name");return;
		}
		
		
		
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get(p.getProperty("app"));
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
	}
	@AfterClass(groups= {"sanity","regression","master","datadriven"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomeString()
	{
		
		String rtm=RandomStringUtils.randomAlphabetic(5);
		return rtm;
		
	}
	
	public String randomeNumber()
	{
		String rm=RandomStringUtils.randomNumeric(5);
		return rm;
		
	}
	public String captureScreen(String tname) throws IOException 
	{
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
	
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
	

}