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
    private By registrationSuccessfulMessage = By.xpath("//li[@class=\"success-msg\"]");
    private By userGreetingPlaceholder = By.xpath("//div[@class=\"welcome-msg\"]/p[@class=\"hello\"]");
    private By pageTitle = By.xpath("//div[@class=\"page-title\" and contains(.,\"My Dashboard\")]");

    //____________________PRIVATE METHODS____________________//

    //____________________PUBLIC METHODS____________________//
    public String getRegistrationSuccessfulMessage() {
        return driver.findElement(registrationSuccessfulMessage).getText();
    }
    public String getUserGreetingPlaceholder() {
        return driver.findElement(userGreetingPlaceholder).getText();
    }
    public String getPageTitle() {
        return getText(pageTitle);
    }
    public boolean isPageTitleDisplayed() {
        return isElementDisplayed(pageTitle);
    }
    public By getPageTitleLocator() {
        return pageTitle;
    }

}
