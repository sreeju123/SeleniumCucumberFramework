package steps;

import driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PicoContainer;

import java.time.Duration;
import java.util.function.Function;

/**
 * @author Sreej
 */
public class BaseTest {

    PicoContainer picoContainer;

    public BaseTest(PicoContainer picoContainer) {
        this.picoContainer = picoContainer;
    }

    public static void waitForPageLoad() {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), 30);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }

    public void waitReadyState() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    public void waitUntilPageLoaded(WebDriver driver) {
        Boolean isLoaded = false;
        while (!isLoaded) {
            isLoaded = isPageLoaded(driver);
//            delay(1);
        }
    }

    private Boolean isPageLoaded(WebDriver driver) {
        String jsQuery = "function pageLoaded() "
                + "{var loadingStatus=(document.readyState=='complete');"
                + "return loadingStatus;};"
                + "return pageLoaded()";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        return (Boolean) jsExecutor.executeScript(jsQuery);
    }

    private void delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
