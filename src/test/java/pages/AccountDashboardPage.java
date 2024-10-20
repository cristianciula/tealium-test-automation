package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.URL;
import utilities.helpers.SeleniumHelper;
import utilities.helpers.WaitHelper;

import static utilities.helpers.SeleniumHelper.getText;
import static utilities.helpers.SeleniumHelper.isElementDisplayed;

public class AccountDashboardPage {

    WebDriver driver;
    WaitHelper waitHelper;

    public AccountDashboardPage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
    }

    //____________________LOCATORS____________________//

    private final By pageTitle = By.xpath("//div[@class=\"page-title\" and contains(.,\"My Dashboard\")]");
    private final By registrationSuccessfulMessage = By.xpath("//li[@class=\"success-msg\"]");
    private final By welcomeMessage = By.xpath("//div[@class=\"welcome-msg\"]/p[@class=\"hello\"]");
    private final By accountInformationSection = By.xpath("//h3[contains(.,\"Contact Information\")]");

    //____________________ METHODS____________________//

    public String getCurentUrl() {
        waitHelper.waitUrlToBe(URL.ACCOUNT_DASHBOARD_AFTER_REGISTRATION, 2);
        return SeleniumHelper.getCurrentUrl();
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
