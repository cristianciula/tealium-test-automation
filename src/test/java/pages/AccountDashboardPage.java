package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDashboardPage {

    WebDriver driver;

    public AccountDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    //----------LOCATORS----------//
    private By registrationSuccessfulMessage = By.xpath("//li[@class=\"success-msg\"]");
    private By userGreetingPlaceholder = By.xpath("//div[@class=\"welcome-msg\"]/p[@class=\"hello\"]");

    //----------PRIVATE METHODS----------//

    //----------PUBLIC METHODS----------//
    public String getRegistrationSuccessfulMessage() {
        return driver.findElement(registrationSuccessfulMessage).getText();
    }
    public String getUserGreetingPlaceholder() {
        return driver.findElement(userGreetingPlaceholder).getText();
    }

}
