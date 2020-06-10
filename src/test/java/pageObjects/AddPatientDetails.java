package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.Common_Methods;


public class AddPatientDetails
{


	public WebDriver driver;
	public Common_Methods commonMethod;

	public AddPatientDetails(WebDriver driver, Common_Methods commonMethod)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.commonMethod = commonMethod;
	}


	@FindBy(how = How.XPATH, using = "//h4[text()='Welcome']")
	@CacheLookup
	public WebElement welcomeMessage;

	@FindBy(how = How.ID, using = "add-appointment-btn")
	@CacheLookup
	public WebElement addAppointmentButton;

	@FindBy(how = How.XPATH, using = "//h4[text()='Search Patient or Add New Patient']")
	@CacheLookup
	public WebElement addNewPatientModalHeader;

	@FindBy(how = How.XPATH, using = "//button[text()='Search']")
	@CacheLookup
	public WebElement searchButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Add New Patient']")
	@CacheLookup
	public WebElement addNewPatientButton;

	@FindBy(how = How.ID, using = "search-patient")
	@CacheLookup
	public WebElement searchPatientInput;

	@FindBy(how = How.ID, using = "patient_search")
	@CacheLookup
	public WebElement patientSearchDropdown;

	@FindBy(how = How.XPATH, using = "//button[text()='Close']")
	@CacheLookup
	public WebElement closeButton;

	@FindBy(how = How.XPATH, using = "//h4[text()='Patient Registration & Appointment Form']")
	@CacheLookup
	public WebElement patientRegistrationModalHeader;

	@FindBy(how = How.XPATH, using = "//div[@id='patientWizard']//li[@role='presentation']/a")
	@CacheLookup
	public List<WebElement> patientWizardTabs;

	@FindBy(how = How.XPATH, using = "//input[@value='Create Appointment']")
	@CacheLookup
	public WebElement creatAppointmentButton;

	@FindBy(how = How.ID, using = "patient_firstname")
	@CacheLookup
	public WebElement firstNameInput;

	@FindBy(how = How.ID, using = "patient_mobilenumber")
	@CacheLookup
	public WebElement mobileNumberInput;

	@FindBy(how = How.XPATH, using = "//div[@id='appointment_my_queue_list']//b")
	@CacheLookup
	public List<WebElement> muQueueAppointmentListName;

	@FindBy(how = How.XPATH, using = "//div[@id='patient-details']//div[text()='Full Name']/following-sibling::div/b")
	@CacheLookup
	public WebElement patientNameInAppointmentSummary;

	@FindBy(how = How.LINK_TEXT, using = "Mark Patient Arrived")
	@CacheLookup
	public WebElement markPatientArrived;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Send To')]")
	@CacheLookup
	public WebElement sendToSection;



	@FindBy(xpath="(//*[@value='OPD']/span)[2]")
	@CacheLookup
	WebElement OPDtab;

	@FindBy(xpath="//*[@class='glyphicon glyphicon-plus']")
	@CacheLookup
	public
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

	public void clickAdd_btn()
	{
		commonMethod.expwait("//*[@class='glyphicon glyphicon-plus']");
		commonMethod.clickElementByElement(ADDbtn);
	}

	public void fillFirstName(String fname)
	{
		firstname.sendKeys(fname);
	}

	public void fillMobNo(String mobNo)
	{
		mobno.sendKeys(mobNo);
	}

	public void validatepopuoheader(String expectedHeader)
	{
		if (expectedHeader.contains("Add New Patient")) {
			commonMethod.waitForTextToBePresentInElement(addNewPatientModalHeader, expectedHeader);
			Assert.assertEquals(addNewPatientModalHeader.getText(), expectedHeader);
		} else if (expectedHeader.contains("Registration")) {
			commonMethod.waitForTextToBePresentInElement(patientRegistrationModalHeader, expectedHeader);
			Assert.assertEquals(patientRegistrationModalHeader.getText(), expectedHeader);
		}
	}

	public void click_Add_New_Patient_btn()
	{
		commonMethod.expwait("//*[text()='Add New Patient']");
		commonMethod.clickElementByElement(AddNewPatient);
	}

	public void clickappointmentbtn()
	{
		commonMethod.expwait("//input[@value='Create Appointment']");
		commonMethod.clickElementByElement(creatAppointmentButton);
		commonMethod.expwait("//*[@class='glyphicon glyphicon-plus']");
	}



}

