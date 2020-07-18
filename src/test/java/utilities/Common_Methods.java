package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageObjects.AddPatientDetails;
import pageObjects.LoginPage;

public class Common_Methods {

	public WebDriver driver;
	public static WebElement element;
	public static Logger logger;
	public Properties configProp;
	public WebDriverWait wait;
	public AddPatientDetails addpd;
	
	
	public Common_Methods(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}
    
	public  String randomstring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(10);
		return generatedString1;
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public String readProperty(String key) throws Exception
	{
		FileReader reader=new FileReader("C:\\Users\\lenovo\\eclipse-workspace\\com.HG\\config.properties");  

		Properties p=new Properties();  
		p.load(reader);  

		String value = p.getProperty(key);
		return value;
	}

	public void clickElementByElement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;    
		js.executeScript("arguments[0].click();", element); 
	}
	
	public void normalWait(long seconds) throws Exception
	{
		Thread.sleep(seconds);
	}
	
	
    public void Wait(WebDriver driver) {
        wait = new WebDriverWait(driver, 30);
    }

    public void waitForTextToBePresentInElement(WebElement element, String text){
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        
    }

    public  void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
	

	public void implicitlyWait(long time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MILLISECONDS);
	}

	public void expwait(String Xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
	}
	

	public void waitTillClick(String Xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
	}

	public void waitTime()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}


	public void pressEnter()
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}

	public void maximizeWindow()
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}


	public void selectValue(WebElement element, String value)
	{
		element.sendKeys(value);
	}

	public void scrolloperation(long index)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+index+")");
	}



	public void clickElementByXpath(String Xpath)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;    
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(Xpath))); 
	}

	public void normalclick(String Xpath)
	{
		driver.findElement(By.xpath(Xpath)).click();
	}

	public void scrollviewoperation(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void scrollviewmultioperation(String xpath)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xpath)));
	}

	public void dropdown(String text, WebElement element)
	{
		Select se = new Select(element);
		se.selectByVisibleText(text);
	}

	public void moveToElement(WebElement wb)
	{
		Actions act = new Actions(driver);
		act.moveToElement(wb).perform();
	}

	public void windowHandle(String windowid)
	{
		driver.switchTo().window(windowid);
	}

	public void frameHandle(int index)
	{
		driver.switchTo().frame(index);
	}

	public String TodayDate()
	{
		Date date = new Date();  
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");  
		String strDate= formatter.format(date); 
		return strDate;
	}

	public Date yesterday() 
	{
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	public Date defaultEndDate(int number)
	{
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +number);
		return cal.getTime();
	}

	public String YesterdayDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		return dateFormat.format(yesterday());
	}

	public void ExtentReport()
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/plm.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
}
