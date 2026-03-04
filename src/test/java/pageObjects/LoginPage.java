package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement inp_email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement inp_password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_login;

	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	WebElement forgotPassword;
	
	
	public void enterEmail(String email)
	{
		inp_email.sendKeys(email);
	}
	
	public void enterPass(String pass)
	{
		inp_password.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		btn_login.click();
	}


}
