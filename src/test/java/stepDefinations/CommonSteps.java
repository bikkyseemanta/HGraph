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

public class CommonSteps 
{
	WebDriver driver;
	Common_Methods commonMethods;
	LoginPage lp;
	AddPatientDetails addpd;
	//OPDverify opdverify;
	Logger logger = Logger.getLogger("CommonSteps");

	public  CommonSteps() {
		driver = WebConnector.driver;
		commonMethods = new Common_Methods(driver);
		lp = new LoginPage(driver);
		addpd = new AddPatientDetails(driver, commonMethods);
		//opdverify = new OPDverify(driver, commonMethods);
		PropertyConfigurator.configure("Log4j.properties");
	}
	public  void fillpatientDetails (String uname, String pswd,String Firstname, String Mobno, String Lastname, String Email, String language, String Pincode, String Ref,String HistoryComment, String GlaucomaHistory,String Penicillincomments) throws Exception
	{	
		lp.fillusername(uname);
		lp.fillpassword(pswd);
		logger.info("Successfully Entered Receptionist Username and Password");
		lp.clickloginbtn();
		logger.info("Logged in Successfully as a Receptionist");		
		commonMethods.expwait("//*[@class='glyphicon glyphicon-plus']");
		addpd.clickAdd_btn();
		logger.info("Receptionist clicked on Add button");
		commonMethods.normalWait(2000);		
		commonMethods.waitTillClick("//*[text()='Add New Patient']");
		addpd.click_Add_New_Patient_btn();
		logger.info("Receptionist clicked on Add New Patient button");		
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
		commonMethods.normalWait(500);
		logger.info("Receptionist filled Patient Details, FirstName : " + Firstname + ", MobNo:" + Mobno + ", LastName :" + Lastname+ ", Email:" + Email + ",Language:"+ language + ", Pincode:"+Pincode + ", Referral: " + Ref );
		driver.findElement(By.xpath("(//a[@href=\"#\"])[14]")).click();
		addpd.click_Other_Details();
		logger.info("Receptionist clicked on Other Details tab");
		commonMethods.normalWait(1000);
		commonMethods.clickElementByXpath("//input[@id='one_eyed_yes']");
		commonMethods.normalWait(500);
		logger.info("Receptionist select as One Eyed");
		addpd.selectSpecstatus(); 
		logger.info("Receptionist select Special status as Breastfeeding");
		addpd.clickHistory();
		logger.info("Receptionist clicked on History tab");
		driver.findElement(By.xpath("(//*[text()='Glaucoma'])[1]")).click();
		driver.findElement(By.xpath("//*[@placeholder='Comment...']")).sendKeys("HistoryComment");
		driver.findElement(By.xpath("//input[@id='patient_opthal_history_comment']")).sendKeys("GlaucomaHistory");
		driver.findElement(By.xpath("//*[text()='Allergies']")).click();
		commonMethods.normalWait(1000);
		driver.findElement(By.xpath("//*[text()='Antimicrobial Agents']")).click();
		commonMethods.expwait("//button[text()='Ampicillin']");
		driver.findElement(By.xpath("//*[text()='Ampicillin']")).click();
		addpd.clickappointmentbtn();		
		logger.info("Receptionist successfully created one appointment by entering all History & Allegy detials"); 	
	}
}