package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.DynamicXpathUtils;
import utils.PicoContainer;

import static factories.ExplicitWaitFactory.waitForElementToBeClickable;
import static factories.ExplicitWaitFactory.waitForPresenceOfElementLocated;

/**
 * @author Sreej
 */
public class CustomersPage extends BasePage {

    public CustomersPage(PicoContainer picoContainer) {
        super(picoContainer);
    }


    private final By fieldEmail = By.id("Email");
    private final By fieldPassword = By.id("Password");
    private final By fieldFirstName = By.id("FirstName");
    private final By fieldLastName = By.id("LastName");
    private final By fieldDateOfBirth = By.id("DateOfBirth");
    private final By fieldCompanyName = By.id("Company");
    private final By checkboxIsTaxExempt = By.id("IsTaxExempt");
    private final By fieldAdminComment = By.id("AdminComment");
    private final By buttonSave = By.name("save");
    private final By messageSuccess = By.xpath("//div[@class='alert alert-success alert-dismissable']");
    private final By headerCustomerPage = By.xpath("//h1[@class='float-left']");

    private String buttonGender = "//input[@id='Gender_%s']";


    public CustomersPage enterEmail(String email) {
        System.out.println(DriverManager.getDriver().findElement(By.xpath("//h1[@class='float-left']"))
                .getText());
        Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//h1[@class='float-left']"))
                .getText().contains("Add a new customer"));
        waitForPresenceOfElementLocated(fieldEmail);
        waitForElementToBeClickable(fieldEmail);
        wait.until(ExpectedConditions.elementToBeClickable(fieldEmail));
        DriverManager.getDriver().findElement(fieldEmail).click();
        DriverManager.getDriver().findElement(fieldEmail).sendKeys(email);
        picoContainer.dataStore.put("Email", email);
        return this;
    }

    public CustomersPage enterPassword(String password) {
        waitForElementToBeClickable(fieldPassword);
        waitForPresenceOfElementLocated(fieldPassword);
        DriverManager.getDriver().findElement(fieldPassword).sendKeys(password);
        return this;
    }

    public CustomersPage enterFirstName(String firstName) {
        waitForElementToBeClickable(fieldFirstName);
        waitForPresenceOfElementLocated(fieldFirstName);
        DriverManager.getDriver().findElement(fieldFirstName).click();
        DriverManager.getDriver().findElement(fieldFirstName).sendKeys(firstName);
        picoContainer.dataStore.put("FirstName", firstName);
        return this;
    }

    public CustomersPage enterLastName(String lastName) {
        waitForPresenceOfElementLocated(fieldLastName);
        waitForElementToBeClickable(fieldLastName);
        DriverManager.getDriver().findElement(fieldLastName).click();
        DriverManager.getDriver().findElement(fieldLastName).sendKeys(lastName);
        picoContainer.dataStore.put("LastName", lastName);
        return this;
    }

    public CustomersPage enterDateOfBirth(String dob) {
        waitForPresenceOfElementLocated(fieldDateOfBirth);
        waitForElementToBeClickable(fieldDateOfBirth);
        DriverManager.getDriver().findElement(fieldDateOfBirth).click();
        DriverManager.getDriver().findElement(fieldDateOfBirth).sendKeys(dob);
        return this;
    }

    public CustomersPage enterCompanyName(String companyName) {
        waitForPresenceOfElementLocated(fieldCompanyName);
        waitForElementToBeClickable(fieldCompanyName);
        DriverManager.getDriver().findElement(fieldCompanyName).click();
        DriverManager.getDriver().findElement(fieldCompanyName).sendKeys(companyName);
        picoContainer.dataStore.put("CompanyName", companyName);
        return this;
    }

    public CustomersPage enterAdminComment(String adminComment) {
        waitForPresenceOfElementLocated(fieldAdminComment);
        waitForElementToBeClickable(fieldAdminComment);
        DriverManager.getDriver().findElement(fieldAdminComment).click();
        DriverManager.getDriver().findElement(fieldAdminComment).sendKeys(adminComment);
        return this;
    }

    public void clickGender(String gender) {
        String xpath = DynamicXpathUtils.getXpath(buttonGender, gender);
        waitForElementToBeClickable(By.xpath(xpath));
        DriverManager.getDriver().findElement(By.xpath(xpath)).click();
    }

    public void clickIsTaxExemptCheckBox() {
        waitForElementToBeClickable(checkboxIsTaxExempt);
        DriverManager.getDriver().findElement(checkboxIsTaxExempt).click();
    }

    public void clickSave() {
        waitForElementToBeClickable(buttonSave);
        DriverManager.getDriver().findElement(buttonSave).click();
    }

    public String getSuccessMessage() {
        waitForPresenceOfElementLocated(messageSuccess);
        return DriverManager.getDriver().findElement(messageSuccess).getText();
    }

    public By getHeaderCustomerPage() {
        return headerCustomerPage;
    }


}
