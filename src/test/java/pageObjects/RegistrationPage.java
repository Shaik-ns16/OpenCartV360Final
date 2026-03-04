package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement inp_firstName;
	
	@FindBy (xpath="//input[@id='input-lastname']")
	WebElement inp_lastName;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement inp_email;

	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement inp_phone;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement inp_password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement inp_cnfm_pass;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement rdbtn_news_yes;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement rdbtn_news_no;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agree_privacy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement accountText;
	
	
	public void setFirstName(String fname) {
		inp_firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		inp_lastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		inp_email.sendKeys(email);
	}
	
	public void setPhone(String phone)
	{
		inp_phone.sendKeys(phone);
	}
	
	public void setPassword(String pass)
	{
		inp_password.sendKeys(pass);
	}
	
	public void setCnfmPass(String pass)
	{
		inp_cnfm_pass.sendKeys(pass);
	}
	
	public void clickNewsYes()
	{
		rdbtn_news_yes.click();
	}
	
	public void clickNewsNo()
	{
		rdbtn_news_no.click();
	}
	
	public void confirmPrivacy()
	{
		agree_privacy.click();
	}
	
	public void clickContinue()
	{
		btn_continue.click();
	}
	
	public String registrationCreatedText()
	{
		try
		{
			return accountText.getText();
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	
}
