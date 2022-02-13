package factories;

import constants.FrameworkConstants;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sreej
 */
public class ExplicitWaitFactory {

    public static void waitForElementToBeClickable(By by) {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForPresenceOfElementLocated(By by) {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForPresenceOfElementLocated(By by, String text) {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(ExpectedConditions.textToBePresentInElementLocated(by, text));
    }

    public static void waitForVisibilityOfElementLocated(By by) {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForUrlToBe(String url) {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(ExpectedConditions.urlToBe(url));
    }

    public static void waitForInVisibilityOfElementLocated(By by) {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

}
