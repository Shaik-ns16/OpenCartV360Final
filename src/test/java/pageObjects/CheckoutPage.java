package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-payment-firstname']")
	WebElement inp_firstName;
	
	@FindBy(xpath="//input[@id='input-payment-lastname']")
	WebElement inp_lastName;
	
	@FindBy(xpath="//input[@id='input-payment-company']")
	WebElement inp_companyName;
	
	@FindBy(xpath="//input[@id='input-payment-address-1']")
	WebElement inp_address1;
	
	@FindBy(xpath="//input[@id='input-payment-address-2']")
	WebElement inp_address2;
	
	@FindBy(xpath="//input[@id='input-payment-city']")
	WebElement inp_city;
	
	@FindBy(xpath="//input[@id='input-payment-postcode']")
	WebElement inp_postcode;
	
	@FindBy(xpath="//select[@id='input-payment-country']")
	WebElement select_country;
	
	@FindBy(xpath="//select[@id='input-payment-zone']")
	WebElement select_state;
	
	@FindBy(xpath="//input[@id='button-payment-address']")
	WebElement btn_address_continue;
	
	@FindBy(xpath="//input[@id='button-shipping-address']")
	WebElement btn_shipping_continue;
	
	@FindBy(xpath="//input[@id='button-shipping-method']")
	WebElement btn_deliveryMethod_continue;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agreeCheckbox;
	
	@FindBy(xpath="//input[@id='button-payment-method']")
	WebElement btn_payMethod_continue;
	
	@FindBy(css="body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(6) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tfoot:nth-child(3) > tr:nth-child(3) > td:nth-child(2)")
	WebElement totalAmount;
	
	@FindBy(xpath="//input[@id='button-confirm']")
	WebElement btn_confirmOrder;
	
	@FindBy(xpath="//h1[normalize-space()='Your order has been placed!']")
	WebElement orderConfirm;
	
	public void enterFirstName(String firstName)
	{
		inp_firstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName)
	{
		inp_lastName.sendKeys(lastName);
	}
	
	public void enterCompanyName(String companyName)
	{
		inp_companyName.sendKeys(companyName);
	}
	
	public void setAddress1(String address1)
	{
		inp_address1.sendKeys(address1);
	}
	
	
	public void setAddress2(String address2)
	{
		inp_address2.sendKeys(address2);
	}
	
	public void enterCityName(String cityName)
	{
		inp_city.sendKeys(cityName);
	}
	
	public void enterPostCode(String postCode)
	{
		inp_postcode.sendKeys(postCode);
	}
	
	public void selectCountry(String country)
	{
		Select slctCountry=new Select(select_country);
		slctCountry.selectByVisibleText(country);
	}
	
	public void selectState(String state)
	{
		Select slctState=new Select(select_state);
		slctState.selectByVisibleText(state);
	}
	
	public void clickAddressContinue()
	{
		btn_address_continue.click();
	}
	
	public void clickShippingContinue()
	{
		btn_shipping_continue.click();
	}
	
	public void clickDeliveryMethodContinue()
	{
		btn_deliveryMethod_continue.click();
	}
	
	public void clickAgreeCheckbox()
	{
		agreeCheckbox.click();
	}
	
	public void clickPayMethodContinue()
	{
		btn_payMethod_continue.click();
	}
	
	public void clickConfirmOrder()
	{
		btn_confirmOrder.click();
	}
	
	public boolean isOrderPlaced(String orderConfirmText)
	{
		if(orderConfirm.getText().equals(orderConfirmText))
		{
			return true;
		}
		return false;
	}
	
	
	
}
