package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static wrappers.SeleniumWrapper.*;

public class AccountDashboardPage {

    WebDriver driver;

    public AccountDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    //____________________LOCATORS____________________//

    private final By pageTitle = By.xpath("//div[@class=\"page-title\" and contains(.,\"My Dashboard\")]");
    private final By registrationSuccessfulMessage = By.xpath("//li[@class=\"success-msg\"]");
    private final By welcomeMessage = By.xpath("//div[@class=\"welcome-msg\"]/p[@class=\"hello\"]");

    //____________________ METHODS____________________//

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

}
