package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DriverFactory;

public class TC006_EndToEndTest extends BaseClass{
	
	@Test(groups= {"Master","EndTest"})
	public void verify_EndToEnd_Checkout()
	{
		try
		{
		logger.info("**** TC006_EndToEndTest Started *****");
		HomePage hp=new HomePage(DriverFactory.getDriver());
		logger.info("Clicking myAccount link..");
		hp.clickMyAccount();
		logger.info("clicking register link..");
		hp.clickRegister();
		
		RegistrationPage rp= new RegistrationPage(DriverFactory.getDriver());
		logger.info("Providing the details...");
		String fname=randomName();
		String lname=randomName();
		String email=randomName()+"@gmail.com";
		rp.setFirstName(fname);
		rp.setLastName(lname);
		rp.setEmail(email);
		rp.setPhone(randomPhone());
		String password = randomAlphaNumeric();
		rp.setPassword(password);
		rp.setCnfmPass(password);
		rp.confirmPrivacy();
		rp.clickContinue();
		logger.info("Clicked continue button..");
		
		MyAccountPage myAcc=new MyAccountPage(DriverFactory.getDriver());
		logger.info("Clicking logout...");
		myAcc.clickLogout();
		logger.info("clicking my account link..");
		hp.clickMyAccount();
		logger.info("Clicking login link..");
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(DriverFactory.getDriver());
		logger.info("providing details and clicking login..");
		lp.enterEmail(email);
		lp.enterPass(password);
		lp.clickLogin();
		
		logger.info("Entering product name in searchboc and clicking search button..");
		hp.searchProduct(prop.getProperty("searchProductName"));
		hp.clickSearch();
		
		SearchPage sp= new SearchPage(DriverFactory.getDriver());
		logger.info("clicking result product if it is same..");
		sp.clickProduct();
		
		AddToCartPage atc=new AddToCartPage(DriverFactory.getDriver());
		logger.info("choosing the date and quantity and clicking add to cart button..");
		atc.chooseDate(prop.getProperty("deliveryDate"), prop.getProperty("date"));
		atc.chooseQuantity("1");
		atc.clickAddToCart();
		logger.info("clicking cart button for checkout..");
		Thread.sleep(3000);
		atc.clickCartTotal();
		Thread.sleep(3000);
		atc.clickCheckout();
		
		CheckoutPage cp=new CheckoutPage(DriverFactory.getDriver());
		logger.info("providing address details to check out..");
		cp.enterFirstName(fname);
		cp.enterLastName(lname);
		cp.enterCompanyName("Dlf Tech");
		cp.setAddress1("Dlf");
		cp.setAddress2("Ramapuram");
		cp.enterCityName("Chennai");
		cp.enterPostCode("600001");
		cp.selectCountry("India");
		cp.selectState("Tamil Nadu");
		cp.clickAddressContinue();
		cp.clickShippingContinue();
		cp.clickDeliveryMethodContinue();
		Thread.sleep(2000);
		cp.clickAgreeCheckbox();
		cp.clickPayMethodContinue();
		
		logger.info("clicking confirm order..");
		cp.clickConfirmOrder();
		Thread.sleep(2000);
		logger.info("Validating the order is placed successfully..");
		if(cp.isOrderPlaced("Your order has been placed!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Test failed");
			logger.debug("Debug Log..");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**** TC006_EndToEndTest Finished *****");
		
	}
	
}
