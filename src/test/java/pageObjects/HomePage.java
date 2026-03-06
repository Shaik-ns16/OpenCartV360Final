package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement search_box;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btn_search;
	
	
	public void clickMyAccount()
	{
		myAccount.click();
	}
	
	public void clickRegister()
	{
		register.click();
	}
	
	public void clickLogin()
	{
		login.click();
	}
	
	public void searchProduct(String prod)
	{
		search_box.sendKeys(prod);
	}
	
	public void clickSearch()
	{
		btn_search.click();
	}
	
	
	
	
	
}
