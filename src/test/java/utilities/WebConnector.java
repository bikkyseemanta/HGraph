package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.concurrent.TimeUnit;

public class WebConnector {

    public static WebDriver driver;
    private static final int PAGE_LOAD_TIME = 30;

    public WebConnector() {
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver83.exe");
		//Reporter.addStepLog("Browser Opening");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIME, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
