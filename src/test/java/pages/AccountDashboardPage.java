package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.URL;
import wrappers.SeleniumWrapper;
import wrappers.WaitsWrapper;

import static wrappers.SeleniumWrapper.*;

public class AccountDashboardPage {

    WebDriver driver;
    WaitsWrapper waitsWrapper;

    public AccountDashboardPage(WebDriver driver) {
        this.driver = driver;
        this.waitsWrapper = new WaitsWrapper(driver);
    }

    //____________________LOCATORS____________________//

    private final By pageTitle = By.xpath("//div[@class=\"page-title\" and contains(.,\"My Dashboard\")]");
    private final By registrationSuccessfulMessage = By.xpath("//li[@class=\"success-msg\"]");
    private final By welcomeMessage = By.xpath("//div[@class=\"welcome-msg\"]/p[@class=\"hello\"]");
    private final By accountInformationSection = By.xpath("//h3[contains(.,\"Contact Information\")]");

    //____________________ METHODS____________________//

    public String getCurentUrl() {
        waitsWrapper.waitUrlToBe(URL.ACCOUNT_DASHBOARD_AFTER_REGISTRATION, 2);
        return SeleniumWrapper.getCurrentUrl();
    }

    public String getRegistrationSuccessfulMessage() {
        return getText(registrationSuccessfulMessage);
    }

    public String getWelcomeMessage() {
        return getText(welcomeMessage);
    }
    public String getPageTitle() {
        return getText(pageTitle);
    }

    public boolean isPageTitleDisplayed() {
        return isElementDisplayed(pageTitle);
    }

    public boolean isAccountInformationSectionDisplayed() {
        return isElementDisplayed(accountInformationSection);
    }

}
