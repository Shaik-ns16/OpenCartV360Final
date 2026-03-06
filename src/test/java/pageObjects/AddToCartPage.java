package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends BasePage{

	public AddToCartPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@class='input-group date']//button[@type='button']")
	WebElement btn_date;
	
	@FindBy(xpath="//th[@class='picker-switch']")
	WebElement startDate;
	
	@FindBy(xpath="//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]")
	WebElement next;
	
	@FindBy(xpath="//table//tbody//tr//td[@class='day']")
	List<WebElement> dates;

	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement inp_quantity;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;
	
	@FindBy(xpath="//span[@id='cart-total']")
	WebElement btn_cartTotal;
	
	@FindBy(xpath="//strong[normalize-space()='Checkout']")
	WebElement checkoutLink;
	
	public void chooseDate(String fullMonthYear,String date)
	{
		btn_date.click();
		
		while(true)
		{
			if(startDate.getText().equals(fullMonthYear)) 
			{
				break;
			}
			next.click();
		}
		
		for(WebElement dt:dates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
	}
	
	public void chooseQuantity(String quantity) {
		inp_quantity.clear();
		inp_quantity.sendKeys(quantity);
	}
	
	public void clickAddToCart()
	{
		addToCart.click();
	}
	
	public boolean isProductAddedSuccessfully() 
	{
		if (successMsg.getText().startsWith("Success")) 
		{
			return true;
		}
		return false;
	}
	
	public void clickCartTotal()
	{
		btn_cartTotal.click();
	}
	
	public void clickCheckout()
	{
		checkoutLink.click();
	}
}
