package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import utils.PicoContainer;

/**
 * @author Sreej
 */
public class LoginPage extends BasePage {

    public LoginPage(PicoContainer picoContainer) {
        super(picoContainer);
    }

    private final By fieldUsername = By.id("Email");
    private final By fieldPassword = By.id("Password");
    private final By buttonSubmit = By.xpath("//button[@type='submit']");
    private final By invalidEmailError = By.id("Email-error");
    private final By navMainMenu = By.xpath("//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']");
    private final By pageHeader = By.xpath("//div[@class='content-header']/h1");


    public LoginPage clearUsername() {
        DriverManager.getDriver().findElement(fieldUsername).clear();
        return this;
    }

    public LoginPage enterPassword(String password) {
        DriverManager.getDriver().findElement(fieldUsername).clear();
        DriverManager.getDriver().findElement(fieldPassword).sendKeys(password);
        return this;
    }

    public void clickSubmit() {
        DriverManager.getDriver().findElement(buttonSubmit).click();
    }

    public String getInvalidEmailError() {
        return DriverManager.getDriver().findElement(invalidEmailError).getText();
    }

    public By getNavMainMenu() {
        return navMainMenu;
    }

    public By getPageHeader() {
        return pageHeader;
    }
}
