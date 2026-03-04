package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DriverFactory;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_account_login()
	{
		try
		{
			logger.info("***** TC002_LoginTest Started *****");
			
			HomePage hp= new HomePage(DriverFactory.getDriver());
			logger.info("Clicking myAccount link..");
			hp.clickMyAccount();
			logger.info("Clicking login link to open login page..");
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(DriverFactory.getDriver());
			logger.info("Entering email..");
			lp.enterEmail(prop.getProperty("email"));
			logger.info("Entering password..");
			lp.enterPass(prop.getProperty("password"));
			logger.info("Clicking login button..");
			lp.clickLogin();
			
			MyAccountPage my_act=new MyAccountPage(DriverFactory.getDriver());
			
			logger.info("Validating my Account page opened..");
			
			if(my_act.isMyAccountPageExist())
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test Failed..");
				logger.debug("Debug log..");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** TC002_LoginTest Finished *****");
	}
}
