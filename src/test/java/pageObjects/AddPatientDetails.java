package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import utilities.Common_Methods;


public class AddPatientDetails
{

//Testing this
	public WebDriver driver;
	public Common_Methods commonMethod;

	public AddPatientDetails(WebDriver driver, Common_Methods commonMethod)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.commonMethod = commonMethod;
	}

	
	

/*	public WebDriver driver=null;

	public AddPatientDetails(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}*/

	//************ Search Patient or Add New Patient *************//

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

	@FindBy(xpath="(//*[@value='OPD']/span)[2]")
	@CacheLookup
	WebElement OPDtab;

	@FindBy(xpath="//*[@class='glyphicon glyphicon-plus']/..//i")
	@CacheLookup
	public
	WebElement ADDbtn;

	@FindBy(xpath="//*[text()='Add New Patient']")
	@CacheLookup
	WebElement AddNewPatient;


	//***********Patient Registration & Appointment Form****************//


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

	@FindBy(xpath="(//*[text()='Primary'])[2]/..//span[2]/b")
	@CacheLookup
	WebElement clickonprimarylang;

	@FindBy(xpath="//*[@type='search']/..//input")
	@CacheLookup
	WebElement primaryinput;

	@FindBy(xpath="//li[text()='Hindi']")
	@CacheLookup
	WebElement primarylang;

	@FindBy(xpath="(//*[text()='Secondary'])[2]/..//span[2]/b")
	@CacheLookup
	WebElement clickonsecondlang;

	@FindBy(xpath="//*[@type='search']/..//input")
	@CacheLookup
	WebElement secondaryinput;

	@FindBy(xpath="//li[text()='English']")
	@CacheLookup
	WebElement clicksecondarylang;

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

	@FindBy(xpath="(//*[@role='combobox'])[3]/..//span[2]/b")
	@CacheLookup
	WebElement clickonpatientref;

	@FindBy(xpath="//*[@type='search']/..//input")
	@CacheLookup
	WebElement refinput;

	@FindBy(xpath="//li[text()='Self']")
	@CacheLookup
	WebElement ref;

	@FindBy(xpath="//*[text()='Other Details']")
	@CacheLookup
	WebElement OD;


	//-----------------------------------------------------------------------------------------------------------------------------------------	
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

	//Function-------------------------------------------------------------------------------------------------------------------------

	public void clickOPD_module(String uname)
	{
		OPDtab.click();
	}

	public void clickAdd_btn() throws InterruptedException
	{   

		commonMethod.expwait("//*[@class='glyphicon glyphicon-plus']");
		commonMethod.clickElementByElement(ADDbtn);
		commonMethod.expwait("//*[text()='Add New Patient']");
	}

	public void click_Add_New_Patient_btn()
	{
		commonMethod.clickElementByElement(AddNewPatient);
		commonMethod.expwait("//*[@placeholder='First Name']");
	}

	public void fillFirstName(String fname)
	{
		firstname.sendKeys(fname);
	}

	public void fillMobNo(String mobNo)
	{
		mobno.sendKeys(mobNo);
	}

	public void clickappointmentbtn()
	{
		commonMethod.expwait("//input[@value='Create Appointment']");
		commonMethod.clickElementByElement(creatAppointmentButton);
		commonMethod.expwait("//*[@class='glyphicon glyphicon-plus']");
	}

	public void fillMidleNAme(String midlename)
	{
		middlename.sendKeys(midlename);
	}

	public void fillLastNAme(String lname)
	{
		lastname.sendKeys(lname);
	}

	public void fillSecNo(String midlename)
	{
		middlename.sendKeys(midlename);
	}

	public void fillEmail(String midlename)
	{
		email.sendKeys(midlename);
	}

	public void fillPrimaryLanguage(String primarylanguage)
	{
		clickonprimarylang.click();
		primaryinput.sendKeys(primarylanguage);
		primarylang.click();
	}

	public void fillSecondaryLanguage(String secondarylanguage)
	{
		clickonsecondlang.click();
		secondaryinput.sendKeys(secondarylanguage);
		clicksecondarylang.click();
	}

	public void fillPincode(String pin) throws Exception
	{
		PinCodeField.sendKeys("5600");
		commonMethod.normalWait(3000);
		driver.findElement(By.xpath("//*[contains(text(),'560037')]")).click();
	}

	public void fillAdd1(String addres1)
	{
		Add1.sendKeys(addres1);
	}

	public void fillAdd2(String addres2)
	{
		Add2.sendKeys(addres2);
	}

	public void fillMRN(String mrn1)
	{
		MRNo.sendKeys(commonMethod.randomstring());
	}

	public void fillAadhaar(String adhar)
	{
		AdharNo.sendKeys(adhar);
	}

	public void fillPan(String pan)
	{
		PanNo.sendKeys(pan);
	}

	public void fillDL(String dl)
	{
		DLNo.sendKeys(dl);
	}

	public void fillpatientref(String Ref)
	{
		clickonpatientref.click();
		refinput.sendKeys(Ref);
		ref.click();
	}

	public void click_Other_Details()
	{
		commonMethod.clickElementByElement(OD);
	}

	//-ve Blood Group 
	@FindBy(xpath="//*[text()='O-']")
	@CacheLookup
	WebElement blodgrpneg;

	public void selectnegativeGroup() {
		commonMethod.clickElementByElement(blodgrpneg);
	}


	@FindBy(xpath="//*[text()='O+']")
	@CacheLookup
	WebElement blodgrppostv;

	public void selectBloodGroup() 
	{
		commonMethod.clickElementByElement(blodgrppostv);
	}

	@FindBy(xpath="//*[text()='Single']")
	@CacheLookup
	WebElement status;

	public void select_Mar_Status()
	{
		commonMethod.clickElementByElement(status);
	}   

	@FindBy(xpath="//*[@name='patient[emergencycontactname]']")
	@CacheLookup
	WebElement emergncyname;

	public void fillEmrgncyName(String ename)
	{
		emergncyname.sendKeys(ename);
	} 

	@FindBy(xpath="//*[@name='patient[emergencymobilenumber]']")
	@CacheLookup
	WebElement emergncycnct;

	public void fillEmrgncyCnct(String ecnct)
	{
		emergncycnct.sendKeys(ecnct);
	} 

	@FindBy(xpath="//*[@input-value='Breastfeeding']")
	@CacheLookup
	WebElement Spstatus;

	public void selectSpecstatus()
	{
		commonMethod.clickElementByElement(Spstatus);
	}

	@FindBy(xpath="//a[text()='History']")
	@CacheLookup
	WebElement history;

	public void clickHistory()
	{
		commonMethod.clickElementByElement(history);
	}

	@FindBy(how = How.XPATH, using = "//*[@name='speciality_histories']")
	@CacheLookup
	public List<WebElement> opthalHistoryTab;

	@FindBy(how = How.XPATH, using = "//*[@name='personal_histories']")
	@CacheLookup
	public List<WebElement> systemicHistoryTab;

	@FindBy(how = How.XPATH, using = "//*[@name='drug_allergies']")
	@CacheLookup
	public List<WebElement> drugAllergiesTab;

	@FindBy(how = How.XPATH, using = "//*[@name='contact_allergies']")
	@CacheLookup
	public List<WebElement> contactAllergiesTab;

	@FindBy(how = How.XPATH, using = "//*[@name='food_allergies']")
	@CacheLookup
	public List<WebElement> foodAllergiesTab;
	
	
	@FindBy(how = How.XPATH, using = "//*[@name='antimicrobial_agents']")
	@CacheLookup
	public List<WebElement> antimicrobialagent;
	
	
	@FindBy(how = How.XPATH, using = "//*[@name='antifungal_agents']")
	@CacheLookup
	public List<WebElement> antifungalagent;
	
	@FindBy(how = How.XPATH, using = "//*[@name='antiviral_agents']")
	@CacheLookup
	public List<WebElement> antiviralagent;
	
	@FindBy(how = How.XPATH, using = "//*[@name='nsaids']")
	@CacheLookup
	public List<WebElement> nsaids;
	
	
	@FindBy(how = How.XPATH, using = "//*[@name='eye_drops']")
	@CacheLookup
	public List<WebElement> eyedrops;
	

	@FindBy(xpath="//*[text()='Allergies']")
	@CacheLookup
	WebElement allergies;

	public void clickAllergies()
	{
		commonMethod.clickElementByElement(allergies);
	}

	@FindBy(how = How.ID, using = "antimicrobial_agents")
	@CacheLookup
	public WebElement antimicrobialagents;

	public void clickAntimicrobialagents()
	{
		commonMethod.clickElementByElement(antimicrobialagents);
	}

	@FindBy(how = How.ID, using = "antifungal_agents")
	@CacheLookup
	public WebElement antifungalagents;

	public void clickAntifungalagents()
	{
		commonMethod.clickElementByElement(antifungalagents);
	}

	@FindBy(how = How.ID, using = "antiviral_agents")
	@CacheLookup
	public WebElement antiviralagents;

	public void clickantiviralagents()
	{
		commonMethod.clickElementByElement(antiviralagents);
	}

	@FindBy(how = How.ID, using = "nsaids")
	@CacheLookup
	public WebElement Nsaids;

	public void clicknsaids()
	{
		commonMethod.clickElementByElement(Nsaids);
	}
	
	@FindBy(how = How.ID, using = "eye_drops")
	@CacheLookup
	public WebElement eyedrop;

	public void clickEyedrops()
	{
		commonMethod.clickElementByElement(eyedrop);
	}
	
	@FindBy(how = How.XPATH, using = "((//*[@class='row'])[7]/..//div)[5]/div")
	@CacheLookup
	public List<WebElement> patientsetting;
	
	
	
	
	
	

	/*@FindBy(how = How.XPATH, using = "//h4[text()='Welcome']")
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


*/
}

