package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;
import utilities.DriverFactory;

public class TC001_AccountRegistrationTest extends BaseClass{

	@Test(groups= {"Sanity","Master"})
	public void verify_account_registration()
	{
		
		try
		{
		logger.info("***** Starting TC001_AccountRegistrationTest ***** ");
		
		HomePage hp= new HomePage(DriverFactory.getDriver());
		hp.clickMyAccount();
		logger.info("clicked My Account link...");
		
		hp.clickRegister();
		logger.info("clicked Register link...");
		
		RegistrationPage rp= new RegistrationPage(DriverFactory.getDriver());
		
		logger.info("Providing the details...");
		rp.setFirstName(randomName());
		rp.setLastName(randomName());
		rp.setEmail(randomName()+"@gmail.com");
		rp.setPhone(randomPhone());
		String password = randomAlphaNumeric();
		rp.setPassword(password);
		rp.setCnfmPass(password);
		rp.confirmPrivacy();
		rp.clickContinue();
		logger.info("Clicked continue button..");
		
		logger.info("Validating expected message..");
		
		String myAccountTxt = rp.registrationCreatedText();
		
		if(myAccountTxt.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed");
			logger.debug("Debug log..");
			Assert.assertTrue(false);
		}
		
		
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("***** TC001_AccountRegistrationTest Finished *****");
	}
	
	
}
