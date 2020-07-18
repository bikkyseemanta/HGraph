package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class OPD_Home_Page  {

public WebDriver driver=null;
	
	public OPD_Home_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@href=\"#appointment_not_arrived_list\"]")
	@CacheLookup
	WebElement NotArrived;
	
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
	
	
}
