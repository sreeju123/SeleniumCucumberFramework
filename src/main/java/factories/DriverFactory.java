package factories;

import enums.Browser;
import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigFileReader;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Sreej
 */
public class DriverFactory {

    public static WebDriver getDriver(String browser) throws MalformedURLException {

        WebDriver driver = null;
        String ruMode = ConfigFileReader.get(ConfigProperties.RUNMODE);

        if (browser.equalsIgnoreCase(String.valueOf(Browser.CHROME))) {
            if (ruMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                driver = new RemoteWebDriver(new URL(ConfigFileReader.get(ConfigProperties.SELENIUMGRIDURL)), cap);
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase(String.valueOf(Browser.FIREFOX))) {
            if (ruMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = DesiredCapabilities.firefox();
                driver = new RemoteWebDriver(new URL(ConfigFileReader.get(ConfigProperties.SELENIUMGRIDURL)), cap);
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        } else if (browser.equalsIgnoreCase(String.valueOf(Browser.EDGE))) {
            if (ruMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = DesiredCapabilities.edge();
                driver = new RemoteWebDriver(new URL(ConfigFileReader.get(ConfigProperties.SELENIUMGRIDURL)), cap);
            } else {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
        return driver;
    }

}
