package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DynamicXpathUtils;
import utils.PicoContainer;

import static factories.ExplicitWaitFactory.waitForElementToBeClickable;
import static factories.ExplicitWaitFactory.waitForInVisibilityOfElementLocated;

/**
 * @author Sreej
 */
public class JourneyPage extends BasePage {

    public JourneyPage(PicoContainer picoContainer) {
        super(picoContainer);
    }

    private final By menuExpand = By.xpath("//ul[@class='nav nav-treeview'][@style='display: block;']");
    private final By menuCollapse = By.xpath("//ul[@class='nav nav-treeview'][@style='display: none;']");
    private final By buttonAddNew = By.xpath("//a[normalize-space()='Add new']/i");
    private final By loader = By.id("ajaxBusy");


    private String navLinkMenu = "//p[normalize-space()='%s']/../parent::li[@class='nav-item has-treeview menu-open']";
    private String linkMenu = "//a[@href='#']//p[normalize-space()='%s']/i";
    private String linkSubMenu = "//li[@class='nav-item']/a/p[normalize-space()='%s']";


    public By getMenuExpand() {
        return menuExpand;
    }

    public By getMenuCollapse() {
        return menuCollapse;
    }

    public JourneyPage clickMenu(String menu) {
        String xpath = DynamicXpathUtils.getXpath(linkMenu, menu);
        waitForElementToBeClickable(By.xpath(xpath));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        DriverManager.getDriver().findElement(By.xpath(xpath)).click();
//        DriverManager.getDriver().findElement(By.xpath("//i[@class='nav-icon far fa-user']")).click();
        return this;
    }

    public JourneyPage clickSubMenu(String subMenu) {
        String xpath = DynamicXpathUtils.getXpath(linkSubMenu, subMenu);
        waitForElementToBeClickable(By.xpath(xpath));
        DriverManager.getDriver().findElement(By.xpath(xpath)).click();
        return this;
    }

    public void clickAddNewButton() {
//        wait.until(ExpectedConditions.invisibilityOf(DriverManager.getDriver().findElement(By.id("ajaxBusy"))));
        waitForInVisibilityOfElementLocated(loader);
        waitForElementToBeClickable(buttonAddNew);
        DriverManager.getDriver().findElement(buttonAddNew).click();
    }

    public Boolean getNavLinkMenu(String menu) {
        String xpath = DynamicXpathUtils.getXpath(navLinkMenu, menu);
        return isElementPresent(By.xpath(xpath));
    }


}
