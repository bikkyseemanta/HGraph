package stepDefinations;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.WebConnector;

public class Hook extends  WebConnector {

    @Before
    public void navigateToEGRApplication() {
        driver.get("https://qaehr.healthgraph.in/users/login");
        
    }

    @After
    public void closeEGRApplication() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
