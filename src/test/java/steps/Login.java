package steps;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;
import utils.PicoContainer;

/**
 * @author Sreej
 */
public class Login extends BaseTest {

    public Login(PicoContainer picoContainer) {
        super(picoContainer);
    }

    LoginPage loginPage = new LoginPage(picoContainer);

    @Given("The admin navigates to {string}")
    public void the_admin_navigates_to(String url) {
//        ConfigFileReader configFileReader=new ConfigFileReader();
//        System.out.println(configFileReader.get(ConfigProperties.BROWSER));
        DriverManager.getDriver().get(url);
    }

    @Given("The admin clears the email")
    public void the_admin_clears_the_email() {
        loginPage.clearUsername();
    }

    @Given("Clicks Submit button")
    public void clicks_Submit_button() {
        loginPage.clickSubmit();
    }

    @Then("The Invalid email error should be displayed")
    public void the_Invalid_email_error_should_be_displayed() {
        Assert.assertEquals("Please enter your email", loginPage.getInvalidEmailError());
    }


}
