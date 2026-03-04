package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.DriverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	
	
	public Logger logger;     //log4j2
	public Properties prop;   //config.properties
	
	
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		FileInputStream file= new FileInputStream(".//src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);
		String gridURL=prop.getProperty("gridURL");
		String env_execution=prop.getProperty("env_execution");
		
		logger= LogManager.getLogger(this.getClass()); //log4j2
		
		
		
		DriverFactory.initDriver(br,gridURL,env_execution,os);

	    DriverFactory.getDriver().get(prop.getProperty("appURL"));
	    DriverFactory.getDriver().manage().deleteAllCookies();
	    DriverFactory.getDriver().manage().window().maximize();
	    DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearOff()
	{
		DriverFactory.quitDriver();
	}
	
	public String randomName()
	{
		String gen_Name = RandomStringUtils.randomAlphabetic(5);
		return gen_Name;
	}
	
	public String randomPhone()
	{
		String gen_Phone = RandomStringUtils.randomNumeric(10);
		return gen_Phone;
	}
	
	public String randomAlphaNumeric()
	{
		String pass1 = RandomStringUtils.randomAlphabetic(5);
		String pass2 = RandomStringUtils.randomNumeric(3);
		return (pass1+pass2);
	}
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)DriverFactory.getDriver();
		File SourceFile= takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" +timeStamp;
		File targetFile= new File(targetFilePath);
		
		SourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
	
	

}
