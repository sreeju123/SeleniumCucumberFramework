package steps;

import constants.FrameworkConstants;
import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.CustomersPage;
import pages.JourneyPage;
import pages.LoginPage;
import utils.PicoContainer;

import static factories.ExplicitWaitFactory.*;
import static utils.FakerData.*;

/**
 * @author Sreej
 */
public class Customer extends BaseTest {

    public Customer(PicoContainer picoContainer) {
        super(picoContainer);
    }

    CustomersPage customersPage = new CustomersPage(picoContainer);
    JourneyPage journeyPage = new JourneyPage(picoContainer);
    LoginPage loginPage = new LoginPage(picoContainer);


    @Given("The admin clicks the {string} menu")
    public void the_admin_clicks_the_menu(String menu) {
        waitForUrlToBe(FrameworkConstants.getDashboardUrl());
        waitUntilPageLoaded(DriverManager.getDriver());
        waitForVisibilityOfElementLocated(loginPage.getNavMainMenu());
        waitForPresenceOfElementLocated(loginPage.getPageHeader(), "Dashboard");
        journeyPage.clickMenu(menu);
    }

    @Then("The admin verifies the {string} menu list is {string}")
    public void the_admin_verifies_the_menu_list_is_expanded(String menu, String option) {
        switch (option) {
            case "expanded":
                waitForPresenceOfElementLocated(journeyPage.getMenuExpand());
                Assert.assertTrue(journeyPage.getNavLinkMenu(menu));
                break;
            case "collapsed":
                waitForPresenceOfElementLocated(journeyPage.getMenuCollapse());
                Assert.assertFalse(journeyPage.getNavLinkMenu(menu));

                break;
        }
    }

    @Then("The admin clicks the {string} button in Customers page")
    public void the_admin_clicks_the_button_in_customers_page(String button) {
        switch (button) {
            case "Add new":
                journeyPage.clickAddNewButton();
                break;
        }
    }

    @And("The admin clicks the sub menu {string} of Customer menu")
    public void the_admin_clicks_the_sub_menu_of_Customer_menu(String subMenu) {
        journeyPage.clickSubMenu(subMenu);
    }

    @Given("The admin enters the Customer details")
    public void the_admin_enters_the_Customer_details() {
        waitUntilPageLoaded(DriverManager.getDriver());
        customersPage.enterEmail(setEmail());
        customersPage.enterFirstName(setFirstName());
        customersPage.enterLastName(setLastName());
        customersPage.clickGender("Male");
        customersPage.enterDateOfBirth("1/1/1990");
        customersPage.enterCompanyName(setCompanyName());
        customersPage.clickIsTaxExemptCheckBox();
        customersPage.enterAdminComment("This is Admin Comments for Testing purpose");
    }

    @Given("Click Save button")
    public void click_Save_button() {
        customersPage.clickSave();
    }

    @Then("Verify the Customer added success message")
    public void verify_the_Customer_added_success_message() {
        Assert.assertTrue(customersPage.getSuccessMessage().contains("The new customer has been added successfully."));
    }

    @Then("The admin verifies the newly added customer is displayed in Customer table")
    public void the_admin_verifies_the_newly_added_customer_is_displayed_in_Customer_table() {
        waitUntilPageLoaded(DriverManager.getDriver());
        waitForPresenceOfElementLocated(By.xpath("//div[@class='dataTables_scrollBody']/table[@class='table table-bordered table-hover table-striped dataTable no-footer']"));
        String name = picoContainer.dataStore.get("FirstName") + " " + picoContainer.dataStore.get("LastName");
        for (int i = 2; i <= 5; i++) {
            if (i == 2) {
                Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//div[@class='dataTables_scrollBody']/table[@class='table table-bordered table-hover " +
                        "table-striped dataTable no-footer']/tbody/tr[1]/td[" + i + "]")).getText().contains((String) picoContainer.dataStore.get("Email")));
            } else if (i == 3) {
                Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//div[@class='dataTables_scrollBody']/table[@class='table table-bordered table-hover " +
                        "table-striped dataTable no-footer']/tbody/tr[1]/td[" + i + "]")).getText().contains(name));
            } else if (i == 5) {
                Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//div[@class='dataTables_scrollBody']/table[@class='table table-bordered table-hover " +
                        "table-striped dataTable no-footer']/tbody/tr[1]/td[" + i + "]")).getText().contains((String) picoContainer.dataStore.get("CompanyName")));
            }
        }
    }

}
