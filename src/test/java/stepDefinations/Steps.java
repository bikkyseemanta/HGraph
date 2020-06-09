package stepDefinations;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;
import commonMethod.Common_Methods;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import pageObjects.AddPatientDetails;
import pageObjects.LoginPage;

public class Steps extends Common_Methods

{
	
	
	@Given("^open the browser and enter the URL \"([^\"]*)\"$")
	public void open_the_browser_and_enter_the_URL(String url) throws Throwable
	{   
		logger = Logger.getLogger("HealthGraph");
		PropertyConfigurator.configure("Log4j.properties");


		browser_and_url_open();
		lp=new LoginPage(driver);
		logger.info("*****Launching browser******");
	}

	@When("^user fills \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_fills_and(String uname, String pswd) throws Throwable {
		lp.fillusername(uname);
		lp.fillpassword(pswd);
		logger.info("*****Successfully Entered Username and Password******");
	}


	@When("^clicks on Login$")
	public void clicks_on_Login() throws Throwable 
	{
		lp.clickloginbtn();
		logger.info("*****Logged in Successfully******");
	}

	@Then("^user can view dashboard$")
	public void user_can_view_dashboard() throws Throwable 
	{
		Assert.assertEquals("Foss - EHR", lp.getPageTitle());
		logger.info("*****User landed on OPD Home Page******");
	}


	//Add New Patients------------------------------------------------------------------------------------------------------------------
	@Then("^click on Add button$")
	public void click_on_Add_button() throws Throwable {
		
		addpd =new AddPatientDetails(driver);
		addpd.clickAdd_btn();
		
	}

	@Then("^User should see a modal having the header$")
	public void user_should_see_a_modal_having_the_header() throws Throwable {
	
		//addpd.validatepopuoheader();
		
	}

	@Then("^Validate all the fields contains in add_new_patient modal$")
	public void validate_all_the_fields_contains_in_add_new_patient_modal() throws Throwable {
		
	}

	@Then("^click on Add New Patient button$")
	public void click_on_Add_New_Patient_button() throws Throwable {
	   addpd.click_Add_New_Patient_btn();
	}

	@Then("^Modal must have below mentioned tabs$")
	public void modal_must_have_below_mentioned_tabs(DataTable dataTable) throws Throwable {
		List<String> listData = dataTable.asList(String.class);
		int index = 0;
		for (WebElement element : addpd.patientWizardTabs) {
			Assert.assertEquals(element.getText(), listData.get(index));
			index++;
		}
	    
	}

	@When("^user without filling mandatory field and click on Appointment button$")
	public void user_without_filling_mandatory_field_and_click_on_Appointment_button() throws Throwable {
	   addpd.clickappointmentbtn();
	}

	@Then("^validate warning message should display$")
	public void validate_warning_message_should_display() throws Throwable {
		String warnmsgclor=driver.findElement(By.xpath("//*[text()='First Name']")).getCssValue("color");

		if(warnmsgclor.contains("rgba(51, 51, 51, 1)"))
		{
			Reporter.addStepLog("The warning mesage is highlighting in RED color if user not filling the mandatory fields-->SUCCESS");
			logger.info("*****The warning mesage is highlighting in RED color if user not filling the mandatory fields******");
		}
		else
		{
			Reporter.addStepLog("The warning mesage is highlighting in RED color if user not filling the mandatory fields-->DEFECT");
		}
	}

	@When("^user fill mandatory fields \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_fill_mandatory_fields(String arg1, String arg2) throws Throwable {
	    addpd.fillFirstName(arg1);
	    addpd.fillMobNo(arg2);
	}

	@Then("^user can create Appointment$")
	public void user_can_create_Appointment() throws Throwable {
		addpd.clickappointmentbtn();
		
	}

	@Then("^fill patient details  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void fill_patient_details(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15) throws Throwable {
	    
	}
	

	
	
	
	
	}
