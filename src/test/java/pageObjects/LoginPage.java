package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Common_Methods;

public class LoginPage 

{
	
	public WebDriver driver=null;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@placeholder='Username']")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath="//*[@placeholder='Password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(id="signinbutton")
	@CacheLookup
	WebElement loginbutton;
	
	public void fillusername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void fillpassword(String pswd)
	{
		password.sendKeys(pswd);
	}
	
	public void clickloginbtn()
	{
		loginbutton.click();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	
	
	
	
	

}
