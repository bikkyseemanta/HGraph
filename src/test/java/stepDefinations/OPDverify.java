package stepDefinations;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Then;
import pageObjects.AddPatientDetails;
import pageObjects.LoginPage;
import utilities.Common_Methods;
import utilities.WebConnector;

public class OPDverify extends Common_Methods{
	
	Logger logger = Logger.getLogger("OPDverify");
	
	public OPDverify() {


		driver =  WebConnector.driver;
		commonMethods = new Common_Methods(driver);
		lp = new LoginPage(driver);
		addpd = new AddPatientDetails(driver, commonMethods);
		opdverify = new OPDverify(driver, commonMethods);
		PropertyConfigurator.configure("Log4j.properties");
	}

	@Then("^fill patient details  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void fill_patient_details(String Firstname, String Mobno, String Lastname, String Email, String language, String Pincode, String Ref) throws Throwable {
		
		addpd =new AddPatientDetails(driver, commonMethods);
		addpd.fillFirstName(Firstname);
		addpd.fillMobNo(Mobno);
		addpd.fillLastNAme(Lastname);
		addpd.fillEmail(Email);
		addpd.fillPrimaryLanguage(language);
		addpd.fillPincode(Pincode);
		addpd.fillpatientref(Ref);
		driver.findElement(By.xpath("//input[@name='patient[dob]']")).click();
		driver.findElement(By.xpath("//*[@class='ui-datepicker-prev ui-corner-all']")).click();
		normalWait(500);
		driver.findElement(By.xpath("(//a[@href=\"#\"])[14]")).click();
	
	}

	@Then("^clicks on Other Details tab select One Eyed$")
	public void clicks_on_Other_Details_tab_select_One_Eyed() throws Throwable {
		addpd.click_Other_Details();
		logger.info("****User clicks in Other Details tab********");
		normalWait(1000);
		clickElementByXpath("//input[@id='one_eyed_yes']");
		normalWait(500);
	  
	}

	@Then("^select special status$")
	public void select_special_status() throws Throwable {
		addpd.selectSpecstatus(); 
		logger.info("****User selected Special status********");
	  
	}
	
	@Then("^select history details \"([^\"]*)\" \"([^\"]*)\"$")
	public void select_history_details(String HistoryComment, String GlaucomaHistory) throws Throwable {
		addpd.clickHistory();
		logger.info("****User clicks on History tab********");
		driver.findElement(By.xpath("(//*[text()='Glaucoma'])[1]")).click();
		driver.findElement(By.xpath("//*[@placeholder='Comment...']")).sendKeys("HistoryComment");
		driver.findElement(By.xpath("//input[@id='patient_opthal_history_comment']")).sendKeys("GlaucomaHistory");

	}

	@Then("^select algeries details \"([^\"]*)\"$")
	public void select_algeries_details(String Penicillincomments) throws Throwable {
		
		driver.findElement(By.xpath("//*[text()='Allergies']")).click();
		commonMethods.normalWait(1000);
		driver.findElement(By.xpath("//*[text()='Antimicrobial Agents']")).click();
		driver.findElement(By.xpath("//*[text()='Ampicillin']")).click();
		
	}

}
