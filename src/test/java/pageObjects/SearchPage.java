package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[normalize-space()='HP LP3065']")
	WebElement product;
	
	
	
	public boolean isProductExist(String productName)
	{
		if(product.getText().equalsIgnoreCase(productName))
		{
			return true;
		}
		return false;
	}
	
	public void clickProduct()
	{
		product.click();
	}
	
	

}
