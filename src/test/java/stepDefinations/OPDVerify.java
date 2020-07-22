package stepDefinations;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;

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

	@Then("^fill patient details  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void fill_patient_details(String uname, String pswd,String Firstname, String Mobno, String Lastname, String Email, String language, String Pincode, String Ref, String HistoryComment, String GlaucomaHistory, String Penicillincomments) throws Throwable 
	{
	 fillpatientDetails(uname, pswd, Firstname, Mobno, Lastname, Email, language, Pincode, Ref, HistoryComment, GlaucomaHistory, Penicillincomments);
	 
	}
		
	@Then("^validate mobile field \"([^\"]*)\"$")
	public void validate_mobile_field(String Mobno) throws Throwable {
		commonMethods.expwait("//div[@id='patient-details']/div[4]/div[3]");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='patient-details']/div[4]/div[3]")).getText(), Mobno);
		logger.info("Mobile no verified");
		
	}
	
	
	
}
