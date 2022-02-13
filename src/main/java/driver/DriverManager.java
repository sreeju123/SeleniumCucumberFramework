package driver;

import org.openqa.selenium.WebDriver;

/**
 * @author Sreej
 */
public class DriverManager {

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driverRef) {
        dr.set(driverRef);
    }

    public static void unload() {
        dr.remove();
    }

}
