package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DriverFactory;

public class TC005_AddToCartTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void verify_product_addedToCart()
	{
		try
		{
		HomePage hp=new HomePage(DriverFactory.getDriver());
		logger.info("Entering the product name to search..");
		hp.searchProduct(prop.getProperty("searchProductName"));
		logger.info("Clicking search button..");
		hp.clickSearch();
		
		SearchPage sp= new SearchPage(DriverFactory.getDriver());
		logger.info("Validating the search result product is same..");
		if (sp.isProductExist(prop.getProperty("searchProductName"))) 
		{
			sp.clickProduct();
		}
		
		AddToCartPage atc= new AddToCartPage(DriverFactory.getDriver());
		logger.info("Choosing delivery date..");
		atc.chooseDate(prop.getProperty("deliveryDate"), prop.getProperty("date"));
		logger.info("Choosing quantity of the product..");
		atc.chooseQuantity("1");
		logger.info("Clicking add to cart button..");
		atc.clickAddToCart();
		
		logger.info("validating the product added to cart successfully..");
		if(atc.isProductAddedSuccessfully())
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Test Failed");
			logger.debug("Debug log..");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
}
