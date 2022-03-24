package steps;

import driver.Driver;
import driver.DriverManager;
import enums.ConfigProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigFileReader;

import java.io.File;
import java.net.MalformedURLException;

/**
 * @author Sreej
 */
public class Hooks {

    @Before
    public void setUp(Scenario scenario) throws MalformedURLException {
        /*
        String browser= System.getProperty("browser.selection"); // get from Env variables
        */

        System.out.println("Hooks setUp");

        Driver.initDriver(ConfigFileReader.get(ConfigProperties.BROWSER));
        DriverManager.getDriver().manage().window().maximize();
    }

    @After(order = 1)
    public void tearDown() {
        System.out.println("Hooks tearDown");
        Driver.quitDriver();
    }


    @After
    public void failedScreenShot(Scenario scenario) {
        System.out.println("Screenshot Taken");
        if (scenario.isFailed()) {
            byte[] screenshot= ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"img/png",scenario.getName());
        }
    }


}

