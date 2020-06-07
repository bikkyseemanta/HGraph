package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientDetails 
{
 
public WebDriver driver=null;
	
	public AddPatientDetails(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//*[@value='OPD']/span)[2]")
	@CacheLookup
	WebElement OPDtab;
	
	@FindBy(xpath="//*[@href='/patients/search?current_date=2020-06-07&modal=appointment-modal&url=%2Fappointments%2Fnew']")
	@CacheLookup
	WebElement ADDbtn;
	
	@FindBy(xpath="//*[text()='Add New Patient']")
	@CacheLookup
	WebElement AddNewPatient;
	
	@FindBy(xpath="//*[@placeholder='First Name']")
	@CacheLookup
	WebElement firstname;
	
	@FindBy(xpath="//*[@placeholder='Middle Name']")
	@CacheLookup
	WebElement middlename;
	
	@FindBy(xpath="//*[@placeholder='Last Name']")
	@CacheLookup
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='patient[mobilenumber]']")
	@CacheLookup
	WebElement mobno;
	
	@FindBy(xpath="//*[@placeholder='Secondary Number']")
	@CacheLookup
	WebElement secondaryno;
	
	@FindBy(xpath="//*[@placeholder='Email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath="//input[@type='search']")
	@CacheLookup
	WebElement searchlang;
		
	@FindBy(xpath="//input[@placeholder='Pincode']")
	@CacheLookup
	WebElement PinCodeField;
		
	@FindBy(xpath="//input[@placeholder='Address 1']")
	@CacheLookup
	WebElement Add1;
	
		
	@FindBy(xpath="//input[@placeholder='Address 2']")
	@CacheLookup
	WebElement Add2;
	
		
	@FindBy(xpath="//input[@placeholder='Medical Record No.']")
	@CacheLookup
	WebElement MRNo;
		
	@FindBy(xpath="//input[@placeholder='Aadhar Card No.']")
	@CacheLookup
	WebElement AdharNo;
		
	@FindBy(xpath="//input[@placeholder='Pan No.']")
	@CacheLookup
	WebElement PanNo;
	
	@FindBy(xpath="//input[@placeholder='DL No.']")
	@CacheLookup
	WebElement DLNo;
	
	
	
	
	
	
	
	
	
	public void clickOPD_module(String uname)
	{
		OPDtab.click();
	}
	
	public void fillFirstName(String fname)
	{
		firstname.sendKeys(fname);
	}
	
	public void fillMobNo(String mobNo)
	{
		mobno.sendKeys(mobNo);
	}
}

