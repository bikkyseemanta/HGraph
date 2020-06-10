package stepDefinations;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AddPatientDetails;
import pageObjects.LoginPage;
import utilities.Common_Methods;
import utilities.WebConnector;

public class Steps  

{
	public Common_Methods commonMethods;
	public WebDriver driver;
	public LoginPage lp;
	public AddPatientDetails addpd;


	public Steps() {

		driver =  WebConnector.driver;
		commonMethods = new Common_Methods(driver);
		lp = new LoginPage(driver);
		addpd = new AddPatientDetails(driver, commonMethods);
		Common_Methods.logger = Logger.getLogger("HealthGraph");
		PropertyConfigurator.configure("Log4j.properties");

	}

	@When("^user fills \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_fills_and(String uname, String pswd) throws Throwable {

		lp.fillusername(uname);
		lp.fillpassword(pswd);
		Common_Methods.logger.info("*****Successfully Entered Username and Password******");
	}


	@When("^clicks on Login$")
	public void clicks_on_Login() throws Throwable 
	{
		lp.clickloginbtn();
		Common_Methods.logger.info("*****Logged in Successfully******");
	}

	@Then("^user can view dashboard$")
	public void user_can_view_dashboard() throws Throwable 
	{
		Assert.assertEquals("Foss - EHR", lp.getPageTitle());
		Common_Methods.logger.info("*****User landed on OPD Home Page******");
	}


	//Add New Patients------------------------------------------------------------------------------------------------------------------
	@Then("^click on Add button$")
	public void click_on_Add_button() throws Throwable {
		addpd.clickAdd_btn();
		Common_Methods.logger.info("*****click on Add button******");
	}

	@Then("^User should see a modal having the header \"([^\"]*)\"$")
	public void user_should_see_a_modal_having_the_header(String expectedHeader) throws Throwable
	{	
		addpd.validatepopuoheader(expectedHeader);
	}

	@Then("^Validate all the fields contains in add_new_patient modal$")
	public void validate_all_the_fields_contains_in_add_new_patient_modal() throws Throwable {

	}

	@Then("^click on Add New Patient button$")
	public void click_on_Add_New_Patient_button() throws Throwable
	{
		addpd.click_Add_New_Patient_btn();
		Common_Methods.logger.info("*****click on Add New Patient button******");
	}

	@Then("^Modal must have below mentioned tabs$")
	public void modal_must_have_below_mentioned_tabs(DataTable dataTable) throws Throwable {
		List<String> listData = dataTable.asList(String.class);
		int index = 0;
		for (WebElement element : addpd.patientWizardTabs) {
			Assert.assertEquals(element.getText(), listData.get(index));
			index++;
		}
		Common_Methods.logger.info("*****Modal have Patient Details, Other Details, History and Allergies tab on LHS ******"); 
	}

	@When("^user without filling mandatory field and click on Appointment button$")
	public void user_without_filling_mandatory_field_and_click_on_Appointment_button() throws Throwable 
	{
		addpd.clickappointmentbtn();
		Common_Methods.logger.info("*****Without filling mandatory field clicking on Appointment button******");
	}

	@Then("^validate warning message should display$")
	public void validate_warning_message_should_display() throws Throwable {
		String warnmsgclor=commonMethods.driver.findElement(By.xpath("//*[text()='First Name']")).getCssValue("color");

		if(warnmsgclor.contains("rgba(51, 51, 51, 1)"))
		{
			Reporter.addStepLog("The warning message is highlighting in RED color if user not filling the mandatory fields-->SUCCESS");
			Common_Methods.logger.info("*****The warning message is highlighting in RED color if user not filling the mandatory fields******");
		}
		else
		{
			Reporter.addStepLog("The warning message is not showing in RED color if user not filling the mandatory fields-->DEFECT");
			Common_Methods.logger.info("*****The warning mesage is not showing in RED color if user not filling the mandatory fields******");
		}
	}

	@When("^user fill mandatory fields \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_fill_mandatory_fields(String arg1, String arg2) throws Throwable
	{
		addpd.fillFirstName(arg1);
		addpd.fillMobNo(arg2);
		Common_Methods.logger.info("*****User entered mandatory fields such as First name and Mob no******"); 
	}

	@Then("^user can create Appointment$")
	public void user_can_create_Appointment() throws Throwable
	{

		addpd.clickappointmentbtn();
		Common_Methods.logger.info("*****User successfully created one appointment by entering mandatory fields******"); 	
	}

	@Then("^fill patient details  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void fill_patient_details(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15) throws Throwable
	{


	}






}
