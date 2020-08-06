package stepDefinations;

import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AddPatientDetails;
import pageObjects.LoginPage;
import utilities.Common_Methods;
import utilities.WebConnector;

public class setting extends CommonSteps{
	
	Logger logger = Logger.getLogger("setting");
	
	public setting() {
		
		driver =  WebConnector.driver;
		commonMethods = new Common_Methods(driver);
		lp = new LoginPage(driver);
		addpd = new AddPatientDetails(driver, commonMethods);
		PropertyConfigurator.configure("Log4j.properties");
		}
		
		@Then("^click on Setting button and go to Practise Setting$")
		public void click_on_Setting_button_and_go_to_Practise_Setting() throws Throwable
		{
			commonMethods.expwait("//*[@class='fa-color user_logo']");
			driver.findElement(By.xpath("//*[@class='fa-color user_logo']")).click();
			commonMethods.normalWait(1000);
			driver.findElement(By.xpath("//*[@href='/doctors/practice_settings']")).click();
			logger.info("User click on Practise Setting");
			commonMethods.expwait("//*[contains(text(),'Select Default View')]");
		}

		@Then("^clicks on Default view and validate the functionality$")
		public void clicks_on_Default_view_and_validate_the_functionality() throws Throwable 
		{
			//Validate the Default setting list page should display
			String note=driver.findElement(By.xpath("//*[contains(text(),'Select Default View')]")).getText();
			if(note.contains("Select Default View"))
			{
				logger.info("On the click of defult setting select default view page is displaying-->PASS");
			}
			else
			{
				commonMethods.logger.info("On the click of defult setting select default view page is not displaying-->DEFECT");
			}

			//Validate Adminstration Department view
			commonMethods.normalWait(3000);
			commonMethods.clickElementByXpath("(//*[@name='user_selected_url'])[1]");
			commonMethods.normalWait(2000);
			driver.findElement(By.xpath("//*[@class='fa-color user_logo']/..//i")).click();
			commonMethods.expwait("//*[@href='/users/logout']");
			driver.findElement(By.xpath("//*[@href='/users/logout']")).click();
			commonMethods.expwait("//*[@placeholder='Username']");
			driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("hgdummydoc");
			driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("HGraph@2$2$");
			driver.findElement(By.xpath("//*[@value='LOGIN']")).click();
			commonMethods.expwait("(//h4[text()='Others'])[1]");
			//validate dash board page
			if(driver.findElement(By.xpath("(//h4[text()='Others'])[1]")).isDisplayed())
			{
				logger.info("Adminstration Department validation successfully-->PASS"); 
			}
			else
			{
				logger.info("Adminstration Department is not validate successfully-->DEFECT"); 
			}

			//OT Department
			driver.findElement(By.xpath("//*[@class='fa-color user_logo']")).click();
			commonMethods.normalWait(1000);
			driver.findElement(By.xpath("//*[@href='/doctors/practice_settings']")).click();
			commonMethods.expwait("//*[contains(text(),'Select Default View')]");
			commonMethods.normalWait(3000);
			commonMethods.clickElementByXpath("(//*[@name='user_selected_url'])[2]");
			commonMethods.normalWait(2000);
			driver.findElement(By.xpath("//*[@class='fa-color user_logo']/..//i")).click();
			commonMethods.expwait("//*[@href='/users/logout']");
			driver.findElement(By.xpath("//*[@href='/users/logout']")).click();
			commonMethods.expwait("//*[@placeholder='Username']");
			driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("hgdummydoc");
			driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("HGraph@2$2$");
			driver.findElement(By.xpath("//*[@value='LOGIN']")).click();
			String highlightcolor=driver.findElement(By.xpath("//*[@class='common-li-class web_responsive activate']")).getCssValue("border-bottom");
			System.out.println(highlightcolor);
			//validate dash board page
			if(highlightcolor.equals("3px solid rgb(60, 193, 255)"))
			{
				commonMethods.logger.info("OT validation successfully-->PASS"); 
			}
			else
			{
				commonMethods.logger.info("OTt is not validate successfully-->DEFECT"); 
			}

			//Outpatient Department
			driver.findElement(By.xpath("//*[@class='fa-color user_logo']")).click();
			commonMethods.normalWait(1000);
			driver.findElement(By.xpath("//*[@href='/doctors/practice_settings']")).click();
			commonMethods.expwait("//*[contains(text(),'Select Default View')]");
			commonMethods.normalWait(3000);
			commonMethods.clickElementByXpath("(//*[@name='user_selected_url'])[3]");
			commonMethods.normalWait(2000);
			driver.findElement(By.xpath("//*[@class='fa-color user_logo']/..//i")).click();
			commonMethods.expwait("//*[@href='/users/logout']");
			driver.findElement(By.xpath("//*[@href='/users/logout']")).click();
			commonMethods.expwait("//*[@placeholder='Username']");
			driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("hgdummydoc");
			driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("HGraph@2$2$");
			driver.findElement(By.xpath("//*[@value='LOGIN']")).click();
			String highlightcolor1=driver.findElement(By.xpath("//*[@class='common-li-class web_responsive activate']")).getCssValue("border-bottom");
			System.out.println(highlightcolor1);
			//validate dash board page
			if(highlightcolor1.equals("3px solid rgb(60, 193, 255)"))
			{
		        commonMethods.logger.info("OPD validation successfully-->PASS"); 
			}
			else
			{
				commonMethods.logger.info("OPD is not validate successfully-->DEFECT"); 
			}		
			driver.findElement(By.xpath("//*[@class='fa-color user_logo']")).click();
			commonMethods.expwait("//*[@href='/doctors/practice_settings']");
			driver.findElement(By.xpath("//*[@href='/doctors/practice_settings']")).click();
			commonMethods.expwait("//*[contains(text(),'Select Default View')]");
			commonMethods.normalWait(3000);
			commonMethods.clickElementByXpath("(//*[@name='user_selected_url'])[4]");
			commonMethods.normalWait(3000);
			driver.findElement(By.xpath("//*[@class='fa-color user_logo']/..//i")).click();
			commonMethods.expwait("//*[@href='/users/logout']");
			driver.findElement(By.xpath("//*[@href='/users/logout']")).click();
			commonMethods.expwait("//*[@placeholder='Username']");
			driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("hgdummydoc");
			driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("HGraph@2$2$");
			driver.findElement(By.xpath("//*[@value='LOGIN']")).click();
			String highlightcolor2=driver.findElement(By.xpath("//*[@class='common-li-class web_responsive activate']")).getCssValue("border-bottom");
			System.out.println(highlightcolor2);
			//validate dash board page
			if(highlightcolor2.equals("3px solid rgb(60, 193, 255)"))
			{
				commonMethods.logger.info("IPD validation successfully-->PASS"); 
			}
			else
			{
		        commonMethods.logger.info("IPD is not validate successfully-->DEFECT"); 
			}
		}	
		@When("^clicks on Clinical from the left panel menu$")
		public void clicks_on_Clinical_from_the_left_panel_menu() throws Throwable

		{ 
			commonMethods.expwait("//a[@id='submenu-clinical']");
			driver.findElement(By.xpath("//a[@id='submenu-clinical']")).click();
			commonMethods.expwait("//ul[@id='setsAndListSettingSubmenu']");
			List<WebElement> clinical=driver.findElements(By.xpath("//ul[@id='setsAndListSettingSubmenu']/..//li"));
			for(int i=0;i<clinical.size();i++)
			{
				logger.info(clinical.get(i).getText());
			}
		}

		@Then("^click on Advice Sets and validate functionality\"([^\"]*)\"$")
		public void click_on_Advice_Sets_and_validate_functionality(String name) throws Throwable
		{
			driver.findElement(By.xpath("//*[text()='Advice Sets']")).click();
			commonMethods.expwait("//*[text()='Advice Sets Name']");
			driver.findElement(By.xpath("//*[@href=\"/advice_sets/new?level=user\"]")).click();
			commonMethods.expwait("//*[text()='Advice Set']");
			driver.findElement(By.xpath("//*[@name='advice_set[name]']")).sendKeys("Test Automation");
			driver.findElement(By.xpath("//*[@name='advice_set[specialty_id]']")).click();		
			driver.findElement(By.xpath("//*[@name='advice_set[specialty_id]']/..//option[text()='Ophthalmology']")).click();
			driver.findElement(By.xpath("//*[@name='advice_set[lcid_code][]']/..//option[text()='English']")).click();
			driver.findElement(By.xpath("(//*[@class='note-editable panel-body'])[1]")).sendKeys(name);
			driver.findElement(By.xpath("(//*[@name='commit'])[2]")).click();
			commonMethods.expwait("(//*[@id='advice-set-list_filter']/..//input)[2]");
			logger.info("Successfully a new Advice Set Created");
			driver.findElement(By.xpath("(//*[@id='advice-set-list_filter']/..//input)[2]")).sendKeys(name);
			if(driver.findElement(By.xpath("//*[text()='"+name+"']")).isDisplayed())
			{
				logger.info("Newly created Advice Set is showing in Search results-->PASS");
			}
			else
			{
				 logger.info("Newly created Advice Set is not showing in Search results-->DEFECT");
			}
		}

		@Then("^navigate to OPD and create one Appointment$")
		public void navigate_to_OPD_and_create_one_Appointment() throws Throwable 
		{
			commonMethods.clickElementByXpath("(//*[@id='opd_navigation'])[2]");
			addpd =new AddPatientDetails(driver, commonMethods);
			addpd.clickAdd_btn();
			commonMethods.logger.info("click on Add button");
			addpd.click_Add_New_Patient_btn();
			addpd.fillFirstName("Biswajit");
			addpd.fillMobNo("9861929608");
			commonMethods.logger.info("User entered mandatory fields such as First name and Mob no"); 
			addpd.clickappointmentbtn();		
		}

		@When("^mark patient as Arrived go to Eye Template\"([^\"]*)\"$")
		public void mark_patient_as_Arrived_go_to_Eye_Template(String name) throws Throwable 
		{
			commonMethods.expwait("//*[text()='Mark Patient Arrived']");
			driver.findElement(By.xpath("//*[text()='Mark Patient Arrived']")).click();
			logger.info("User marked as Patient Arrived");
			commonMethods.expwait("//*[text()='Select Token']");
			driver.findElement(By.xpath("//*[text()='Skip Without Token']")).click();
			logger.info("User Skipped without Token");
			commonMethods.expwait("//*[text()='Template Details']");
			driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
			List<WebElement> template=driver.findElements(By.xpath("//*[@aria-labelledby='opd-templates-dropdown']/..//li"));
			for(int i=0;i<template.size();i++)
			{
				logger.info("List of Template Details under 'New' button :"+ template.get(i).getText());
				try {
					if(template.contains("Eye")) {
						template.get(i).click();
						commonMethods.logger.info("User Selected Eye Template");
					}}
				catch(Exception e)
				{
					logger.info("User not Selected Eye Template");
				}		
			}
			driver.findElement(By.xpath("//a[@data_templatetype='eye']")).click();
			logger.info("User Selected Eye Template");
			commonMethods.expwait("//li[@id='advice_step']");
			driver.findElement(By.xpath("//li[@id='advice_step']")).click();
			logger.info("User clicked on Advice Step");
			commonMethods.expwait("//a[@href='#advice']");
			driver.findElement(By.xpath("//a[@href='#advice']")).click();
			logger.info("User clicked on Advice tab under Advice Step");
			driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--single'])[24]")).click();
			logger.info("User clicked on Advice & Precaution button");
			driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(name);

			List<WebElement> advice =driver.findElements(By.xpath("//ul[@id='select2-advice_sets_option-results']"));
			for(int i=0;i<advice.size();i++)
			{
				String advicelist=advice.get(i).getText();
				if(advicelist.contains(name))
				{
					logger.info("Advice set Searched data is displaying in auto suggestion text box");
					advice.get(i).click();
					commonMethods.normalWait(1000);
					String visiblecomment=driver.findElement(By.xpath("//*[@id='advice-set-content-summernote']")).getText();
					if(visiblecomment.contains(name))
					{
						logger.info("The data displaying in advice set comments is same as user given text");
					}
					else
					{
						logger.info("The data displaying in advice set comments is not same as user given text");
					}

				}
				else
				{
					logger.info("Advice set Searched data is not displaying in auto suggestion text box");
				}
			}

		}
		   //                                      Advice Set                                                 //
		  ///////////                    Validate Medical Certificate Template                          ///////

		@Then("^click on User Note and validate the New Template$")
		public void click_on_User_Note_and_validate_the_New_Template() throws Throwable
		{
			driver.findElement(By.xpath("//a[@href='#user_notes_templates']")).click();
			logger.info("User clicked on User Note tab");
		}

		@Then("^create Medical Certificate Template \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void create_Medical_Certificate_Template(String name, String Heading, String Subject, String Content) throws Throwable 
		{
			commonMethods.expwait("//*[@class='pull-right']/..//a");
			commonMethods.clickElementByXpath("//*[@class='pull-right']/..//a");
	        logger.info("User clicked on New Template button");
			commonMethods.expwait("//*[text()='Create Medical Certificate Template']");
			driver.findElement(By.xpath("//input[@id='user_notes_template_name']")).sendKeys(name);
			driver.findElement(By.xpath("//input[@id='user_notes_template_template_details_category']")).sendKeys(Heading);
			driver.findElement(By.xpath("//input[@id='user_notes_template_template_details_medical_subject']")).sendKeys(Subject);
			driver.findElement(By.xpath("//*[@class='note-editable panel-body']")).sendKeys(Content);
			driver.findElement(By.xpath("//*[@name='user_notes_template[specialty_id]']")).click();
			commonMethods.expwait("//*[@name='user_notes_template[specialty_id]']/..//option[2]");
			logger.info("User selected Opthalmology Speciality");
			driver.findElement(By.xpath("//*[@name='user_notes_template[specialty_id]']/..//option[2]")).click();
			driver.findElement(By.xpath("(//*[@name='commit'])[2]")).click();
			logger.info("User successfully created new Medical Certificate having name:" +name);
			commonMethods.expwait("(//*[@aria-controls='certificate-template-list'])[2]");
			commonMethods.normalWait(500);
		}

		@Then("^verify created Medical certificate should display in Template \"([^\"]*)\"$")
		public void verify_created_Medical_certificate_should_display_in_Template(String name) throws Throwable 
		{
			driver.findElement(By.xpath("(//*[@aria-controls='certificate-template-list'])[2]")).sendKeys(name);
			commonMethods.logger.info("User is searching the created Medical Certificate");
			commonMethods.expwait("((//tbody/tr[1])[3]/td)[1]");
			String searchresult=driver.findElement(By.xpath("((//tbody/tr[1])[3]/td)[1]")).getText();
			commonMethods.normalWait(500);
			if(searchresult.equals(name))
			{
				logger.info("Created Medical Certificate Template is showing in Search Result");
			}else
			{
				logger.info("Created Medical Certificate Template is not showing in Search Result");
			}
		}

		@When("^user deleted that template its should not display under template \"([^\"]*)\"$")
		public void user_deleted_that_template_its_should_not_display_under_template(String name) throws Throwable 
		{      		   
			commonMethods.expwait("(//*[@class='btn btn-danger btn-xs'])[1]");
			driver.findElement(By.xpath("(//*[@class='btn btn-danger btn-xs'])[1]")).click();
			commonMethods.expwait("(//*[text()='Are you sure?'])[1]");
			driver.findElement(By.xpath("(//*[text()='Confirm'])[1]")).click();
		}

		@Then("^create again new Medical Certificate Template \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void create_again_new_Medical_Certificate_Template(String newname, String Heading1, String Subject1, String Content1) throws Throwable 
		{
			commonMethods.expwait("//*[@class='pull-right']/..//a");
			commonMethods.clickElementByXpath("//*[@class='pull-right']/..//a");
			logger.info("User again clicked on New Template button for verifying created MEdical Certificate should display in patient Summary page");
			commonMethods.expwait("//*[text()='Create Medical Certificate Template']");
			driver.findElement(By.xpath("//input[@id='user_notes_template_name']")).sendKeys(newname);

			driver.findElement(By.xpath("//*[@name='user_notes_template[specialty_id]']")).click();
			commonMethods.expwait("//*[@name='user_notes_template[specialty_id]']/..//option[2]");
			driver.findElement(By.xpath("//*[@name='user_notes_template[specialty_id]']/..//option[2]")).click();
			logger.info("User selected Opthalmology Speciality");
			driver.findElement(By.xpath("//input[@id='user_notes_template_template_details_category']")).sendKeys(Heading1);
			driver.findElement(By.xpath("//input[@id='user_notes_template_template_details_medical_subject']")).sendKeys(Subject1);
			driver.findElement(By.xpath("//*[@class='note-editable panel-body']")).sendKeys(Content1);
			driver.findElement(By.xpath("(//*[@name='commit'])[2]")).click();
			logger.info("User again successfully created new Medical Certificate having name:" +newname);
			commonMethods.expwait("(//*[@id='opd_navigation'])[2]");
		}

		@Then("^validate created Medical Certificate template should display Patient Summary page \"([^\"]*)\"$")
		public void validate_created_Medical_template_should_display_Patient_Summary_page(String name) throws Throwable 
		{
			commonMethods.clickElementByXpath("(//*[@id='opd_navigation'])[2]");
			addpd =new AddPatientDetails(driver, commonMethods);
			addpd.clickAdd_btn();
			logger.info("click on Add button");
			addpd.click_Add_New_Patient_btn();
			addpd.fillFirstName("Biswajit");
			addpd.fillMobNo("9861929608");
			logger.info("User entered mandatory fields such as First name and Mob no"); 
			addpd.clickappointmentbtn();
			commonMethods.expwait("//button[text()='Summary']");
			driver.findElement(By.xpath("//button[text()='Summary']")).click();
			commonMethods.expwait("(//button[@id='print-admission-dropdown'])[1]");
			driver.findElement(By.xpath("(//button[@id='print-admission-dropdown'])[1]")).click();
			List<WebElement> list = driver.findElements(By.xpath("//ul[@class='dropdown-menu children nopadding_dropdown']/..//li"));
			for(int i=0;i<list.size();i++)
			{
				String advicelist=list.get(i).getText();
				if(advicelist.contains(name))
				{
					logger.info("Created Medical Certificate Template is displaying under certificates");
				}
				else
				{
					logger.info("Created Medical Certificate Template is not displaying under certificates");
				}
			}

		}
	             ///////////                    Validate Referral Message Template                          ///////
		
		@Then("^create Referal Message Template \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void create_Referal_Certificate_Template(String name, String Heading, String Subject, String Content) throws Throwable 
		{
			commonMethods.expwait("//*[@class='pull-right']/..//a");
			
			commonMethods.clickElementByXpath("//*[@class='pull-right']/..//a");
			commonMethods.logger.info("User clicked on New Template");
			
			commonMethods.expwait("//*[text()='Create Medical Certificate Template']");
			logger.info("User is on Medical Certificate Template");
			
			//Select Type
			driver.findElement(By.xpath("//*[@name='user_notes_template[type]']")).click();
			commonMethods.expwait("//*[@name='user_notes_template[type]']/..//option[2]");
			driver.findElement(By.xpath("//*[@name='user_notes_template[type]']/..//option[2]")).click();
			commonMethods.expwait("//*[text()='Create Referral Message Template']");
			commonMethods.normalWait(500);
			logger.info("User changed to Referral Message Template");
			//Specility drop down
			driver.findElement(By.xpath("//*[@name='user_notes_template[specialty_id]']")).click();
			commonMethods.expwait("//*[@name='user_notes_template[specialty_id]']/..//option[2]");
			driver.findElement(By.xpath("//*[@name='user_notes_template[specialty_id]']/..//option[2]")).click();
			logger.info("User selected Opthalmology Speciality");
			driver.findElement(By.xpath("//input[@id='user_notes_template_name']")).sendKeys(name);
			driver.findElement(By.xpath("//input[@id='user_notes_template_template_details_category']")).sendKeys(Heading);
			driver.findElement(By.xpath("//input[@id='user_notes_template_template_details_medical_subject']")).sendKeys(Subject);
			driver.findElement(By.xpath("//*[@class='note-editable panel-body']")).sendKeys(Content);
			commonMethods.normalWait(1000);
			driver.findElement(By.xpath("(//*[@name='commit'])[2]")).click();
			logger.info("User successfully created Refferal Certificate Template having name:" +name);
			commonMethods.normalWait(1000);
		}

		@Then("^verify created Referal Message should display in Template \"([^\"]*)\"$")
		public void verify_created_Referal_certificate_should_display_in_Template(String name) throws Throwable 
		{   
			
			//Specility drop down
			driver.findElement(By.xpath("//*[@name='user_note_type']")).click();
			commonMethods.expwait("//*[@name='user_note_type']/..//option[2]");
			driver.findElement(By.xpath("//*[@name='user_note_type']/..//option[2]")).click();
			commonMethods.normalWait(1000);
					
			driver.findElement(By.xpath("(//*[@class='dataTables_filter']/..//input)[2]")).sendKeys(name);
			commonMethods.expwait("((//tbody/tr[1])[3]/td)[1]");
			String searchresult=driver.findElement(By.xpath("((//tbody/tr[1])[3]/td)[1]")).getText();
			commonMethods.normalWait(500);
			if(searchresult.equals(name))
			{
				logger.info("Created Referral Certificate is showing in Search Result");
			}else
			{
				logger.info("Created Referral Certificate is not showing in Search Result");
			}
		}

		@When("^user deleted that Referal Message its should not display under template \"([^\"]*)\"$")
		public void user_deleted_that_Referal_certificate_its_should_not_display_under_template(String arg1) throws Throwable 
		{
			commonMethods.expwait("(//*[@class='btn btn-danger btn-xs'])[1]");
			driver.findElement(By.xpath("(//*[@class='btn btn-danger btn-xs'])[1]")).click();
			commonMethods.expwait("(//*[text()='Are you sure?'])[1]");
			driver.findElement(By.xpath("(//*[text()='Confirm'])[1]")).click();
			commonMethods.normalWait(5000);
		}

		@Then("^create again new Referal Message Template \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void create_again_new_Referal_Certificate_Template(String newname, String Heading1, String Subject1, String Content1) throws Throwable 
		{
			//commonMethods.expwait("//*[@class='pull-right']/..//a");
			commonMethods.clickElementByXpath("//*[@class='pull-right']/..//a");
			commonMethods.expwait("//*[text()='Create Referral Message Template']");
			driver.findElement(By.xpath("//input[@id='user_notes_template_name']")).sendKeys(newname);
			driver.findElement(By.xpath("//*[@name='user_notes_template[specialty_id]']")).click();
			commonMethods.expwait("//*[@name='user_notes_template[specialty_id]']/..//option[2]");
			driver.findElement(By.xpath("//*[@name='user_notes_template[specialty_id]']/..//option[2]")).click();
			driver.findElement(By.xpath("//input[@id='user_notes_template_template_details_category']")).sendKeys(Heading1);
			driver.findElement(By.xpath("//input[@id='user_notes_template_template_details_medical_subject']")).sendKeys(Subject1);
			driver.findElement(By.xpath("//*[@class='note-editable panel-body']")).sendKeys(Content1);
			driver.findElement(By.xpath("(//*[@name='commit'])[2]")).click();
			commonMethods.expwait("(//*[@aria-controls='certificate-template-list'])[2]");
		}

		@Then("^validate created Referal Message template should display Patient Summary page \"([^\"]*)\"$")
		public void validate_created_Referal_template_should_display_Patient_Summary_page(String name) throws Throwable
		{
			commonMethods.clickElementByXpath("(//*[@id='opd_navigation'])[2]");
			addpd =new AddPatientDetails(driver, commonMethods);
			addpd.clickAdd_btn();
			logger.info("click on Add button");
			addpd.click_Add_New_Patient_btn();
			addpd.fillFirstName("Biswajit");
			addpd.fillMobNo("9861929608");
			logger.info("User entered mandatory fields such as First name and Mob no"); 
			addpd.clickappointmentbtn();
			commonMethods.expwait("//button[text()='Summary']");
			driver.findElement(By.xpath("//button[text()='Summary']")).click();
			logger.info("User click on Patient Summary Page");
			commonMethods.expwait("(//button[@id='print-admission-dropdown'])[1]");
			driver.findElement(By.xpath("(//button[@id='print-admission-dropdown'])[2]")).click();
			logger.info("User click on Refferal Message tab");
			List<WebElement> list = driver.findElements(By.xpath("//ul[@class='dropdown-menu children nopadding_dropdown']/..//li"));
			List<WebElement> list1 = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right children nopadding_dropdown']/..//li"));
			
			for(int i=0;i<list1.size();i++)
			{
				String advicelist=list1.get(i).getText();
				if(advicelist.contains(name))
				{
					logger.info("Created Refferal Message Template is displaying under Refferal Message tab");
				}
				else
				{
					logger.info("Created Refferral Message Template is not displaying under Refferal Message tab");
				}
			}

		}

		//////                            Medication Lists                                   /////////


		@Then("^click on Medications Lists and validate each tab$")
		public void click_on_Medications_Lists_and_validate_each_tab() throws Throwable
		{
			driver.findElement(By.xpath("//a[@href='#medicationlists']")).click();
			logger.info("User click on Medication Lists tab");
			commonMethods.expwait("//a[@href='/practice_medication_lists/add_medication_list?level=user']");
			Assert.assertEquals(driver.findElement(By.xpath("//a[@href='/practice_medication_lists/add_medication_list?level=user']")).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath("//a[@href='/practice_medication_lists/upload_medication_excel?level=user']")).isDisplayed(), true);
		    logger.info("User verifies the presence of 'Add Medication Lists' and 'Upload via Excel' button");
			driver.findElement(By.xpath("//a[@href='/practice_medication_lists/upload_medication_excel?level=user']")).click();
			logger.info("User clicked on Upload via Excel button");
			commonMethods.expwait("//*[text()='Upload Medication via Excel']");
			driver.findElement(By.xpath("(//button[@class='close'])[2]")).click();
			logger.info("User closed the Upload Medication via Excel pop up");
		}

		@When("^create Medication Lists \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void create_Medication_Lists(String MedicineName1, String GenericName1, String MedicineType1) throws Throwable
		{
			commonMethods.expwait("//a[@href='/practice_medication_lists/add_medication_list?level=user']");
			driver.findElement(By.xpath("//a[@href='/practice_medication_lists/add_medication_list?level=user']")).click();
			commonMethods.expwait("//b[contains(text(),'Add Medication List for ')]");
			driver.findElement(By.xpath("//input[@id='my_practice_medication_list_0_name']")).sendKeys(MedicineName1);
			logger.info("User entered Medicine Name");
			driver.findElement(By.xpath("//input[@id='my_practice_medication_list_0_contents']")).sendKeys(GenericName1);
			logger.info("User entered Generic Name");
			driver.findElement(By.xpath("//*[@id='select2-my_practice_medication_list_0_med_type-container']")).click();
			commonMethods.expwait("//*[@type='search']/..//input");
			driver.findElement(By.xpath("//*[@type='search']/..//input")).sendKeys(MedicineType1);
			driver.findElement(By.xpath("//li[text()='Tablets']")).click();
			logger.info("User entered Medicine Type as:" + MedicineType1);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			logger.info("User successfully created one Medication List");
		}

		@Then("^verify created Medication Lists should display in Medication Lists \"([^\"]*)\"$")
		public void verify_created_Medication_Lists_should_display_in_Medication_Lists(String MedicineName1) throws Throwable
		{
			commonMethods.expwait("//a[@href='/practice_medication_lists/add_medication_list?level=user']");
			driver.findElement(By.xpath("//input[@aria-controls='medication-list-table']")).sendKeys(MedicineName1);
			commonMethods.expwait("((//tbody/tr[1])[3]/td)[1]");
			commonMethods.normalWait(1000);
			String searchresult=driver.findElement(By.xpath("((//tbody/tr[1])[3]/td)[1]")).getText();
			if(searchresult.equals(MedicineName1))
			{
				logger.info("Created Medication List is showing in Search Result");
			}else
			{
				logger.info("Created Medication List is not showing in Search Result");
			}

		}

		@When("^user deleted that Medication List its should not display under template \"([^\"]*)\"$")
		public void user_deleted_that_Medication_List_its_should_not_display_under_template(String MedicineName1) throws Throwable 
		{
			commonMethods.expwait("(//*[@class='btn btn-danger btn-xs'])[1]");
			driver.findElement(By.xpath("(//*[@class='btn btn-danger btn-xs'])[1]")).click();
			commonMethods.expwait("(//*[text()='Are you sure?'])[1]");
			driver.findElement(By.xpath("(//*[text()='Confirm'])[1]")).click();
			logger.info("User successfully deleted created Medication List");
		}

		@Then("^create again new Medication Lists \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void create_again_new_Medication_Lists(String MedicineName, String GenericName, String MedicineType) throws Throwable
		{
			commonMethods.normalWait(1000);
			commonMethods.expwait("//a[@class='btn btn-success']");
			driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
			commonMethods.expwait("//b[contains(text(),'Add Medication List for ')]");
			driver.findElement(By.xpath("//input[@id='my_practice_medication_list_0_name']")).sendKeys(MedicineName);
			driver.findElement(By.xpath("//input[@id='my_practice_medication_list_0_contents']")).sendKeys(GenericName);
			driver.findElement(By.xpath("//*[@id='select2-my_practice_medication_list_0_med_type-container']")).click();
			commonMethods.expwait("//*[@type='search']/..//input");
			driver.findElement(By.xpath("//*[@type='search']/..//input")).sendKeys(MedicineType);
			driver.findElement(By.xpath("//li[text()='Lotion']")).click();
			logger.info("User entered Medicine Type as:" + MedicineType);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			commonMethods.logger.info("User successfully created one Medication List");
		}

		@Then("^validate created Medication List should display Patient Eye Template \"([^\"]*)\"$")
		public void validate_created_Medication_List_should_display_Patient_Eye_Template(String MedicineName) throws Throwable 
		{
			commonMethods.clickElementByXpath("(//*[@id='opd_navigation'])[2]");
			addpd =new AddPatientDetails(driver, commonMethods);
			addpd.clickAdd_btn();
			logger.info("click on Add button");
			addpd.click_Add_New_Patient_btn();
			addpd.fillFirstName("Biswajit");
			addpd.fillMobNo("9861929608");
			logger.info("User entered mandatory fields such as First name and Mob no"); 
			addpd.clickappointmentbtn();	
			commonMethods.expwait("//*[text()='Mark Patient Arrived']");
			driver.findElement(By.xpath("//*[text()='Mark Patient Arrived']")).click();
			logger.info("User marked as Patient Arrived");
			commonMethods.expwait("//*[text()='Select Token']");
			driver.findElement(By.xpath("//*[text()='Skip Without Token']")).click();
			logger.info("User Skipped without Token");
			commonMethods.expwait("//*[text()='Template Details']");
			driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
			List<WebElement> template=driver.findElements(By.xpath("//*[@aria-labelledby='opd-templates-dropdown']/..//li"));
			for(int i=0;i<template.size();i++)
			{
				logger.info("List of Template Details under 'New' button :"+ template.get(i).getText());
				try {
					if(template.contains("Eye")) {
						template.get(i).click();
						logger.info("User Selected Eye Template");
					}}
				catch(Exception e)
				{
					logger.info("User not Selected Eye Template");
				}		
			}
			driver.findElement(By.xpath("//a[@data_templatetype='eye']")).click();
			logger.info("User Selected Eye Template");
			commonMethods.expwait("//li[@id='advice_step']");
			driver.findElement(By.xpath("//li[@id='advice_step']")).click();
			logger.info("User clicked on Advice Step");
			commonMethods.expwait("//a[@href='#medication']");
			driver.findElement(By.xpath("//input[@id='opdrecord_treatmentmedication_attributes_0_medicinename']")).sendKeys(MedicineName);		
			List<WebElement> advice =driver.findElements(By.xpath("//ul[@id='select2-advice_sets_option-results']"));
			for(int i=0;i<advice.size();i++)
			{
				String advicelist=advice.get(i).getText();
				if(advicelist.contains(MedicineName))
				{
					logger.info("Medication Lists searched data is displaying in auto suggestion text box");
					advice.get(i).click();
					commonMethods.normalWait(1000);
					String visiblecomment=driver.findElement(By.xpath("//*[@id='advice-set-content-summernote']")).getText();
					if(visiblecomment.contains(MedicineName))
					{
						logger.info("The data displaying in advice set comments is same as user given text");
					}
					else
					{
						logger.info("The data displaying in advice set comments is not same as user given text");
					}

				}
				else
				{
					logger.info("Advice set Searched data is not displaying in auto suggestion text box");
				}
			}
		}

		//                                In Patient Procedure Note                                  //

		@Then("^click on In Patient Procedure Note and validate each tab$")
		public void click_on_In_Patient_Procedure_Note_and_validate_each_tab() throws Throwable 
		{
			driver.findElement(By.xpath("//a[@href='#manage_procedure_notes']")).click();
			logger.info("User click on In Patient Procedure Note tab");
			commonMethods.expwait("//a[@href='/procedure_notes/new?level=user']");
			Assert.assertEquals(driver.findElement(By.xpath("//a[@href='/procedure_notes/new?level=user']")).isDisplayed(), true);
			logger.info("User verifies the presence of 'Add Procedure Note' button");
		}

		@When("^create Procedure Note \"([^\"]*)\" \"([^\"]*)\"$")
		public void create_Procedure_Note(String ProcedureName1, String ProcedureNote1) throws Throwable 
		{
			driver.findElement(By.xpath("//a[@href='/procedure_notes/new?level=user']")).click();
			logger.info("User clicked on Add Procedure Note button");
			commonMethods.normalWait(1000);
	        commonMethods.expwait("//*[@id='procedure_note_name']");
	        driver.findElement(By.xpath("//*[@id='procedure_note_name']")).sendKeys(ProcedureName1);
			//////////////speciality
	        driver.findElement(By.xpath("//*[@id='procedure_note_specialty_id']")).click();
	        commonMethods.expwait("//*[@id='procedure_note_specialty_id']/..//option[2]");
	        driver.findElement(By.xpath("//*[@id='procedure_note_specialty_id']/..//option[2]")).click();
	        logger.info("User selected Opthalmology Speciality");
			driver.findElement(By.xpath("//*[@class='note-editable panel-body']")).sendKeys(ProcedureNote1);
			commonMethods.normalWait(500);
			driver.findElement(By.xpath("//input[@value='Save']")).click();
			logger.info("User successfully created a new Procedure Note");
			commonMethods.expwait("(//*[@aria-controls='procedure-note-list'])[2]");
			
		}

		@Then("^verify created Procedure Note name should display in Procedure Notes \"([^\"]*)\"$")
		public void verify_created_Procedure_Note_name_should_display_in_Procedure_Notes(String ProcedureName1) throws Throwable 
		{
			//commonMethods.expwait("//a[@href='/procedure_notes/new?level=user']");
			driver.findElement(By.xpath("(//*[@aria-controls='procedure-note-list'])[2]")).sendKeys(ProcedureName1);
			commonMethods.expwait("((//tbody/tr[1])[3]/td)[1]");
			commonMethods.normalWait(1000);
			String searchresult=driver.findElement(By.xpath("((//tbody/tr[1])[3]/td)[1]")).getText(); //--------------------------------------------------//
			if(searchresult.equals(ProcedureName1))
			{
				logger.info("Created Procedure Note is showing in Search Result");
			}else
			{
				logger.info("Created Procedure Note is not showing in Search Result");
			}

		}

		@When("^user deleted that Procedure Note name its should not display under template \"([^\"]*)\"$")
		public void user_deleted_that_Procedure_Note_name_its_should_not_display_under_template(String arg1) throws Throwable 
		{
			commonMethods.expwait("(//*[@class='btn btn-danger btn-xs'])[1]");
			driver.findElement(By.xpath("(//*[@class='btn btn-danger btn-xs'])[1]")).click();//Stale element error
			commonMethods.expwait("(//*[text()='Are you sure?'])[1]");
			driver.findElement(By.xpath("(//*[text()='Confirm'])[1]")).click();
			logger.info("User successfully deleted created Medication List");
		}

		@Then("^create again new Procedure Note \"([^\"]*)\" \"([^\"]*)\"$")
		public void create_again_new_Procedure_Note(String ProcedureName, String ProcedureNote) throws Throwable 
		{
			commonMethods.clickElementByXpath("//a[@href='/procedure_notes/new?level=user']");
			commonMethods.normalWait(1000);
			driver.findElement(By.xpath("//input[@id='procedure_note_name']")).sendKeys(ProcedureName);
			driver.findElement(By.xpath("//*[@class='note-editable panel-body']")).sendKeys(ProcedureNote);
			driver.findElement(By.xpath("//*[@id='procedure_note_specialty_id']")).click();
			commonMethods.normalWait(1000);
			driver.findElement(By.xpath("//*[text()='Ophthalmology']")).click();
			commonMethods.normalWait(1000);
			driver.findElement(By.xpath("//input[@value='Save']")).click();
			commonMethods.expwait("//*[@aria-controls='procedure-note-list']");
			logger.info("User successfully created a new Procedure Note");
		}

		@Then("^go to IPD and create an Appointment with mandatory fields$")
		public void go_to_IPD_and_create_an_Appointment_with_mandatory_fields() throws Throwable
		{
			driver.findElement(By.xpath("(//a[@id='ipd_navigation'])[2]")).click();
			addpd =new AddPatientDetails(driver, commonMethods);
			addpd.clickAdd_btn();
			logger.info("click on Add button");
			addpd.click_Add_New_Patient_btn();
			addpd.fillFirstName("Biswajit");
			addpd.fillMobNo("9861929608");
			commonMethods.normalWait(1000);
			driver.findElement(By.xpath("(//*[@name='admission[admission_type]']/..//label)[2]")).click();//select emergency 
			driver.findElement(By.xpath("//button[text()='Select Case']")).click();
			driver.findElement(By.xpath("(//*[@class='select2-selection select2-selection--single'])[6]")).click();//select case
			commonMethods.expwait("(//*[text()='Add New Case'])[2]");
			driver.findElement(By.xpath("(//*[text()='Add New Case'])[2]")).click();
			driver.findElement(By.xpath("//input[@value='Create Admission']")).click();
			driver.findElement(By.xpath("//button[text()='Close']")).click(); // close Assign Be pop up
			logger.info("User successfully created one Appointment"); 
				

		}

		@Then("^fill Admission Form and create new Oprative form$")
		public void fill_Admission_Form_and_create_new_Oprative_form() throws Throwable 
		{
	        commonMethods.expwait("//a[text()=' Admission']");
	        driver.findElement(By.xpath("//a[text()=' Admission']")).click();
	        logger.info("User opened Admission Form ");
	        commonMethods.normalWait(500);
	        commonMethods.expwait("(//input[@value='Save'])[2]");
	        commonMethods.clickElementByXpath("(//input[@value='Save'])[2]");
	        logger.info("User saved Admission Form");
	        commonMethods.expwait("//*[text()='Clinical Note']");//wait for clinical note 
	        //driver.findElement(By.xpath("//button[text()='Close']")).click(); //close clinical note
	        commonMethods.clickElementByXpath("(//button[text()='Close'])[2]");
	        commonMethods.expwait("(//button[@id='operative_form'])[2]");
	        driver.findElement(By.xpath("(//button[@id='operative_form'])[2]")).click();
	        logger.info("User click on Operative Form");// click on Operative
	        commonMethods.expwait("//a[@id='operative-note-btn']");
	        driver.findElement(By.xpath("//a[@id='operative-note-btn']")).click();
	        commonMethods.expwait("//*[text()='Operative Form']");//wait for opening operative form
	        driver.findElement(By.xpath("//li[text()=' Surgical Note']")).click();
	        
	        //click on surgical note	       	                      
		}

		@Then("^validate created Medication List should display in Surgical Note tab under Operative Form \"([^\"]*)\"$")
		public void validate_created_Medication_List_should_display_in_Surgical_Note_tab_under_Operative_Form(String ProcedureName) throws Throwable 
		{
			 commonMethods.expwait("//input[@placeholder='Search Surgical Notes (Ex: phac)']");
		     driver.findElement(By.xpath("//input[@placeholder='Search Surgical Notes (Ex: phac)']")).sendKeys(ProcedureName);
		    logger.info("User is searching created Medication List in Surgical Note Search field");
		   
		     List<WebElement> advice =driver.findElements(By.xpath("//*[@class='list-group-item-heading clearfix']"));
				for(int i=0;i<advice.size();i++)
				{
					String advicelist=advice.get(i).getText();
					if(advicelist.contains(ProcedureName))
					{
						logger.info("Created Medication List showing in Surgical Search field");
						advice.get(i).click();
						commonMethods.normalWait(1000);
						String visiblecomment=driver.findElement(By.xpath("(//*[@class='note-editable panel-body'])[1]")).getText();
						if(visiblecomment.contains(ProcedureName))
						{
							logger.info("The data displaying in Surgical Note is same as user given text");
						}
						else
						{
							logger.info("The data displaying in Surgical Note is not same as user given text");
						}

					}
					else
					{
						logger.info("Created Medication List showing in Surgical Search field");
					}
				}
		}

	               ///////////////////                       Opthal Sets                          ////////////     
		
		
		@Then("^click on Opthal Sets and validate each tab$")
		public void click_on_Opthal_Sets_and_validate_each_tab() throws Throwable
		{
	         driver.findElement(By.xpath("//*[@id='ophthal_sets_id']")).click();
		}

		@When("^create Opthal Lab Set \"([^\"]*)\"$")
		public void create_Opthal_Lab_Set(String arg1) throws Throwable 
		{
		   //driver.findElement(By.xpath("//*[@id='ophthal-lab-set']")).click();
		}

		@Then("^verify created Opthal Set name should display in Procedure Notes \"([^\"]*)\"$")
		public void verify_created_Opthal_Set_name_should_display_in_Procedure_Notes(String arg1) throws Throwable 
		{
		    
		}

		@When("^user deleted that Opthal Set name its should not display under template \"([^\"]*)\"$")
		public void user_deleted_that_Opthal_Set_name_its_should_not_display_under_template(String arg1) throws Throwable {
		   
		}

		@Then("^create again new Opthal Set \"([^\"]*)\"$")
		public void create_again_new_Opthal_Set(String SetName) throws Throwable 
		{
			commonMethods.expwait("//*[@id='ophthal-lab-set']");
			commonMethods.clickElementByXpath("//*[@id='ophthal-lab-set']");
			commonMethods.expwait("//*[text()='New Ophthal Laboratory Set']");
			driver.findElement(By.xpath("//input[@id='ophthal_laboratory_set_name']")).sendKeys(SetName);
			List<WebElement> Eye_Region = driver.findElements(By.xpath("//select[@name='eyearea[]']/..//option"));
			for(int i=0;i<Eye_Region.size()-1;i++) {
				String Eye_Region_List = Eye_Region.get(i).getText();
				commonMethods.logger.info("List of values under Eye Regions are:" + Eye_Region_List);
				Eye_Region.get(i).click();
				commonMethods.normalWait(2000);
				if(driver.findElement(By.xpath("//*[@id='investigation-eyearea-option']")).isDisplayed()) 
				{
					List<WebElement> Investigations = driver.findElements(By.xpath("//select[@id='investigation-eyearea-option']/..//option"));	
					for(int j=0;j<Investigations.size();j++) {
						String Investigation_List = Investigations.get(j).getText();
						commonMethods.logger.info("List of values under Investigations are:" + Investigation_List);
						Investigations.get(j).click();
						commonMethods.expwait("//button[@class='btn btn-danger btn-xs delete-row']");
					}
				}
			}
			driver.findElement(By.xpath("//button[text()='Close']")).click();
			logger.info("User successfully closed after creating one Opthal Set having name :" + SetName);
		}

		@When("^mark patient as Arrived go to Investigation tab under Eye Template$")
		public void mark_patient_as_Arrived_go_to_Investigation_tab_under_Eye_Template() throws Throwable 
		{
			commonMethods.expwait("//*[text()='Mark Patient Arrived']");
			commonMethods.clickElementByXpath("//*[text()='Mark Patient Arrived']");
			logger.info("User marked as Patient Arrived");
			commonMethods.expwait("//*[text()='Select Token']");
			driver.findElement(By.xpath("//*[text()='Skip Without Token']")).click();
			logger.info("User Skipped without Token");
			commonMethods.expwait("//*[text()='Template Details']");
			driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
			driver.findElement(By.xpath("//a[@data_templatetype='eye']")).click();
			commonMethods.logger.info("User Selected Eye Template");
			commonMethods.expwait("//li[@id='assesment_step']");
			
		}
		@Then("^validate created Opthal Set should display in Investigation tab under Eye Template \"([^\"]*)\"$")
		public void validate_created_Opthal_Set_should_display_in_Investigation_tab_under_Eye_Template(String SetName ) throws Throwable 
		{
			List<WebElement> OpthalSets = driver.findElements(By.xpath("//select[@id='ophthal_set']"));
			if(OpthalSets.contains(SetName)) {
				logger.info("Created Opthal Set:" + SetName + " is present in Eye Template Opthal Set");
			}else {
				logger.info("Created Opthal Set:" + SetName + " is not present in Eye Template Opthal Set");
			}
			
			driver.findElement(By.xpath("//button[text()='Close']")).click();
			logger.info("User closed Eye Template after validation");
			
		}
		
		@Then("^validate created Opthal Set should display in Investigation tab under QuickEye Template \"([^\"]*)\"$")
		public void validate_created_Opthal_Set_should_display_in_Investigation_tab_under_QuickEye_Template(String SetName) throws Throwable 
		{
			commonMethods.expwait("//*[text()='Template Details']");
			driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
			
			driver.findElement(By.xpath("//a[@data_templatetype='quickeye']")).click();
			logger.info("User Selected Quick Eye Template");
			commonMethods.expwait("//li[@id='assesment_step']");
			
			List<WebElement> OpthalSets = driver.findElements(By.xpath("//select[@id='ophthal_set']"));
			if(OpthalSets.contains(SetName)) {
				logger.info("Created Opthal Set:" + SetName + " is present in Quick Eye Template Opthal Set");
			}else {
				logger.info("Created Opthal Set:" + SetName + " is not present in Quick Eye Template Opthal Set");
			}
			
			driver.findElement(By.xpath("//button[text()='Close']")).click();
			logger.info("User closed Quick Eye Template after validation");
		}

		@Then("^validate created Opthal Set should display in Investigation tab under Lens Template \"([^\"]*)\"$")
		public void validate_created_Opthal_Set_should_display_in_Investigation_tab_under_Lens_Template(String SetName) throws Throwable 
		{
			commonMethods.expwait("//*[text()='Template Details']");
			driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
			commonMethods.expwait("//a[@data_templatetype='lens']");
			commonMethods.clickElementByXpath("//a[@data_templatetype='lens']");
			logger.info("User Selected Lens Template");
			commonMethods.expwait("//li[@id='assesment_step']");
			
			List<WebElement> OpthalSets = driver.findElements(By.xpath("//select[@id='ophthal_set']"));
			if(OpthalSets.contains(SetName)) {
				logger.info("Created Opthal Set:" + SetName + " is present in Lens Template Opthal Set");
			}else {
				logger.info("Created Opthal Set:" + SetName + " is not present in Lens Template Opthal Set");
			}
			
			driver.findElement(By.xpath("//button[text()='Close']")).click();
			logger.info("User closed Lens Template after validation");
		}

		@Then("^validate created Opthal Set should display in Investigation tab under Pediatrics Template \"([^\"]*)\"$")
		public void validate_created_Opthal_Set_should_display_in_Investigation_tab_under_Pediatrics_Template(String SetName) throws Throwable 
		{
			commonMethods.expwait("//*[text()='Template Details']");
			driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
			commonMethods.expwait("//a[@data_templatetype='paediatrics']");
			commonMethods.clickElementByXpath("//a[@data_templatetype='paediatrics']");
			logger.info("User Selected Lens Template");
			commonMethods.expwait("//li[@id='assesment_step']");
			
			List<WebElement> OpthalSets = driver.findElements(By.xpath("//select[@id='ophthal_set']"));
			if(OpthalSets.contains(SetName)) {
				logger.info("Created Opthal Set:" + SetName + " is present in Pediatrics Template Opthal Set");
			}else {
				logger.info("Created Opthal Set:" + SetName + " is not present in Pediatrics Template Opthal Set");
			}
			
			driver.findElement(By.xpath("//button[text()='Close']")).click();
			logger.info("User closed Pediatrics Template after validation");
		}

		@Then("^validate created Opthal Set should display in Investigation tab under OrthopticsTemplate \"([^\"]*)\"$")
		public void validate_created_Opthal_Set_should_display_in_Investigation_tab_under_OrthopticsTemplate(String SetName) throws Throwable 
		{
			commonMethods.expwait("//*[text()='Template Details']");
			driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
			commonMethods.expwait("//a[@data_templatetype='orthoptics']");
			commonMethods.clickElementByXpath("//a[@data_templatetype='orthoptics']");
			logger.info("User Selected orthoptics Template");
			commonMethods.expwait("//li[@id='assesment_step']");
			
			List<WebElement> OpthalSets = driver.findElements(By.xpath("//select[@id='ophthal_set']"));
			if(OpthalSets.contains(SetName)) {
				logger.info("Created Opthal Set:" + SetName + " is present in Orthoptics Template Opthal Set");
			}else {
				logger.info("Created Opthal Set:" + SetName + " is not present in Orthoptics Template Opthal Set");
			}
			
			driver.findElement(By.xpath("//button[text()='Close']")).click();
			logger.info("User closed Orthoptics Template after validation");
		}

		@Then("^validate created Opthal Set should display in Investigation tab under Trauma  Template \"([^\"]*)\"$")
		public void validate_created_Opthal_Set_should_display_in_Investigation_tab_under_Trauma_Template(String SetName) throws Throwable
		{
			commonMethods.expwait("//*[text()='Template Details']");
			driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
			commonMethods.expwait("//a[@data_templatetype='trauma']");
			commonMethods.clickElementByXpath("//a[@data_templatetype='trauma']");
			logger.info("User Selected Trauma Template");
			commonMethods.expwait("//li[@id='assesment_step']");
			
			List<WebElement> OpthalSets = driver.findElements(By.xpath("//select[@id='ophthal_set']"));
			if(OpthalSets.contains(SetName)) {
				logger.info("Created Opthal Set:" + SetName + " is present in Trauma Template Opthal Set");
			}else {
				logger.info("Created Opthal Set:" + SetName + " is not present in Trauma Template Opthal Set");
			}
			
			driver.findElement(By.xpath("//button[text()='Close']")).click();
			logger.info("User closed Trauma Template after validation");
		}

		@Then("^validate created Opthal Set should display in Investigation tab under Free Form Template \"([^\"]*)\"$")
		public void validate_created_Opthal_Set_should_display_in_Investigation_tab_under_Free_Form_Template(String SetName) throws Throwable 
		{
			commonMethods.expwait("//*[text()='Template Details']");
			driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
			commonMethods.expwait("//a[@data_templatetype='freeform']");
			commonMethods.clickElementByXpath("//a[@data_templatetype='freeform']");
			logger.info("User Selected Trauma Template");
			commonMethods.expwait("//li[@id='assesment_step']");
			
			List<WebElement> OpthalSets = driver.findElements(By.xpath("//select[@id='ophthal_set']"));
			if(OpthalSets.contains(SetName)) {
				logger.info("Created Opthal Set:" + SetName + " is present in Free Form Template Opthal Set");
			}else {
			logger.info("Created Opthal Set:" + SetName + " is not present in Free Form Template Opthal Set");
			}
			
			driver.findElement(By.xpath("//button[text()='Close']")).click();
			commonMethods.logger.info("User closed Free Form Template after validation");
		}
		
		
		///////////////////////////////               Radilogy Set            ////////////////////////////////////
		
		

	@Then("^click on Radilogy Sets and validate each tab$")
	public void click_on_Radilogy_Sets_and_validate_each_tab() throws Throwable
	{
		driver.findElement(By.xpath("//a[@id='radiology_sets_id']")).click();
		logger.info("User click on Radiology Set tab under clinical");
	}

	@When("^create Radiology Set \"([^\"]*)\"$")
	public void create_Radiology_Set(String SetName1) throws Throwable
	{
	  commonMethods.expwait("//a[@class='btn btn-success']");
	  driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
	  logger.info("User click on 'Radiology Lab Set' button for creating a new Radiology Set");
	  commonMethods.expwait("//*[text()='New Radiology Laboratory Set']");
	  driver.findElement(By.xpath("//input[@id='radiology_laboratory_set_name']")).sendKeys(SetName1);
	  List<WebElement> XRay = driver.findElements(By.xpath("//select[@id='topradiologyinvestigation_xray']/..//option"));
	  for(int i=0;i<XRay.size()-1;i++) {
			String XRay_List = XRay.get(i).getText();
			commonMethods.logger.info("List of values under X-Ray are:" + XRay_List);
			XRay.get(i).click();
			}
	  
	  List<WebElement> MRI = driver.findElements(By.xpath("//select[@id='topradiologyinvestigation_mri']/..//option"));
	  for(int i=0;i<MRI.size()-1;i++) {
			String MRI_List = MRI.get(i).getText();
			commonMethods.logger.info("List of values under MRI are:" + MRI_List);
			MRI.get(i).click();
			}

	   Assert.assertEquals(driver.findElement(By.id("RadiologyRadio1")).isSelected(),true);
	  logger.info(" 'Standard Investigations' radio button is by default selected ");
	   driver.findElement(By.xpath("//label[text()='Custom Investigations']")).click();
	   logger.info(" User clicked on 'Custom Investigations' radio button");
	   
	   List<WebElement> Invesigations = driver.findElements(By.xpath("//select[@id='custom_investigations']/..//option"));
	   for(int i=0;i<Invesigations.size()-1;i++) {
	 		String Invesigations_List = Invesigations.get(i).getText();
	 		logger.info("List of values under Invesigations are:" + Invesigations_List);
	 		Invesigations.get(i).click();
	 		}
	 driver.findElement(By.xpath("(//input[@name=\"commit\"])[2]")).click();
	 logger.info("User Successfully created one Radiology Set having name:" + SetName1);
	   
	}

	@Then("^verify created Radiology Set name should display in Radiology Lab Sets \"([^\"]*)\"$")
	public void verify_created_Radiology_Set_name_should_display_in_Radiology_Lab_Sets(String SetName1) throws Throwable
	{
		System.out.println(SetName1);
		commonMethods.normalWait(5000);
	    driver.findElement(By.xpath("//input[@type='text' and @aria-controls='radiology-set-list']")).sendKeys(SetName1);
	    commonMethods.normalWait(10000);
		String search_result = driver.findElement(By.xpath("//div[@id='radiology-set-list_info']")).getText();
		System.out.println(search_result);
		System.out.println(search_result.length());
		System.out.println(search_result.substring(13, 14));///13 14
		/*int count = Integer.parseInt(search_result.substring(13, 14));
		if(count > 0) {
			
		}*/
		
		
	}

	@When("^user deleted that Radiology Set name its should not display in Radiology Lab Sets \"([^\"]*)\"$")
	public void user_deleted_that_Radiology_Set_name_its_should_not_display_in_Radiology_Lab_Sets(String SetName1) throws Throwable
	{
	 commonMethods.expwait("//tbody[@role='alert']/tr[1]/td/span/a[@data-method='delete']");
	 driver.findElement(By.xpath("//tbody[@role='alert']/tr[1]/td/span/a[@data-method='delete']")).click();
	 commonMethods.normalWait(500);
	 driver.findElement(By.xpath("//button[@class='btn commit btn-danger']")).click();
	 logger.info("User successfully deleted the Set");
	}

	@Then("^create again new Radiology Set \"([^\"]*)\"$")
	public void create_again_new_Radiology_Set(String SetName) throws Throwable
	{
		commonMethods.expwait("//a[@class='btn btn-success']");
		  driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
		  logger.info("User click on 'Radiology Lab Set' button for creating a new Radiology Set");
		  commonMethods.expwait("//*[text()='New Radiology Laboratory Set']");
		  driver.findElement(By.xpath("//input[@id='radiology_laboratory_set_name']")).sendKeys(SetName);
		  List<WebElement> XRay = driver.findElements(By.xpath("//select[@id='topradiologyinvestigation_xray']/..//option"));
		  for(int i=0;i<XRay.size()-1;i++) {
				String XRay_List = XRay.get(i).getText();
				logger.info("List of values under X-Ray are:" + XRay_List);
				XRay.get(i).click();
				}
		  
		  List<WebElement> MRI = driver.findElements(By.xpath("//select[@id='topradiologyinvestigation_mri']/..//option"));
		  for(int i=0;i<MRI.size()-1;i++) {
				String MRI_List = MRI.get(i).getText();
				logger.info("List of values under MRI are:" + MRI_List);
				MRI.get(i).click();
				}

		   Assert.assertEquals(driver.findElement(By.id("RadiologyRadio1")).isSelected(),true);
		   logger.info(" 'Standard Investigations' radio button is by default selected ");
		   driver.findElement(By.xpath("//label[text()='Custom Investigations']")).click();
		  logger.info(" User clicked on 'Custom Investigations' radio button");
		   
		   List<WebElement> Invesigations = driver.findElements(By.xpath("//select[@id='custom_investigations']/..//option"));
		   for(int i=0;i<Invesigations.size()-1;i++) {
		 		String Invesigations_List = Invesigations.get(i).getText();
		 		logger.info("List of values under Invesigations are:" + Invesigations_List);
		 		Invesigations.get(i).click();
		 		}
		 driver.findElement(By.xpath("(//input[@name=\"commit\"])[2]")).click();
		logger.info("User Successfully created one Radiology Set having name:" + SetName);
		   
	}

	@Then("^validate created Radiology Set should display in Investigation tab under Eye Template \"([^\"]*)\"$")
	public void validate_created_Radiology_Set_should_display_in_Investigation_tab_under_Eye_Template(String SetName) throws Throwable
	{
		List<WebElement> OpthalSets = driver.findElements(By.xpath("//select[@id='ophthal_set']"));
		if(OpthalSets.contains(SetName)) {
			logger.info("Created Radiology Set:" + SetName + " is present in Eye Template Opthal Set");
		}else {
			logger.info("Created Radiology Set:" + SetName + " is not present in Eye Template Opthal Set");
		}
		
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		logger.info("User closed Eye Template after validation");
	}

	@Then("^validate created Radiology Set should display in Investigation tab under QuickEye Template \"([^\"]*)\"$")
	public void validate_created_Radiology_Set_should_display_in_Investigation_tab_under_QuickEye_Template(String SetName) throws Throwable
	{
		commonMethods.expwait("//*[text()='Template Details']");
		driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
		
		driver.findElement(By.xpath("//a[@data_templatetype='quickeye']")).click();
		logger.info("User Selected Quick Eye Template");
		commonMethods.expwait("//li[@id='assesment_step']");
		
		List<WebElement> OpthalSets = driver.findElements(By.xpath("//select[@id='radiology_set']/option"));
		if(OpthalSets.contains(SetName)) {
			logger.info("Created Radiology Set:" + SetName + " is present in Quick Eye Template Opthal Set");
		}else {
			logger.info("Created Radiology Set:" + SetName + " is not present in Quick Eye Template Opthal Set");
		}
		
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		logger.info("User closed Quick Eye Template after validation");
	}

	@Then("^validate created Radiology Set should display in Investigation tab under Lens Template \"([^\"]*)\"$")
	public void validate_created_Radiology_Set_should_display_in_Investigation_tab_under_Lens_Template(String SetName) throws Throwable 
	{
		commonMethods.expwait("//*[text()='Template Details']");
		driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
		commonMethods.expwait("//a[@data_templatetype='lens']");
		commonMethods.clickElementByXpath("//a[@data_templatetype='lens']");
		logger.info("User Selected Lens Template");
		commonMethods.expwait("//li[@id='assesment_step']");
		
		List<WebElement> OpthalSets = driver.findElements(By.xpath("//select[@id='ophthal_set']"));
		if(OpthalSets.contains(SetName)) {
			logger.info("Created Radiology Set:" + SetName + " is present in Lens Template Opthal Set");
		}else {
			logger.info("Created Radiology Set:" + SetName + " is not present in Lens Template Opthal Set");
		}
		
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		logger.info("User closed Lens Template after validation");
	}

	@Then("^validate created Radiology Set should display in Investigation tab under Pediatrics Template \"([^\"]*)\"$")
	public void validate_created_Radiology_Set_should_display_in_Investigation_tab_under_Pediatrics_Template(String SetName) throws Throwable
	{
		commonMethods.expwait("//*[text()='Template Details']");
		driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
		commonMethods.expwait("//a[@data_templatetype='paediatrics']");
		commonMethods.clickElementByXpath("//a[@data_templatetype='paediatrics']");
		logger.info("User Selected Lens Template");
		commonMethods.expwait("//li[@id='assesment_step']");
		
		List<WebElement> OpthalSets = driver.findElements(By.xpath("//select[@id='ophthal_set']"));
		if(OpthalSets.contains(SetName)) {
			logger.info("Created Radiology Set:" + SetName + " is present in Pediatrics Template Opthal Set");
		}else {
			logger.info("Created Radiology Set:" + SetName + " is not present in Pediatrics Template Opthal Set");
		}
		
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		logger.info("User closed Pediatrics Template after validation");
	}

	@Then("^validate created Radiology Set should display in Investigation tab under OrthopticsTemplate \"([^\"]*)\"$")
	public void validate_created_Radiology_Set_should_display_in_Investigation_tab_under_OrthopticsTemplate(String SetName) throws Throwable 
	{
		commonMethods.expwait("//*[text()='Template Details']");
		driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
		commonMethods.expwait("//a[@data_templatetype='orthoptics']");
		commonMethods.clickElementByXpath("//a[@data_templatetype='orthoptics']");
		logger.info("User Selected orthoptics Template");
		commonMethods.expwait("//li[@id='assesment_step']");
		
		List<WebElement> OpthalSets = driver.findElements(By.xpath("//select[@id='ophthal_set']"));
		if(OpthalSets.contains(SetName)) {
			logger.info("Created Radiology Set:" + SetName + " is present in Orthoptics Template Opthal Set");
		}else {
			logger.info("Created Radiology Set:" + SetName + " is not present in Orthoptics Template Opthal Set");
		}
		
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		logger.info("User closed Orthoptics Template after validation");
	}

	@Then("^validate created Radiology Set should display in Investigation tab under Trauma  Template \"([^\"]*)\"$")
	public void validate_created_Radiology_Set_should_display_in_Investigation_tab_under_Trauma_Template(String SetName) throws Throwable
	{
		commonMethods.expwait("//*[text()='Template Details']");
		driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
		commonMethods.expwait("//a[@data_templatetype='trauma']");
		commonMethods.clickElementByXpath("//a[@data_templatetype='trauma']");
		logger.info("User Selected Trauma Template");
		commonMethods.expwait("//li[@id='assesment_step']");
		List<WebElement> OpthalSets = driver.findElements(By.xpath("//select[@id='ophthal_set']"));
		if(OpthalSets.contains(SetName)) {
			logger.info("Created Radiology Set:" + SetName + " is present in Trauma Template Opthal Set");
		}else {
			logger.info("Created Radiology Set:" + SetName + " is not present in Trauma Template Opthal Set");
		}
		
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		logger.info("User closed Trauma Template after validation");
	}

	@Then("^validate created Radiology Set should display in Investigation tab under Free Form Template \"([^\"]*)\"$")
	public void validate_created_Radiology_Set_should_display_in_Investigation_tab_under_Free_Form_Template(String SetName) throws Throwable
	{
		commonMethods.expwait("//*[text()='Template Details']");
		driver.findElement(By.xpath("//button[@id='opd-templates']")).click();
		commonMethods.expwait("//a[@data_templatetype='freeform']");
		commonMethods.clickElementByXpath("//a[@data_templatetype='freeform']");
		logger.info("User Selected Free Form Template");
		commonMethods.expwait("//a[text()='Investigation']");
		List<WebElement> OpthalSets = driver.findElements(By.xpath("//select[@id='ophthal_set']"));
		if(OpthalSets.contains(SetName)) {
			logger.info("Created Radiology Set:" + SetName + " is present in Free Form Template Opthal Set");
		}else {
			logger.info("Created Radiology Set:" + SetName + " is not present in Free Form Template Opthal Set");
		}
		
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		logger.info("User closed Free Form Template after validation");

}
}