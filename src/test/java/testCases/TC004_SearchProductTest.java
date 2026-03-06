package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DriverFactory;

public class TC004_SearchProductTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	public void verify_product_search()
	{
		try
		{
		logger.info("***** TC004_SearchProductTest Finished *****");
		
		HomePage hp=new HomePage(DriverFactory.getDriver());
		logger.info("Entering the product name to search..");
		hp.searchProduct(prop.getProperty("searchProductName"));
		logger.info("clicking search button..");
		hp.clickSearch();
		
		SearchPage sp=new SearchPage(DriverFactory.getDriver());
		logger.info("Validating the search result product is same..");
		if(sp.isProductExist(prop.getProperty("searchProductName")))
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
		logger.info("***** TC004_SearchProductTest Finished *****");
		
	}

}
