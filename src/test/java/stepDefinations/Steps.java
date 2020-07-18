package stepDefinations;

import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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

public class Steps extends CommonSteps  

{
	
	Logger logger = Logger.getLogger("Steps");
	public Steps() {


		driver =  WebConnector.driver;
		commonMethods = new Common_Methods(driver);
		lp = new LoginPage(driver);
		addpd = new AddPatientDetails(driver, commonMethods);
		PropertyConfigurator.configure("Log4j.properties");
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
		commonMethods.expwait("//*[@class='glyphicon glyphicon-plus']");
		addpd.clickAdd_btn();
		logger.info("*****click on Add button******");
		commonMethods.normalWait(3000);
	}

	@Then("^User should see a modal having the header \"([^\"]*)\"$")
	public void user_should_see_a_modal_having_the_header(String expectedHeader) throws Throwable
	{	
		addpd.validatepopuoheader(expectedHeader);
	}

	@Then("^Validate all the fields contains in add_new_patient modal$")
	public void validate_all_the_fields_contains_in_add_new_patient_modal() throws Throwable
	{
		    Assert.assertEquals(addpd.searchButton.isDisplayed(), true);
	        Assert.assertEquals(addpd.searchButton.isEnabled(), false);
	        Assert.assertEquals(addpd.searchButton.getCssValue("background-color"), "rgba(92, 184, 92, 1)");
	        Assert.assertEquals(addpd.addNewPatientButton.isDisplayed(), true);
	        Assert.assertEquals(addpd.addNewPatientButton.isEnabled(), true);
	        //Assert.assertEquals(addpd.addNewPatientButton.getCssValue("background-color"), "rgba(91, 192, 222, 1)");
	        Assert.assertEquals(addpd.searchPatientInput.isDisplayed(), true);
	        Assert.assertEquals(addpd.searchPatientInput.getAttribute("placeholder"), "Type Atleast 5 Characters");
	        Assert.assertEquals(addpd.patientSearchDropdown.isDisplayed(), true);
	        Assert.assertEquals(addpd.closeButton.isDisplayed(), true);
	}

	@Then("^click on Add New Patient button$")
	public void click_on_Add_New_Patient_button() throws Throwable
	{
		commonMethods.waitTillClick("//*[text()='Add New Patient']");
		addpd.click_Add_New_Patient_btn();
		logger.info("*****click on Add New Patient button******");
	}

	@Then("^Modal must have below mentioned tabs$")
	public void modal_must_have_below_mentioned_tabs(DataTable dataTable) throws Throwable {
		List<String> listData = dataTable.asList(String.class);
		int index = 0;
		for (WebElement element : addpd.patientWizardTabs) {
			Assert.assertEquals(element.getText(), listData.get(index));
			index++;
		}
		logger.info("*****Modal have Patient Details, Other Details, History and Allergies tab on LHS ******"); 
	}

	@When("^user without filling mandatory field and click on Appointment button$")
	public void user_without_filling_mandatory_field_and_click_on_Appointment_button() throws Throwable 
	{
		addpd.clickappointmentbtn();
		logger.info("*****Without filling mandatory field clicking on Appointment button******");
	}

	@Then("^validate warning message should display$")
	public void validate_warning_message_should_display() throws Throwable {
		String warnmsgclor=commonMethods.driver.findElement(By.xpath("//*[text()='First Name']")).getCssValue("color");

		if(warnmsgclor.contains("rgba(51, 51, 51, 1)"))
		{
			Reporter.addStepLog("The warning message is highlighting in RED color if user not filling the mandatory fields-->SUCCESS");
			logger.info("*****The warning message is highlighting in RED color if user not filling the mandatory fields******");
		}
		else
		{
			Reporter.addStepLog("The warning message is not showing in RED color if user not filling the mandatory fields-->DEFECT");
			logger.info("*****The warning mesage is not showing in RED color if user not filling the mandatory fields******");
		}
	}

	@When("^user fill mandatory fields \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_fill_mandatory_fields(String arg1, String arg2) throws Throwable
	{
		addpd.fillFirstName(arg1);
		addpd.fillMobNo(arg2);
		logger.info("*****User entered mandatory fields such as First name and Mob no******"); 
	}

	@Then("^user can create Appointment$")
	public void user_can_create_Appointment() throws Throwable
	{
		addpd.clickappointmentbtn();
		logger.info("*****User successfully created one appointment by entering mandatory fields******"); 					
	}

	@Then("^fill patient details  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void fill_patient_details(String firstname1, String mobno1, String midlename, String lastname, String secondaryno, String email, String language, String secondarylanguage, String pincode, String Add1, String Add2, String MedicalRepoNo, String Aadhaar, String PANno, String DLno, String Ref) throws Throwable
	{
		
		addpd.fillFirstName(firstname1);
		addpd.fillMobNo(mobno1);
		addpd.fillMidleNAme(midlename);
		addpd.fillLastNAme(lastname);
		addpd.fillSecNo(secondaryno);
		addpd.fillEmail(email);
		addpd.fillPrimaryLanguage(language);
		addpd.fillSecondaryLanguage(secondarylanguage);
		addpd.fillPincode(pincode);
		addpd.fillAdd1(Add1);
		addpd.fillAdd2(Add2);
		addpd.fillMRN(MedicalRepoNo);
		addpd.fillAadhaar(Aadhaar);
		addpd.fillDL(DLno);
		addpd.fillPan(PANno);
		addpd.fillpatientref(Ref);
		logger.info("****User sucessfully entered all fields in Patient Details tab********");	

	}


	@When("^clicks on other details tab$")
	public void clicks_on_other_details_tab() throws Throwable 
	{
		addpd.click_Other_Details();
		logger.info("****User clicks in Other Details tab********");
	}

	@When("^validate blood gropup radio button should be single select$")
	public void validate_blood_gropup_radio_button_should_be_single_select() throws Throwable 
	{
		addpd.selectBloodGroup();
		logger.info("****User selected blood group********");
	}

	@When("^Maritial status should be single select radio button$")
	public void maritial_status_should_be_single_select_radio_button() throws Throwable
	{
		addpd.select_Mar_Status();
		logger.info("****User selected Maritial status********");
	}

	@When("^fill emergency contact \"([^\"]*)\" \"([^\"]*)\"$")
	public void fill_emergency_contact(String ename, String ecnct) throws Throwable 
	{
		addpd.fillEmrgncyName(ename);
		addpd.fillEmrgncyCnct(ecnct);
		logger.info("****User filled emergency Name and Contact number********");
	}

	@When("^validate special status$")
	public void validate_special_status() throws Throwable 
	{
		addpd.selectSpecstatus(); 
		logger.info("****User selected Special status********");
	}

	@When("^clicks on history tab$")
	public void clicks_on_history_tab() throws Throwable
	{
		addpd.clickHistory();
		logger.info("****User clicks on History tab********");

	}
	@When("^Opthalmic History have below tabs$")
	public void opthalmic_History_have_below_tabs(DataTable arg1) throws Throwable {

		List<String> listData = arg1.asList(String.class);
		int index = 0;
		for (WebElement element : addpd.opthalHistoryTab) {
			Assert.assertEquals(element.getText(), listData.get(index));
			index++;
			logger.info("****Opthal History must have below tabs:" + element.getText());			
		}
	}

	@Then("^add comments inside Opthalmic Hitory$")
	public void add_comments_inside_Opthalmic_Hitory() throws Throwable 
	{
		driver.findElement(By.xpath("//input[@id='patient_opthal_history_comment']")).sendKeys("Opthalmic History Comments");
	}

	@When("^Systemic History have below tabs$")
	public void systemic_History_have_below_tabs(DataTable arg2) throws Throwable
	{
		List<String> listData = arg2.asList(String.class);
		int index = 0;
		for (WebElement element : addpd.systemicHistoryTab) {
			Assert.assertEquals(element.getText(), listData.get(index));
			index++;
			logger.info("****Systemic History must have below tabs:" + element.getText());	
		}
	}

	@Then("^each Opthalmic History name should be clickable$")
	public void each_Opthalmic_History_name_should_be_clickable() throws Throwable 
	{
		List<WebElement> opthahistory= addpd.opthalHistoryTab;
		// Instead of using the for each loop, get the size of the list and iterate through it
		for (int i=0; i<opthahistory.size(); i++) {
			try {
				opthahistory.get(i).click();

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				opthahistory = opthahistory= addpd.opthalHistoryTab;
				opthahistory.get(i).click();
			}
		}
	}

	@Then("^select Left Duration for each Opthalmic tabs$")
	public void select_Left_Duration_for_each_Opthalmic_tabs() throws Throwable 
	{
		List<WebElement> duration=driver.findElements(By.xpath("//*[@class='form-control speciality_fields_add_fields speciality_l_duration l_duration_field']"));
		for (int j=0; j<duration.size(); j++) {
			try {
				duration.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='4']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='4']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				duration = duration= driver.findElements(By.xpath("//*[@class='form-control speciality_fields_add_fields speciality_l_duration l_duration_field']"));
				duration.get(j).click();
			}
		}

	}

	@Then("^select Left Duration Units for each Opthalmic tab$")
	public void select_Left_Duration_Units_for_each_Opthalmic_tab() throws Throwable 
	{
		List<WebElement> durationUnits=driver.findElements(By.xpath("//*[@class='form-control speciality_fields_add_fields speciality_l_duration_unit l_duration_unit']"));
		for (int j=0; j<durationUnits.size(); j++) {
			try {
				durationUnits.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='Weeks']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='Weeks']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				durationUnits = durationUnits= driver.findElements(By.xpath("//*[@class='form-control speciality_fields_add_fields speciality_l_duration_unit l_duration_unit']"));
				durationUnits.get(j).click();
			}
		}
	}

	@Then("^fill comments for each Opthalmic History Comment$")
	public void fill_comments_for_each_Opthalmic_History_Comment() throws Throwable 
	{

		List<WebElement> comments =driver.findElements(By.xpath("//input[@class='form-control personal_field_add_field']"));
		for (int j=0; j<comments.size(); j++) {
			try {
				comments.get(j).sendKeys("Opthalmic History Comments");
			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				comments = comments= driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
				comments.get(j).sendKeys(" Exception Opthalmic History Comments");
			}
		}
	}

	@Then("^each Systemic History name should be clickable$")
	public void each_Systemic_History_name_should_be_clickable() throws Throwable 
	{
		List<WebElement> Systhistory= addpd.systemicHistoryTab;
		// Instead of using the for each loop, get the size of the list and iterate through it
		for (int i=0; i<Systhistory.size(); i++) {
			try {
				Systhistory.get(i).click();

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				Systhistory = Systhistory= addpd.systemicHistoryTab;
				Systhistory.get(i).click();
			}
		}
	}

	@Then("^select Duration for each Systemic tabs$")
	public void select_Duration_for_each_Systemic_tabs() throws Throwable 
	{
		List<WebElement> duration=driver.findElements(By.xpath("(//*[@class='form-control personal_field_add_field duration_field '])"));
		for (int j=0; j<duration.size(); j++) {
			try {
				duration.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='4']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='4']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				duration = duration= driver.findElements(By.xpath("(//*[@class='form-control personal_field_add_field duration_field '])"));
				duration.get(j).click();
			}
		}

	}

	@Then("^select Duration Units for each Systemic tab$")
	public void select_Duration_Units_for_each_Systemic_tab() throws Throwable 
	{
		List<WebElement> durationUnits=driver.findElements(By.xpath("//*[@class='form-control personal_field_add_field  duration_unit']"));
		for (int j=0; j<durationUnits.size(); j++) {
			try {
				durationUnits.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='Weeks']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='Weeks']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				durationUnits = durationUnits= driver.findElements(By.xpath("//*[@class='form-control personal_field_add_field  duration_unit']"));
				durationUnits.get(j).click();
			}
		}

	}

	@Then("^fill comments for each Systemic History Comment$")
	public void fill_comments_for_each_Systemic_History_Comment() throws Throwable
	{

		List<WebElement> comments =driver.findElements(By.xpath("//*[@class='form-control personal_field_add_comment']/..//input[1]"));
		for (int j=0; j<comments.size(); j++) {
			try {
				comments.get(j).sendKeys("Systemic History Comments");
			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				comments = comments= driver.findElements(By.xpath("//*[@class='form-control personal_field_add_comment']/..//input[1]"));
				comments.get(j).sendKeys(" Systemic History Comments");
			}
		}
	}

	@Then("^add comments inside Systemic Hitory$")
	public void add_comments_inside_Systemic_Hitory() throws Throwable
	{
		driver.findElement(By.xpath("//input[@id='patient_history_comment']")).sendKeys("Systemic History Comments");
		logger.info("**** User successfully entered Systemic History comments******");	
	}

	@Then("^add Medical History$")
	public void add_Medical_History() throws Throwable
	{
		driver.findElement(By.xpath("//input[@id='patient_other_history_attributes_medical_history']")).sendKeys("Medical History Comments");
		logger.info("**** User successfully entered Medical History comments******");
	}

	@Then("^add Family history$")
	public void family_history() throws Throwable 
	{
		driver.findElement(By.xpath("//input[@id='patient_other_history_attributes_family_history']")).sendKeys("Family History Comments");
		logger.info("**** User successfully entered Family History comments******");
	}

	@When("^clicks on allergies tab$")
	public void clicks_on_allergies_tab() throws Throwable 
	{
		addpd.clickAllergies();
		logger.info("****User successfully clicked on Allergies tab******");
	}

	@When("^Drug Allergies have below tabs$")
	public void drug_Allergies_have_below_tabs(DataTable arg3) throws Throwable 
	{
		List<String> listData = arg3.asList(String.class);
		int index = 0;
		for (WebElement element : addpd.drugAllergiesTab) {
			Assert.assertEquals(element.getText(), listData.get(index));
			index++;
			logger.info("****Drug Allergies must have this tabs:" + element.getText());	
		}
	}

	@Then("^user clicks on Antimicrobial Agents$")
	public void user_clicks_on_Antimicrobial_Agents() throws Throwable
	{
		addpd.clickAntimicrobialagents();
		commonMethods.normalWait(100);
	}

	@Then("^Antimicrobial agents have below tabs$")
	public void antimicrobial_agents_have_below_tabs(DataTable arg9) throws Throwable
	{

		List<String> listData = arg9.asList(String.class);
		int index = 0;
		for (WebElement element : addpd.antimicrobialagent) {
			Assert.assertEquals(element.getText(), listData.get(index));
			index++;
			logger.info("****Antimicrobial agents must have this tabs:" + element.getText());	
		}
	}

	@Then("^user clicks on Antifungal Agents$")
	public void user_clicks_on_Antifungal_Agents() throws Throwable 
	{
		addpd.clickAntifungalagents();
		commonMethods.normalWait(100);
	}

	@Then("^Antifungal agents have below tabs$")
	public void antifungal_agents_have_below_tabs(DataTable arg10) throws Throwable 
	{

		List<String> listData = arg10.asList(String.class);
		int index = 0;
		for (WebElement element : addpd.antifungalagent) {
			Assert.assertEquals(element.getText(), listData.get(index));
			index++;
			logger.info("****Antifungal agents must have this tabs:" + element.getText());	
		}
	}

	@Then("^user clicks on Antiviral Agents$")
	public void user_clicks_on_Antiviral_Agents() throws Throwable
	{
		addpd.clickantiviralagents();
		commonMethods.normalWait(100);
	}

	@Then("^Antiviral agents have below tabs$")
	public void antiviral_agents_have_below_tabs(DataTable arg8) throws Throwable 
	{

		List<String> listData = arg8.asList(String.class);
		int index = 0;
		for (WebElement element : addpd.antiviralagent) {
			Assert.assertEquals(element.getText(), listData.get(index));
			index++;
			logger.info("****Antiviral agents must have below tabs:" + element.getText());	
		}
	}

	@Then("^user clicks on Nsaids$")
	public void user_clicks_on_Nsaids() throws Throwable 
	{
		addpd.clicknsaids();
		commonMethods.normalWait(100);
	}

	@Then("^Nsaids have below tabs$")
	public void nsaids_have_below_tabs(DataTable arg7) throws Throwable 
	{
		List<String> listData = arg7.asList(String.class);
		int index = 0;
		for (WebElement element : addpd.nsaids) {
			Assert.assertEquals(element.getText(), listData.get(index));
			index++;
		logger.info("****Nsaids must have below tabs:" + element.getText());	
		}
	}

	@Then("^user clicks on EyeDrops$")
	public void user_clicks_on_EyeDrops() throws Throwable 
	{
		addpd.clickEyedrops();
		commonMethods.normalWait(100);
	}

	@Then("^EyeDrops have below tabs$")
	public void eyedrops_have_below_tabs(DataTable arg6) throws Throwable
	{
		List<String> listData = arg6.asList(String.class);
		int index = 0;
		for (WebElement element : addpd.eyedrops) {
			Assert.assertEquals(element.getText(), listData.get(index));
			index++;
			logger.info("****EyeDrops must have below tabs:" + element.getText());	
		}
	}


	@When("^Contact Allergies have below tabs$")
	public void contact_Allergies_have_below_tabs(DataTable arg4) throws Throwable
	{

		List<String> listData = arg4.asList(String.class);
		int index = 0;
		for (WebElement element : addpd.contactAllergiesTab) {
			Assert.assertEquals(element.getText(), listData.get(index));
			index++;
			logger.info("****Contact Allergies must have below tabs:" + element.getText());	
		}
	}

	@When("^Food Allergies have below tabs$")
	public void food_Allergies_have_below_tabs(DataTable arg5) throws Throwable 
	{
		List<String> listData = arg5.asList(String.class);
		int index = 0;
		for (WebElement element : addpd.foodAllergiesTab) {
			Assert.assertEquals(element.getText(), listData.get(index));
			index++;
			logger.info("****Food Allergies must have below tabs:" + element.getText());	
		}
	}

	@Then("^validate each tabs of Antimicrobial agents$")
	public void validate_each_fields_of_Antimicrobial_agents() throws Throwable {
		List<WebElement> antimicroagent= addpd.antimicrobialagent;
		// Instead of using the for each loop, get the size of the list and iterate through it
		for (int i=0; i<antimicroagent.size(); i++) {
			try {
				antimicroagent.get(i).click();

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				antimicroagent = antimicroagent= addpd.antimicrobialagent;
				antimicroagent.get(i).click();
			}
		}


	}

	@Then("^each Antimicrobial agents name should be display$")
	public void each_Antimicrobial_agents_name_should_be_display() throws Throwable 
	{
		List<WebElement> menuLinks = driver.findElements(By.xpath("//*[@class='col-md-12 col-sm-12 col-xs-12 complaint_name allergies_fields_row_count ampicillin_fields antimicrobial_agents_hide']/..//h5"));

		// Print the number of links present..
		System.out.println(menuLinks.size());
		for (WebElement option : menuLinks) {
			String linkName = option.getText();
			logger.info("****Antimicrobial agent must have this tab:" + linkName);
		}
	}


	@Then("^select Duration for each Antimicrobial agents$")
	public void select_duration_for_Antimicrobial_agents() throws Throwable {

		List<WebElement> durationUnits=driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration'])"));
		for (int j=0; j<durationUnits.size(); j++) {
			try {
				durationUnits.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='4']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='4']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				durationUnits = durationUnits= driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration'])"));
				durationUnits.get(j).click();
			}
		}


	}

	@Then("^select Duration Units for each Antimicrobial agents$")
	public void select_Duration_Units_for_each_Antimicrobial_agents() throws Throwable 
	{

		List<WebElement> durationUnits=driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration_unit'])"));
		for (int j=0; j<durationUnits.size(); j++) {
			try {
				durationUnits.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='Weeks']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='Weeks']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				durationUnits = durationUnits= driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration_unit'])"));
				durationUnits.get(j).click();
			}
		}

	}

	@Then("^fill comments for each Antimicrobial agents$")
	public void fill_comments_for_each_Antimicrobial_agents() throws Throwable
	{
		List<WebElement> comments =driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
		for (int j=0; j<comments.size(); j++) {
			try {
				comments.get(j).sendKeys("Antimicrobial Comments");
			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				comments = comments= driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
				comments.get(j).sendKeys(" Exception Antimicrobial Comments");
			}
		}
	}

	@Then("^validate each tabs of Antifungal agents$")
	public void validate_each_tabs_of_Antifungal_agents() throws Throwable 
	{
		List<WebElement> antifungagent= addpd.antifungalagent;
		// Instead of using the for each loop, get the size of the list and iterate through it
		for (int i=0; i<antifungagent.size(); i++) {
			try {
				antifungagent.get(i).click();

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				antifungagent = antifungagent= addpd.antifungalagent;
				antifungagent.get(i).click();
			}
		}
	}

	@Then("^each Antifungal agents name should be display$")
	public void each_Antifungal_agents_name_should_be_display() throws Throwable 
	{
		List<WebElement> menuLinks = driver.findElements(By.xpath("//*[@class='col-md-12 col-sm-12 col-xs-12 complaint_name allergies_fields_row_count ketoconazole_fields antifungal_agents_hide']/..//h5"));

		// Print the number of links present..
		System.out.println(menuLinks.size());
		for (WebElement option : menuLinks) {
			String linkName = option.getText();
			logger.info("****Antifungal agent must have this tab:" + linkName);
		}
	}

	@Then("^select Duration for each Antifungal agents$")
	public void select_Duration_for_each_Antifungal_agents() throws Throwable 
	{
		List<WebElement> duration=driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration'])"));
		for (int j=0; j<duration.size(); j++) {
			try {
				duration.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='4']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='4']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				duration = duration= driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration'])"));
				duration.get(j).click();
			}
		}
	}

	@Then("^select Duration Units for each Antifungal agents$")
	public void select_Duration_Units_for_each_Antifungal_agents() throws Throwable
	{

		List<WebElement> durationUnits=driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration_unit'])"));
		for (int j=0; j<durationUnits.size(); j++) {
			try {
				durationUnits.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='Weeks']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='Weeks']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				durationUnits = durationUnits= driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration_unit'])"));
				durationUnits.get(j).click();
			}
		}
	}

	@Then("^fill comments for each Antifungal agents$")
	public void fill_comments_for_each_Antifungal_agents() throws Throwable
	{
		List<WebElement> comments =driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
		for (int j=0; j<comments.size(); j++) {
			try {
				comments.get(j).sendKeys("Antifungal Comments");
			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				comments = comments= driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
				comments.get(j).sendKeys("Exception Antifungal Comments");
			}
		}
	}

	//********************* Antiviral Agents*******************************

	@Then("^validate each tabs of Antiviral Agents$")
	public void validate_each_tabs_of_Antiviral_Agents() throws Throwable
	{
		List<WebElement> antiviralagent= addpd.antiviralagent;
		// Instead of using the for each loop, get the size of the list and iterate through it
		for (int i=0; i<antiviralagent.size(); i++) {
			try {
				antiviralagent.get(i).click();

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				antiviralagent = antiviralagent= addpd.antiviralagent;
				antiviralagent.get(i).click();
			}
		}
	}

	@Then("^each Antiviral Agents name should be display$")
	public void each_Antiviral_Agents_name_should_be_display() throws Throwable 
	{
		List<WebElement> menuLinks = driver.findElements(By.xpath("//*[@class='col-md-12 col-sm-12 col-xs-12 complaint_name allergies_fields_row_count acyclovir_fields antiviral_agents_hide']/..//h5"));

		// Print the number of links present..
		System.out.println(menuLinks.size());
		for (WebElement option : menuLinks) {
			String linkName = option.getText();
			logger.info("****Antiviral agent must have this tab:" + linkName);
		}
	}

	@Then("^select Duration for each Antiviral Agents$")
	public void select_Duration_for_each_Antiviral_Agents() throws Throwable 
	{
		List<WebElement> duration=driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration'])"));
		for (int j=0; j<duration.size(); j++) {
			try {
				duration.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='4']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();


					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='4']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				duration = duration= driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration'])"));
				duration.get(j).click();
			}
		}
	}

	@Then("^select Duration Units for each Antiviral Agents$")
	public void select_Duration_Units_for_each_Antiviral_Agents() throws Throwable 
	{
		List<WebElement> durationUnits=driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration_unit'])"));
		for (int j=0; j<durationUnits.size(); j++) {
			try {
				durationUnits.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='Weeks']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='Weeks']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				durationUnits = durationUnits= driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration_unit'])"));
				durationUnits.get(j).click();
			}
		}
	}

	@Then("^fill comments for each Antiviral Agents$")
	public void fill_comments_for_each_Antiviral_Agents() throws Throwable 
	{
		List<WebElement> comments =driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
		for (int j=0; j<comments.size(); j++) {
			try {
				comments.get(j).sendKeys("Antiviral Comments");
			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				comments = comments= driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
				comments.get(j).sendKeys("Exception Comments");
			}
		}
	}
	//******************************* NSAIDS*************************************

	@Then("^validate each tabs of Nsaids$")
	public void validate_each_tabs_of_Nsaids() throws Throwable
	{
		List<WebElement> NSAID= addpd.nsaids;
		// Instead of using the for each loop, get the size of the list and iterate through it
		for (int i=0; i<NSAID.size(); i++) {
			try {
				NSAID.get(i).click();

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				NSAID = NSAID= addpd.nsaids;
				NSAID.get(i).click();
			}
		}
	}

	@Then("^each Nsaids name should be display$")
	public void each_Nsaids_name_should_be_display() throws Throwable 
	{
		List<WebElement> menuLinks = driver.findElements(By.xpath("//*[@class='col-md-12 col-sm-12 col-xs-12 complaint_name allergies_fields_row_count paracetamol_fields nsaids_hide']/..//h5"));

		// Print the number of links present..
		System.out.println(menuLinks.size());
		for (WebElement option : menuLinks) {
			String linkName = option.getText();
			logger.info("****NSAIDS must have this tab:" + linkName);
		}
	}


	@Then("^select Duration for each Nsaids$")
	public void select_Duration_for_each_Nsaids() throws Throwable 
	{
		List<WebElement> duration=driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration'])"));
		for (int j=0; j<duration.size(); j++) {
			try {
				duration.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='4']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='4']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				duration = duration= driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration'])"));
				duration.get(j).click();
			}
		}
	}

	@Then("^select Duration Units for each Nsaids$")
	public void select_Duration_Units_for_each_Nsaids() throws Throwable 
	{
		List<WebElement> durationUnits=driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration_unit'])"));
		for (int j=0; j<durationUnits.size(); j++) {
			try {
				durationUnits.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='Weeks']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='Weeks']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				durationUnits = durationUnits= driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration_unit'])"));
				durationUnits.get(j).click();
			}
		}
	}

	@Then("^fill comments for each Nsaids$")
	public void fill_comments_for_each_Nsaids() throws Throwable
	{
		List<WebElement> comments =driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
		for (int j=0; j<comments.size(); j++) {
			try {
				comments.get(j).sendKeys("Nsaids Comments");
			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				comments = comments= driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
				comments.get(j).sendKeys("Exception Nsaids Comments");
			}
		}
	}
	//******************************** Eye Drops *************************************

	@Then("^validate each tabs of Eye Drops$")
	public void validate_each_tabs_of_Eye_Drops() throws Throwable 
	{
		List<WebElement> EyeDrop= addpd.eyedrops;
		// Instead of using the for each loop, get the size of the list and iterate through it
		for (int i=0; i<EyeDrop.size(); i++) {
			try {
				EyeDrop.get(i).click();

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				EyeDrop = EyeDrop= addpd.eyedrops;
				EyeDrop.get(i).click();
			}
		}
	}

	@Then("^each Eye Drops name should be display$")
	public void each_Eye_Drops_name_should_be_display() throws Throwable
	{
		List<WebElement> menuLinks = driver.findElements(By.xpath("//*[@class='col-md-12 col-sm-12 col-xs-12 complaint_name allergies_fields_row_count tropicamide_p_fields eye_drops_hide']/..//h5"));

		// Print the number of links present..
		System.out.println(menuLinks.size());
		for (WebElement option : menuLinks) {
			String linkName = option.getText();
			logger.info("****Eye Drops must have this tab:" + linkName);
		}
	}


	@Then("^select Duration for each Eye Drops$")
	public void select_Duration_for_each_Eye_Drops() throws Throwable 
	{
		List<WebElement> duration=driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration'])"));
		for (int j=0; j<duration.size(); j++) {
			try {
				duration.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='4']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='4']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				duration = duration= driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration'])"));
				duration.get(j).click();
			}
		}
	}

	@Then("^select Duration Units for each Eye Drops$")
	public void select_Duration_Units_for_each_Eye_Drops() throws Throwable
	{
		List<WebElement> durationUnits=driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration_unit'])"));
		for (int j=0; j<durationUnits.size(); j++) {
			try {
				durationUnits.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='Weeks']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='Weeks']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				durationUnits = durationUnits= driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration_unit'])"));
				durationUnits.get(j).click();
			}
		}
	}

	@Then("^fill comments for each Eye Drops$")
	public void fill_comments_for_each_Eye_Drops() throws Throwable 
	{
		List<WebElement> comments =driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
		for (int j=0; j<comments.size(); j++) {
			try {
				comments.get(j).sendKeys("Eye Drop Comments");
			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				comments = comments= driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
				comments.get(j).sendKeys("Exception Eye Drop Comments");
			}
		}
	}

	//**************************Contact Allergies *******************************

	@Then("^validate each tabs of Contact Allergies$")
	public void validate_each_tabs_of_Contact_Allergies() throws Throwable 
	{
		List<WebElement> ContactAllergies= addpd.contactAllergiesTab;
		// Instead of using the for each loop, get the size of the list and iterate through it
		for (int i=0; i<ContactAllergies.size(); i++) {
			try {
				ContactAllergies.get(i).click();

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				ContactAllergies = ContactAllergies= addpd.contactAllergiesTab;
				ContactAllergies.get(i).click();
			}
		}
	}

	@Then("^each Contact Allergies name should be display$")
	public void each_Contact_Allergies_name_should_be_display() throws Throwable 
	{

		List<WebElement> menuLinks = driver.findElements(By.xpath("//*[@class='col-md-12 col-sm-12 col-xs-12 complaint_name allergies_fields_row_count alcohol_fields contact_allergies_hide']/..//h5"));

		// Print the number of links present..
		System.out.println(menuLinks.size());
		for (WebElement option : menuLinks) {
			String linkName = option.getText();
			logger.info("****Contact Allergy must have this tab:" + linkName);
		}

	}
	@Then("^select Duration for each Contact Allergies$")
	public void select_Duration_for_each_Contact_Allergies() throws Throwable 
	{
		List<WebElement> duration=driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration'])"));
		for (int j=0; j<duration.size(); j++) {
			try {
				duration.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='4']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='4']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				duration = duration= driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration'])"));
				duration.get(j).click();
			}
		}
	}

	@Then("^select Duration Units for each Contact Allergies$")
	public void select_Duration_Units_for_each_Contact_Allergies() throws Throwable 
	{
		List<WebElement> durationUnits=driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration_unit'])"));
		for (int j=0; j<durationUnits.size(); j++) {
			try {
				durationUnits.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='Weeks']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='Weeks']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				durationUnits = durationUnits= driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration_unit'])"));
				durationUnits.get(j).click();
			}
		}
	}

	@Then("^fill comments for each Contact Allergies$")
	public void fill_comments_for_each_Contact_Allergies() throws Throwable
	{
		List<WebElement> comments =driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
		for (int j=0; j<comments.size(); j++) {
			try {
				comments.get(j).sendKeys("Contact Allergies Comments");
			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				comments = comments= driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
				comments.get(j).sendKeys("Exception Contact Allergies Comments");
			}
		}
	}

	//********************* Food Allergies *******************************

	@Then("^validate each tabs of Food Allergies$")
	public void validate_each_tabs_of_Food_Allergies() throws Throwable 
	{
		List<WebElement> FoodAllergies= addpd.foodAllergiesTab;
		// Instead of using the for each loop, get the size of the list and iterate through it
		for (int i=0; i<FoodAllergies.size(); i++) {
			try {
				FoodAllergies.get(i).click();

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				FoodAllergies = FoodAllergies= addpd.foodAllergiesTab;
				FoodAllergies.get(i).click();
			}
		}
	}

	@Then("^each Food Allergies name should be display$")
	public void each_Food_Allergies_name_should_be_display() throws Throwable 
	{
		List<WebElement> menuLinks = driver.findElements(By.xpath("//*[@class='col-md-12 col-sm-12 col-xs-12 complaint_name allergies_fields_row_count all_seafood_fields food_allergies_hide']/..//h5"));

		// Print the number of links present..
		System.out.println(menuLinks.size());
		for (WebElement option : menuLinks) {
			String linkName = option.getText();
			logger.info("****Food Allergies must have this tab:" + linkName);
		}	
	}

	@Then("^select Duration for each Food Allergies$")
	public void select_Duration_for_each_Food_Allergies() throws Throwable 
	{
		List<WebElement> duration=driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration'])"));
		for (int j=0; j<duration.size(); j++) {
			try {
				duration.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='4']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='4']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				duration = duration= driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration'])"));
				duration.get(j).click();
			}
		}
	}

	@Then("^select Duration Units for each Food Allergies$")
	public void select_Duration_Units_for_each_Food_Allergies() throws Throwable 
	{
		List<WebElement> durationUnits=driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration_unit'])"));
		for (int j=0; j<durationUnits.size(); j++) {
			try {
				durationUnits.get(j).click();

				List<WebElement> dropdownvalue=driver.findElements(By.xpath("//*[text()='Weeks']"));
				for (int k=0; k<dropdownvalue.size(); k++) {
					try {
						dropdownvalue.get(k).click();

					} catch (StaleElementReferenceException e) {
						// If the exception occurs, find the elements again and click on it
						dropdownvalue = dropdownvalue= driver.findElements(By.xpath("//*[text()='Weeks']"));
						dropdownvalue.get(k).click();
					}
				}

			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				durationUnits = durationUnits= driver.findElements(By.xpath("(//*[@class='form-control allergy_field_add_field allergy_duration_unit'])"));
				durationUnits.get(j).click();
			}
		}
	}

	@Then("^fill comments for each Food Allergies$")
	public void fill_comments_for_each_Food_Allergies() throws Throwable 
	{
		List<WebElement> comments =driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
		for (int j=0; j<comments.size(); j++) {
			try {
				comments.get(j).sendKeys("Food Allergies Comments");
			} catch (StaleElementReferenceException e) {
				// If the exception occurs, find the elements again and click on it
				comments = comments= driver.findElements(By.xpath("//input[@class='form-control personal_field_add_comment']"));
				comments.get(j).sendKeys("Exception Food Allergies Comments");
			}
		}
	}

	//**********************Appointment Details*******************************//

	@Then("^validate Walkin type radio buttom autoselected$")
	public void validate_Walkin_type_radio_buttom_autoselected() throws Throwable
	{	
		WebElement option1 = driver.findElement(By.id("appointmenttype_walkin"));								
		// Check whether the Check box is toggled on 		
		if (option1.isSelected()) {					
			System.out.println("Checkbox is Toggled On");	
			logger.info("***********Walkin Type radio button is autoselected************");

		} else {			
			System.out.println("Checkbox is Toggled Off");	
			logger.info("***********Appointment Type radio button is autoselected************");
		}		
	}

	@Then("^validate Appointment Date and Time$")
	public void validate_Appointment_Date_and_Time() throws Throwable
	{
		String date =driver.findElement(By.id("appointment_appointmentdate")).getAttribute("value");
		logger.info("***********Appointment Date----->" + date);
		String time =driver.findElement(By.id("appointment_time")).getAttribute("value");
		logger.info("***********Appointment Date----->" + time);

	}

	@Then("^validate location drop down$")
	public void validate_location_drop_down() throws Throwable 
	{
		//driver.findElement(By.xpath("//*[@id='select2-appointment_facility_id-container']")).click();

		//commonMethods.logger.info("*********Salution Values are-->");
	}

	@Then("^validate Doctor drop down$")
	public void validate_Doctor_drop_down() throws Throwable 
	{

	}

	@Then("^select Appointment Types$")
	public void select_Appointment_Types() throws Throwable
	{

	}

	@Then("^select Appointment Category$")
	public void select_Appointment_Category() throws Throwable 
	{

	}


	/////------------------------------------Patient Setting for Mandatory Fields   ----------------------------------------------//


	@When("^user clicks on profile setting button$")
	public void user_clicks_on_profile_setting_button() throws Throwable {

		driver.findElement(By.id("setting_n_logout")).click();
		commonMethods.normalWait(1000);
	}

	@Then("^clicks on organisation setting link$")
	public void clicks_on_organisation_setting_link() throws Throwable {
		driver.findElement(By.xpath("//*[@href='/admins/organisation_settings']")).click();
		commonMethods.normalWait(1000);
	}

	@Then("^clicks on Patient Setting link from the left panel menu$")
	public void clicks_on_Patient_Setting_link_from_the_left_panel_menu() throws Throwable {
		driver.findElement(By.xpath("//*[@href='#manage_patient_form_settings']")).click();
		commonMethods.normalWait(1500);
	}

	@Then("^it should display below buttons$")
	public void it_should_display_below_buttons(DataTable arg1) throws Throwable {
		//addpd =new AddPatientDetails(driver);
		List<String> listData = arg1.asList(String.class);
		int index = 0;
		for (WebElement element : addpd.patientsetting) {
			Assert.assertEquals(element.getText(), listData.get(index));
			index++;
			logger.info("****Patient Setting must have below tabs:" + element.getText());	
		}
	}

	@Then("^validate mandatory field setting$")
	public void validate_mandatory_field_setting() throws Throwable {
		String xpath = "(((//*[@class='row'])[7]/..//div)[5]/div/..//div/div/input)[";
		String fullXpath;
		List<WebElement> element= driver.findElements(By.xpath("((//*[@class='row'])[7]/..//div)[5]/div/..//input"));
		for(int i=3;i<=element.size();i++)
		{
			fullXpath = xpath+i+"]";
			WebElement element1 = driver.findElement(By.xpath(fullXpath));
			commonMethods.clickElementByElement(element1);			
			commonMethods.normalWait(300);
			driver.findElement(By.xpath("(//*[text()='Save'])[2]")).click();
			for(int j=0;j<1;j++)
			{
				driver.findElement(By.xpath("(//*[@id='opd_navigation'])[2]")).click();
				//addpd =new AddPatientDetails(driver);
				addpd.clickAdd_btn();
				logger.info("*****click on Add button******");
				addpd.click_Add_New_Patient_btn();
				addpd.clickappointmentbtn();
				logger.info("*****Without filling mandatory field clicking on Appointment button******");
				String warnmsgclor=driver.findElement(By.xpath("//*[text()='First Name']")).getCssValue("color");

				if(warnmsgclor.contains("rgba(51, 51, 51, 1)"))
				{
					Reporter.addStepLog("The warning mesage is highlighting in RED color if user not filling the mandatory fields-->SUCCESS");
					logger.info("*****The warning mesage is highlighting in RED color if user not filling the mandatory fields******");
					commonMethods.normalWait(2000);
					commonMethods.clickElementByXpath("//*[text()='Close']");
					commonMethods.normalWait(1500);
					commonMethods.expwait("//*[@class='fa-color user_logo']/..//i");
				}
				else
				{
					Reporter.addStepLog("The warning mesage is highlighting in RED color if user not filling the mandatory fields-->DEFECT");
					logger.info("*****The warning mesage is not showing in RED color if user not filling the mandatory fields******");
				}
			}
			//Test clicks on profile button
			commonMethods.expwait("//*[@class='fa-color user_logo']/..//i");
			commonMethods.normalWait(1500);
			driver.findElement(By.id("setting_n_logout")).click();
			logger.info("***********User click on Menu Setting button***********");
			commonMethods.normalWait(1000);
			driver.findElement(By.xpath("//*[@href='/admins/organisation_settings']")).click();
			logger.info("***********User click on Organisation Setting button***********");
			commonMethods.normalWait(1000);
			driver.findElement(By.xpath("//*[@href='#manage_patient_form_settings']")).click();
			logger.info("***********User click on Patient Setting button***********");
			commonMethods.normalWait(1500);
		}

	}





}
