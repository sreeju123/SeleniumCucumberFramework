package driver;

import factories.DriverFactory;

import java.net.MalformedURLException;
import java.util.Objects;

/**
 * @author Sreej
 */
public class Driver {

    public static void initDriver(String browser) throws MalformedURLException {

        if (Objects.isNull(DriverManager.getDriver())) {
            DriverManager.setDriver(DriverFactory.getDriver(browser));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
