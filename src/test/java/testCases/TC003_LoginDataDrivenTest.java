package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.DriverFactory;

public class TC003_LoginDataDrivenTest extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven")
	public void verify_loginDDT(String email,String pass,String exp)
	{
		logger.info("***** TC003_LoginDataDrivenTest Started *****");
		try
		{
		HomePage hp= new HomePage(DriverFactory.getDriver());
		logger.info("Clicking myAccount link..");
		hp.clickMyAccount();
		logger.info("Clicking login link to open login page..");
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(DriverFactory.getDriver());
		logger.info("Entering email..");
		lp.enterEmail(email);
		logger.info("Entering password..");
		lp.enterPass(pass);
		logger.info("Clicking login button..");
		lp.clickLogin();
		
		MyAccountPage my_act=new MyAccountPage(DriverFactory.getDriver());
		boolean targetPage = my_act.isMyAccountPageExist();
		
		logger.info("Validating my Account page opened..");
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				logger.info("Login using valid data passed and test passed");
				my_act.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("Login using valid data failed and test failed");
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				logger.info("Invalid or empty data so the login passed and test failed");
				my_act.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				logger.info("Invalid or empty data so the login failed and test passed");
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** TC003_LoginDataDrivenTest finished *****");
		
		
		
	}
}
