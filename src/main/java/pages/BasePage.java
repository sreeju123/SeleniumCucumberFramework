package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PicoContainer;


/**
 * @author Sreej
 */
public class BasePage {

    PicoContainer picoContainer;
    WebDriverWait wait;

    public BasePage(PicoContainer picoContainer) {
        this.picoContainer = picoContainer;
        this.wait = new WebDriverWait(DriverManager.getDriver(), 30);
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            DriverManager.getDriver().findElement(locatorKey).isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void click(WebElement element) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.click(element).build().perform();
    }

}
