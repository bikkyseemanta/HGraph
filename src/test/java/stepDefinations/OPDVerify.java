package stepDefinations;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.*;
import pageObjects.AddPatientDetails;
import pageObjects.LoginPage;
import utilities.Common_Methods;
import utilities.WebConnector;

public class OPDVerify extends CommonSteps {

	Logger logger = Logger.getLogger("setting");

	public OPDVerify() {

		driver =  WebConnector.driver;
		commonMethods = new Common_Methods(driver);
		lp = new LoginPage(driver);
		addpd = new AddPatientDetails(driver, commonMethods);
		PropertyConfigurator.configure("Log4j.properties");
	}

	@Then("^fill patient details  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void fill_patient_details(String uname, String pswd, String Firstname, String Mobno, String Lastname, String Email, String language, String Pincode, String Ref, String Comment1, String Comment2, String Comment3, String Comment4, String Comment5, String Comment6) throws Throwable {
		fillpatientDetails(uname, pswd, Firstname, Mobno, Lastname, Email, language, Pincode, Ref, Comment1, Comment2, Comment3,Comment4,Comment5,Comment6);

	}

	@Then("^validate mobile field \"([^\"]*)\" \"([^\"]*)\"$")
	public void validate_mobile_field(String Mobno, String note) throws Throwable {
		/*commonMethods.expwait("//div[@id='patient-details']/div[4]/div[3]");
		logger.info(driver.findElement(By.xpath("//span[contains(@class,'appointment_not_arrived_list_count')]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='patient-details']/div[4]/div[3]")).getText(), Mobno);
		logger.info("Mobile no verified");
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Breastfeeding')]")).isDisplayed());
		logger.info("One Eyed verified");
		Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'One Eyed')]")).isDisplayed());
		logger.info("Special status verified as Breastfeeding");
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='patient-summary-timeline-link']")).isDisplayed());
		logger.info("Summary Button displaying in top right side");
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='btn btn-info navbar-btn navbar-btn-hover']")).isDisplayed());
		logger.info("Print Button displaying in top right side");
		Assert.assertTrue(driver.findElement(By.xpath("//button[@class='btn btn-info navbar-btn navbar-btn-hover']")).isDisplayed());
		logger.info("Report Button displaying in top right side");
		Assert.assertTrue(driver.findElement(By.xpath("//label[@class='label label-success']")).isDisplayed());
		logger.info("No Receipt found should show");
		Assert.assertTrue(driver.findElement(By.xpath("//button[@class='btn btn-xs btn-success dropdown-toggle opd-invoice']")).isDisplayed());
		logger.info("Receipt button should show");
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='appointment-details']")).isDisplayed());
		logger.info("Appointment Details by default selected");
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='btn btn-success btn-success-transparent btn-xs']")).isDisplayed());
		logger.info(" Edit Appointment button is should show");
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='btn btn-primary btn-primary-transparent btn-xs pull-right']")).isDisplayed());
		logger.info("Schedule Admission button should present");
		//Assert.assertTrue(driver.findElement(By.xpath("//button[@class='btn btn-primary btn-primary-transparent btn-surgery_advised btn-xs pull-right']")).isDisplayed());
		//logger.info("Surgery Advised button should present");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//input[@id='submit_patient_note']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Assert.assertTrue(driver.findElement(By.xpath("//a[@title='Reschedule Appointment']")).isDisplayed());
		logger.info("Reschedule button should present");
		Assert.assertTrue(driver.findElement(By.xpath("//a[@title='Cancel Appointment']")).isDisplayed());
		logger.info("Cancel button should present");
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='btn btn-info btn-xs btn-info-transparent']")).isDisplayed());
		logger.info("Upload Paper button should present");
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='btn btn-info btn-xs pull-right']")).isDisplayed());
		logger.info("Schedule OT button should present");

		//LHS
		List<WebElement> appointment_tabs = driver.findElements(By.xpath("//*[@class='row no_margin appointment_tabs']/..//li"));
		// Print the number of links present..
		logger.info("No of Appointment tabs on LHS:" + appointment_tabs.size());
				for (WebElement tabs : appointment_tabs) {
					String tabName = tabs.getText();
					logger.info("List of Appointment tabs on LHS:" + tabName);
				}*/
		commonMethods.expwait("//*[text()='Mark Patient Arrived']");		
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Mark Patient Arrived']")).isDisplayed());
		logger.info("Mark Patient button should present");
		driver.findElement(By.xpath("//*[text()='Mark Patient Arrived']")).click();
		logger.info("User marked as Patient Arrived");
		commonMethods.expwait("//*[text()='Select Token']");
		driver.findElement(By.xpath("//*[text()='Skip Without Token']")).click();
		logger.info("User Skipped without Token");
		//After Patient Arrived


		commonMethods.expwait("//span[contains(text(),'Send To :')]");

		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Send To :')]")).isDisplayed());
		logger.info("Send to should displayed");
		commonMethods.expwait("//a[@class='btn btn-xs btn-success mark-completed']");
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='btn btn-xs btn-success mark-completed']")).isDisplayed());
		logger.info("After Patient Arrived Mark as Completed button shpould display");

		//Count no of roles in Send To
		/*
		List<WebElement> SendTo_tabs = driver.findElements(By.xpath("//*[@class='col-xs-10 no_padding']/..//div/div"));
		logger.info("No of Appointment tabs on LHS:" + SendTo_tabs.size());
		for (WebElement tabs : SendTo_tabs) {
			String tabName = tabs.getText();
			logger.info("List of Send To Tabs :" + tabName);
		}

		//Count no of Receptionist
		commonMethods.expwait("//button[contains(@class, 'receptionist')]");
		driver.findElement(By.xpath("//button[contains(@class, 'receptionist')]")).click();
		List<WebElement> Reception_count = driver.findElements(By.xpath("(//*[@class='dropdown-menu'])[4]/..//li"));
		logger.info(" Total No of Receptionist in the Hospitals: " + Reception_count.size());
		for (WebElement count : Reception_count) {
			String no_of_Receptionist = count.getText();
			logger.info("List of Receptionist in the Hospital :" + no_of_Receptionist);
		}

		//Count no of Optometrist

		commonMethods.expwait("//button[contains(@class, 'optometrist')]");
		driver.findElement(By.xpath("//button[contains(@class, 'optometrist')]")).click();
		List<WebElement> Optometrist_count = driver.findElements(By.xpath("(//*[@class='dropdown-menu'])[5]/..//li"));
		logger.info(" Total No of Optometrist in the Hospitals: " + Optometrist_count.size());
		for (WebElement count : Optometrist_count) {
			String no_of_Optometrist = count.getText();
			logger.info("List of Optometrist in the Hospital :" + no_of_Optometrist);
		}

		//Count no of Doctor

		commonMethods.expwait("//button[contains(@class, 'doctor')]");
		driver.findElement(By.xpath("//button[contains(@class, 'doctor')]")).click();
		List<WebElement> Doctor_count = driver.findElements(By.xpath("(//*[@class='dropdown-menu'])[6]/..//li"));
		logger.info(" Total No of Doctor in the Hospitals: " + Doctor_count.size());
		for (WebElement count : Doctor_count) {
			String no_of_Doctor = count.getText();
			logger.info("List of Doctors in the Hospital :" + no_of_Doctor);
		}

		//Count no of Nurse

		commonMethods.expwait("//button[contains(@class, 'nurse')]");
		driver.findElement(By.xpath("//button[contains(@class, 'nurse')]")).click();
		List<WebElement> Nurse_count = driver.findElements(By.xpath("(//*[@class='dropdown-menu'])[7]/..//li"));
		logger.info(" Total No of Nurse in the Hospitals: " + Nurse_count.size());
		for (WebElement count : Nurse_count) {
			String no_of_Nurse = count.getText();
			logger.info("List of Nurse in the Hospital :" + no_of_Nurse);
		}

		//Count no of Counsellor

		commonMethods.expwait("//button[contains(@class, 'counsellor')]");
		driver.findElement(By.xpath("//button[contains(@class, 'counsellor')]")).click();
		List<WebElement> Counseller_count = driver.findElements(By.xpath("(//*[@class='dropdown-menu'])[8]/..//li"));
		logger.info(" Total No of Counsellor in the Hospitals: " + Counseller_count.size());
		for (WebElement count : Counseller_count) {
			String no_of_Counseller = count.getText();
			logger.info("List of Counsellor in the Hospital :" + no_of_Counseller);
		}

		//Count no of Floor Manager

		commonMethods.expwait("//button[contains(@class, 'floormanager')]");
		driver.findElement(By.xpath("//button[contains(@class, 'receptionist')]")).click();
		List<WebElement> Floor_Manager_count = driver.findElements(By.xpath("(//*[@class='dropdown-menu'])[9]/..//li"));
		logger.info(" Total No of Floor Managers in the Hospitals: " + Floor_Manager_count.size());
		for (WebElement count : Floor_Manager_count) {
			String no_of_FM = count.getText();
			logger.info("List of Floor Managers in the Hospital :" + no_of_FM);
		}

		//Count no of AR NCT

		commonMethods.expwait("//button[contains(@class, 'ar_nct')]");
		driver.findElement(By.xpath("//button[contains(@class, 'ar_nct')]")).click();
		List<WebElement> ArNCT_count = driver.findElements(By.xpath("(//*[@class='dropdown-menu'])[10]/..//li"));
		logger.info(" Total No of AR NCT in the Hospitals: " + ArNCT_count.size());
		for (WebElement count : ArNCT_count) {
			String no_of_ArNCT = count.getText();
			logger.info("List of AR NCT in the Hospital :" + no_of_ArNCT);
		}

		//Count no of Cashier

		commonMethods.expwait("//button[contains(@class, 'cashier')]");
		driver.findElement(By.xpath("//button[contains(@class, 'cashier')]")).click();
		List<WebElement> Cashier_count = driver.findElements(By.xpath("(//*[@class='dropdown-menu'])[11]/..//li"));
		logger.info(" Total No of Cashiers in the Hospitals: " + Cashier_count.size());
		for (WebElement count : Cashier_count) {
			String no_of_Cashier = count.getText();
			logger.info("List of Cashiers in the Hospital :" + no_of_Cashier);
		}

		//Count no of Departments

		commonMethods.expwait("//button[contains(@class, 'department')]");
		driver.findElement(By.xpath("//button[contains(@class, 'department')]")).click();
		List<WebElement> Dept_count = driver.findElements(By.xpath("(//*[@class='dropdown-menu'])[12]/..//li"));
		logger.info(" Total No of Departments in the Hospitals: " + Dept_count.size());
		for (WebElement count : Dept_count) {
			String no_of_Departments = count.getText();
			logger.info("List of Departments in the Hospital :" + no_of_Departments);
		}*/

		// Reception added some note 
		commonMethods.expwait("//textarea[@id='patient_note_textarea']");
		driver.findElement(By.xpath("//textarea[@id='patient_note_textarea']")).sendKeys(note);
		driver.findElement(By.xpath("//input[@id='submit_patient_note']")).click();

		// Before Send to HGDUMMYDOC
		commonMethods.expwait("//button[contains(@class, 'doctor')]");
		driver.findElement(By.xpath("//button[contains(@class, 'doctor')]")).click();
		String oldcount= driver.findElement(By.xpath("(//label[@class='label label-primary'])[5]")).getText();
		int beforesent = Integer.parseInt(oldcount);
		logger.info("No of patients in queue before sending patient to doctor: " + beforesent);
		//Receptionist queue

		String before_queue= driver.findElement(By.xpath("//span[@class='appointment_my_queue_list_count']")).getText();
		int oldno = Integer.parseInt(before_queue);
		logger.info("No of patients in Receptionist queue before sending patient to doctor: " + oldno);

		// Send to doctor
		driver.findElement(By.xpath("//span[contains(text(),'hgdummydoc')]")).click();
		// After send to doctor
		commonMethods.expwait("//button[contains(@class, 'doctor')]");
		driver.findElement(By.xpath("//button[contains(@class, 'doctor')]")).click();
		commonMethods.normalWait(1000);
		/*		String newcount= driver.findElement(By.xpath("(//label[@class='label label-primary'])[5]")).getText();
		int aftersent = Integer.parseInt(newcount);
		logger.info("No of patients in queue after sending patient to doctor: " + aftersent);

		//After Receptionist Queue

		String after_queue= driver.findElement(By.xpath("//span[@class='appointment_my_queue_list_count']")).getText();
		int newno = Integer.parseInt(after_queue);
		logger.info("No of patients in Receptionist queue after sending patient to doctor: " + newno);*/

		driver.findElement(By.xpath("//i[@class='fa fa-user-md']")).click();
		driver.findElement(By.xpath("//a[@class='rightnav-link']")).click();
		//driver.navigate().to("http://ppehr.healthgraph.in/users/login");
		commonMethods.expwait("//input[@id='session_username']");


	}

	//                                    Doctor Login                      //

	@When("^doctor login \"([^\"]*)\" and \"([^\"]*)\"$")
	public void doctor_login_and(String uname, String pswd) throws Throwable 
	{
		driver.findElement(By.xpath("//input[@id='session_username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys(pswd);
		driver.findElement(By.xpath("//input[@id='signinbutton']")).click();
		logger.info("Doctor successfully logged into the account");
	}

	@Then("^Doctor verify some details of patient$")
	public void doctor_verify_some_details_of_patient() throws Throwable
	{
		commonMethods.expwait("//button[@id='adverse_event_form']");
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='adverse_event_form']")).isDisplayed());
		logger.info("Adverse Event button should present");
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs btn-case-details']")).isDisplayed());
		logger.info("Case Details should present");
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Note: If Counsellor Note or Admission')]")).isDisplayed());
		logger.info("Counsellor Note or Admission text should present");
		Assert.assertTrue(driver.findElement(By.xpath("//h4[contains(text(),'Template Details')]")).isDisplayed());
		logger.info("Template Details text should present");
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='opd-templates']")).isDisplayed());
		logger.info("New Template button should present");
		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Consolidate Reports')]")).isDisplayed());
		logger.info("Consolidated Report button should present");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//a[@class='btn btn-info btn-xs pull-right']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	@When("^Doctor create Optom Template \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void doctor_create_Optom_Template(String Comment1, String Comment2, String Comment3, String Comment4, String Comment5, String Comment6, String input) throws Throwable 
	{
		commonMethods.expwait("//*[text()='Template Details']");
		int no = driver.findElements(By.xpath("//div[@id = 'appointment_my_queue_list']/div")).size();
		logger.info("No of Patients in 'My Queue' :"+ no );
		commonMethods.normalWait(500);
		driver.findElement(By.xpath("(//div[@id = 'appointment_my_queue_list']/div)["+no+"]")).click();
		logger.info("Doctor open recent patient");
		commonMethods.normalWait(500);
		//commonMethods.expwait("//button[@id='opd-templates']");
		driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
		commonMethods.expwait("//a[text()=' Optometrist ']");
		driver.findElement(By.xpath("//a[text()=' Optometrist ']")).click();
		logger.info("User Selected Optometrist Template");
		commonMethods.expwait("//*[contains(text(),'Optometrist:')]");
		//driver.findElement(By.xpath("")).click();
		//commonMethods.expwait("(//li[@class='select2-results__option'])[2]");
		//logger.info("Select OPtometrist as 'HG Optom1'");
		//driver.findElement(By.xpath("(//li[@class='select2-results__option'])[2]")).click();

		//verify selected all History details should show in History tab
		commonMethods.expwait("//button[@id='speciality_histories_glaucoma']");
		/*		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='speciality_histories_glaucoma']")).isSelected());
		logger.info("Selection of Opthal History Glaucoma verified");
		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Breastfeeding')]")).isSelected());
		logger.info("Special status 'Breast feeding' verified");
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='drug_allergies_antimicrobial_agents']")).isSelected());
		logger.info("Selection Drug Allergy'Antimicrobial agent' verified");
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='antimicrobial_agents_ampicillin']")).isSelected());
		logger.info("Selection of Antimicrobial agent 'Ampicilin' verified");
		System.out.println(driver.findElement(By.xpath("//input[@id='opdrecord_speciality_history_records_attributes_0_comment']")).getAttribute("value"));
		System.out.println(driver.findElement(By.xpath("//input[@id='opdrecord_speciality_history_records_attributes_0_comment']")).getAttribute("value"));
		Assert.assertEquals(Comment1, driver.findElement(By.xpath("//input[@id='opdrecord_speciality_history_records_attributes_0_comment']")).getAttribute("value"));
		logger.info("Opthal History comments verified");
		Assert.assertEquals(Comment2, driver.findElement(By.xpath("//textarea[@id='opdrecord_opthal_history_comment']")).getText());
		logger.info("Opthal History comments verified");
		Assert.assertEquals(Comment3, driver.findElement(By.xpath("//input[@id='opdrecord_others_allergies']")).getAttribute("value"));
		Assert.assertEquals(Comment4, driver.findElement(By.xpath("//input[@id='opdrecord_others_allergies']")).getAttribute("value"));
		Assert.assertEquals(Comment5, driver.findElement(By.xpath("//input[@id='opdrecord_others_allergies']")).getAttribute("value"));
		Assert.assertEquals(Comment6, driver.findElement(By.xpath("//input[@id='opdrecord_others_allergies']")).getAttribute("value"));

		// Entering Vital Signs

		driver.findElement(By.xpath("//input[@id='opdrecord_vital_signs_temperature']")).sendKeys(input);
		driver.findElement(By.xpath("//input[@id='opdrecord_vital_signs_pulse']")).sendKeys(input);
		driver.findElement(By.xpath("//input[@id='opdrecord_vital_signs_bp']")).sendKeys(input);
		driver.findElement(By.xpath("//input[@id='opdrecord_vital_signs_rr']")).sendKeys(input);
		driver.findElement(By.xpath("//input[@id='opdrecord_anthropometry_height']")).sendKeys(input);
		driver.findElement(By.xpath("//input[@id='opdrecord_anthropometry_weight']")).sendKeys(input);
		logger.info("Doctor filled all Vital Signs");*/
		driver.findElement(By.xpath("//li[@id='refraction_step']")).click();
		logger.info("Refraction tab selected");
		
	}

	@Then("^Doctor fills Auto Refraction values$")
	public void doctor_fills_Auto_Refraction_values() throws Throwable
	{

		commonMethods.expwait("(//i[@class='fa fa-arrow-circle-right filldatabutton '])[1]");
		driver.findElement(By.xpath("(//i[@class='fa fa-arrow-circle-right filldatabutton '])[1]")).click();
		logger.info("Doctor clicked on Auto-Refraction Fill button");
		commonMethods.expwait("//h4[text()='AUTO REFRACTION']");
		// Filling right side values of table 
		int Right_totalRow = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr")).size();
		int Right_totalCol = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr[1]/td")).size();
		String[][] RightValues = new String[4][3];
		for(int i = 1; i<=Right_totalRow; i++) {
			for(int j=2; j<=Right_totalCol; j++) {
				//driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).click();
				//System.out.println("["+(i-1)+"]["+(j-2)+"]");

				if(j==2) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_sph'])[1]")).click();
					RightValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_sph'])[1]")).getAttribute("input-value");
				} else if(j==3) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_cyl'])[1]")).click();
					RightValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_cyl'])[1]")).getAttribute("input-value");
				} else if(j==4) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_axis'])[1]")).click();
					RightValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_axis'])[1]")).getAttribute("input-value");
				}
				//System.out.println(driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).getText());
				//rodValues[i-1][j-2]=driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).getText();

			}
		}
		for (int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				logger.info("The values filled by Doctor for Auto-Refraction :" + RightValues[i][j]);
			}
		}

		// Filling left side values of table 

		int Left_totalRow = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 l-eye-column']/div/table[@class='table table-bordered']/tbody/tr")).size();
		int Left_totalCol = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 l-eye-column']/div/table[@class='table table-bordered']/tbody/tr[1]/td")).size();
		String[][] LeftValues = new String[4][3];
		for(int i = 1; i<=Left_totalRow; i++) {
			for(int j=2; j<=Left_totalCol; j++) {

				if(j==2) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_sph'])[1]")).click();
					LeftValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_sph'])[1]")).getAttribute("input-value");
				} else if(j==3) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_cyl'])[1]")).click();
					LeftValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_cyl'])[1]")).getAttribute("input-value");
				} else if(j==4) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_axis'])[1]")).click();
					LeftValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_axis'])[1]")).getAttribute("input-value");
				}

			}
		}
		for (int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				logger.info("The values filled by Doctor for Auto-Refraction :" + LeftValues[i][j]);
			}
		}
		driver.findElement(By.xpath("//button[@id='fill-refraction-modal']")).click();
		logger.info("Doctor successfully filled all Auto Refraction values");
		
	}

	@Then("^Doctor fills Dry Refraction values \"([^\"]*)\"$")
	public void doctor_fills_Dry_Refraction_values(String arg1) throws Throwable 
	{
		commonMethods.expwait("(//i[@class='fa fa-arrow-circle-right filldatabutton '])[2]");
		driver.findElement(By.xpath("(//i[@class='fa fa-arrow-circle-right filldatabutton '])[2]")).click();
		logger.info("fill button clicked");
		commonMethods.expwait("//h4[text()='DRY REFRACTION']");
		// Filling right side values of table 
		int Right_totalRow = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr")).size();
		int Right_totalCol = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr[1]/td")).size();
		String[][] RightValues = new String[4][3];
		for(int i = 1; i<=Right_totalRow; i++) {
			for(int j=2; j<=Right_totalCol; j++) {
				if(j==2) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_distant_sph'])[1]")).click();
					RightValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_distant_sph'])[1]")).getAttribute("input-value");
				} else if(j==3) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_distant_cyl'])[1]")).click();
					RightValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_distant_cyl'])[1]")).getAttribute("input-value");
				} else if(j==4) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_distant_axis'])[1]")).click();
					RightValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_distant_axis'])[1]")).getAttribute("input-value");
				}else if(j==5) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_distant_vision'])[1]")).click();
					RightValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_distant_vision'])[1]")).getAttribute("input-value");
				}
				
			}
		}
		for (int i=0; i<3; i++) {
			for(int j=0; j<4; j++) {
				logger.info("The values filled by Doctor for Dry-Refraction :" + RightValues[i][j]);
			}
		}

		// Filling left side values of table 

		int Left_totalRow = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 l-eye-column']/div/table[@class='table table-bordered']/tbody/tr")).size();
		int Left_totalCol = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 l-eye-column']/div/table[@class='table table-bordered']/tbody/tr[1]/td")).size();
		String[][] LeftValues = new String[4][3];
		for(int i = 1; i<=Left_totalRow; i++) {
			for(int j=2; j<=Left_totalCol; j++) {
				if(j==2) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_distant_sph'])[1]")).click();
					LeftValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_distant_sph'])[1]")).getAttribute("input-value");
				} else if(j==3) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_cyl'])[1]")).click();
					LeftValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_cyl'])[1]")).getAttribute("input-value");
				} else if(j==4) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_axis'])[1]")).click();
					LeftValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_axis'])[1]")).getAttribute("input-value");
				} else if(j==5) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_distant_vision'])[1]")).click();
					RightValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_distant_vision'])[1]")).getAttribute("input-value");
				}
			}
		}
		for (int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				System.out.println(LeftValues[i][j]);
			}
		}	
		driver.findElement(By.xpath("//button[@id='fill-refraction-modal']")).click();
		logger.info("Doctor successfully filled all Dry Refraction values");
	}

	@Then("^Doctor fills Refraction dialated values \"([^\"]*)\"$")
	public void doctor_fills_Refraction_dialated_values(String arg1) throws Throwable 
	{
		commonMethods.expwait("(//i[@class='fa fa-arrow-circle-right filldatabutton '])[3]");
		driver.findElement(By.xpath("(//i[@class='fa fa-arrow-circle-right filldatabutton '])[3]")).click();
		logger.info("fill button clicked");
		commonMethods.expwait("//h4[text()='DILATED REFRACTION']");
		// Filling right side values of table 
		int Right_totalRow = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr")).size();
		int Right_totalCol = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr[1]/td")).size();
		String[][] RightValues = new String[4][3];
		for(int i = 1; i<=Right_totalRow; i++) {
			for(int j=2; j<=Right_totalCol; j++) {
				//driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).click();
				System.out.println("["+(i-1)+"]["+(j-2)+"]");

				if(j==2) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_sph'])[1]")).click();
					RightValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_sph'])[1]")).getAttribute("input-value");
				} else if(j==3) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_cyl'])[1]")).click();
					RightValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_cyl'])[1]")).getAttribute("input-value");
				} else if(j==4) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_axis'])[1]")).click();
					RightValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_axis'])[1]")).getAttribute("input-value");
				}
				//System.out.println(driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).getText());
				//rodValues[i-1][j-2]=driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).getText();

			}
		}
		System.out.println("-------------");
		for (int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				System.out.println(RightValues[i][j]);
				logger.info("");
			}
		}

		// Filling left side values of table 

		int Left_totalRow = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 l-eye-column']/div/table[@class='table table-bordered']/tbody/tr")).size();
		int Left_totalCol = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 l-eye-column']/div/table[@class='table table-bordered']/tbody/tr[1]/td")).size();
		String[][] LeftValues = new String[4][3];
		for(int i = 1; i<=Left_totalRow; i++) {
			for(int j=2; j<=Left_totalCol; j++) {
				//driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).click();
				System.out.println("["+(i-1)+"]["+(j-2)+"]");

				if(j==2) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_sph'])[1]")).click();
					LeftValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_sph'])[1]")).getAttribute("input-value");
				} else if(j==3) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_cyl'])[1]")).click();
					LeftValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_cyl'])[1]")).getAttribute("input-value");
				} else if(j==4) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_axis'])[1]")).click();
					LeftValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_axis'])[1]")).getAttribute("input-value");
				}
				//System.out.println(driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).getText());
				//rodValues[i-1][j-2]=driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).getText();

			}
		}
		System.out.println("-------------");
		for (int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				System.out.println(LeftValues[i][j]);
			}
		}					
	}

	@Then("^Doctor fills PGP values$")
	public void doctor_fills_PGP_values() throws Throwable
	{
		commonMethods.expwait("(//i[@class='fa fa-arrow-circle-right filldatabutton '])[4]");
		driver.findElement(By.xpath("(//i[@class='fa fa-arrow-circle-right filldatabutton '])[3]")).click();
		logger.info("fill button clicked");
		commonMethods.expwait("//h4[text()='PGP']");
		// Filling right side values of table 
		int Right_totalRow = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr")).size();
		int Right_totalCol = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr[1]/td")).size();
		String[][] RightValues = new String[4][3];
		for(int i = 1; i<=Right_totalRow; i++) {
			for(int j=2; j<=Right_totalCol; j++) {
				//driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).click();
				System.out.println("["+(i-1)+"]["+(j-2)+"]");

				if(j==2) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_sph'])[1]")).click();
					RightValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_sph'])[1]")).getAttribute("input-value");
				} else if(j==3) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_cyl'])[1]")).click();
					RightValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_cyl'])[1]")).getAttribute("input-value");
				} else if(j==4) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_axis'])[1]")).click();
					RightValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_axis'])[1]")).getAttribute("input-value");
				}
				//System.out.println(driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).getText());
				//rodValues[i-1][j-2]=driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).getText();

			}
		}
		System.out.println("-------------");
		for (int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				System.out.println(RightValues[i][j]);
				logger.info("");
			}
		}

		// Filling left side values of table 

		int Left_totalRow = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 l-eye-column']/div/table[@class='table table-bordered']/tbody/tr")).size();
		int Left_totalCol = driver.findElements(By.xpath("//div[@class='col-md-6 col-sm-6 l-eye-column']/div/table[@class='table table-bordered']/tbody/tr[1]/td")).size();
		String[][] LeftValues = new String[4][3];
		for(int i = 1; i<=Left_totalRow; i++) {
			for(int j=2; j<=Left_totalCol; j++) {
				//driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).click();
				System.out.println("["+(i-1)+"]["+(j-2)+"]");

				if(j==2) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_sph'])[1]")).click();
					LeftValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_sph'])[1]")).getAttribute("input-value");
				} else if(j==3) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_cyl'])[1]")).click();
					LeftValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_cyl'])[1]")).getAttribute("input-value");
				} else if(j==4) {
					driver.findElement(By.xpath("(//button[@name = 'refraction_axis'])[1]")).click();
					LeftValues[i-1][j-2] = driver.findElement(By.xpath("(//button[@name = 'refraction_axis'])[1]")).getAttribute("input-value");
				}
				//System.out.println(driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).getText());
				//rodValues[i-1][j-2]=driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6 r-eye-column']/div/table[@class='table table-bordered']/tbody/tr["+i+"]/td["+j+"]")).getText();

			}
		}
		System.out.println("-------------");
		for (int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				System.out.println(LeftValues[i][j]);
			}
		}
		driver.findElement(By.xpath("//button[@id='fill-refraction-modal']")).click();
		logger.info("Doctor successfully filled all PGP values");
	
		
	}

	@Then("^Doctor fills Glasses prescription \"([^\"]*)\"$")
	public void doctor_fills_Glasses_prescription(String arg1) throws Throwable {

	}

	@Then("^Doctor fills Intermediate Glasses prescription \"([^\"]*)\"$")
	public void doctor_fills_Intermediate_Glasses_prescription(String arg1) throws Throwable {

	}

	@Then("^Doctor fills PMT$")
	public void doctor_fills_PMT() throws Throwable {

	}





}
