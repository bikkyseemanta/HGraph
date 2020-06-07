package stepDefinations;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;

import commonMethod.Common_Methods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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


	@When("^cliks on Login$")
	public void cliks_on_Login() throws Throwable 
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
	
	
	@Then("^EHR patient list page should display$")
	public void ehr_patient_list_page_should_display() throws Throwable
	{
		if(driver.findElement(By.xpath("//*[@src=\"/assets/foss_navbar-f513423ccdf9771ea548ff72a115157b342f4860087869219c650fc59f089a33.png\"]")).isDisplayed())
		{
			Reporter.addStepLog("Successfully log in as a recepionist to EHR -->Test Pass");
			logger.info("*****Successfully log in as a recepionist to EHR******");
		}
		else
		{
			Reporter.addStepLog("Log in as a recepionist to EHR is not working-->DEFECT");
		}
	}

	@Then("^click on Add button$")
	public void click_on_Add_button() throws Throwable
	{
		if(driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-plus']")).isDisplayed()) 
		{
			Thread.sleep(5000);
			clickElementByElement(driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-plus']")));
			Thread.sleep(5000);
			if(driver.findElement(By.xpath("//*[text()='Add New Patient']")).isDisplayed())
			{
				Reporter.addStepLog("Add new patient pop up is opening after click of ADD button-->Test Pass");
				logger.info("*****Add new patient pop up is opening after click of ADD button******");
			}
			else
			{
				Reporter.addStepLog("Add new patient pop up is not opening after click of ADD button-->DEFECT");
			}
		}
		else
		{
			Reporter.addStepLog("Add plus button is not displaying in patient list page-->DEFECT");
		}
	}

	@Then("^click on Add New Patient button$")
	public void click_on_Add_New_Patient_button() throws Throwable
	{
		driver.findElement(By.xpath("//*[text()='Add New Patient']")).click();
		normalWait(5000);
		logger.info("*****Clicking on Add New Patient Button******");
	}

	@When("^user without filling mandatory field and click on Appointment button$")
	public void user_without_filling_mandatory_field_and_click_on_Appointment_button() throws Throwable
	{

		driver.findElement(By.xpath("//input[@value='Create Appointment']")).click();
		normalWait(7000);
		
	}

	@Then("^validate warning message should display$")
	public void validate_warning_message_should_display() throws Throwable
	{
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
	public void user_fill_mandatory_fields(String fname, String mobNo) throws Throwable
	{
		AddPatientDetails Add_PD = new AddPatientDetails(driver);
	    logger.info("*****Launching browser******");
	    Add_PD.fillFirstName(fname);
	    Add_PD.fillMobNo(mobNo);
	    logger.info("*****User successfully enters First Name and Mobile No******");
	}

	@Then("^user can create Appointment$")
	public void user_can_create_Appointment() throws Throwable 
	{
		driver.findElement(By.xpath("//input[@value='Create Appointment']")).click();
		normalWait(7000);
		 logger.info("*****User successfully created an Appointment by entering only mandatory field******");
	}

	@Then("^user clicks on the ADD button$")
	public void user_clicks_on_the_ADD_button() throws Throwable {
	   
	}

	@Then("^User clicks on the add new patient button$")
	public void user_clicks_on_the_add_new_patient_button() throws Throwable {
	   
	}

	@Then("^Patient Registration & Appointment Form should display$")
	public void patient_Registration_Appointment_Form_should_display() throws Throwable {
	 
	}

	@Then("^user fill patientdetails text info$")
	public void user_fill_patientdetails_text_info() throws Throwable {
	  
	}

	@Then("^user select patient details drop down info \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_select_patient_details_drop_down_info(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
	   
	}

	@Then("^user select gender radio btn$")
	public void user_select_gender_radio_btn() throws Throwable {
	  
	}

}
