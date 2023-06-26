package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDashboardPage {

    WebDriver driver;

    public AccountDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    //----------LOCATORS----------//
    private final By registrationSuccessfulMessage = By.xpath("//li[@class=\"success-msg\"]");
    private final By helloUsernameMessage = By.xpath("//div[@class=\"welcome-msg\"]/p[@class=\"hello\"]");

    //----------PRIVATE METHODS----------//

    //----------PUBLIC METHODS----------//
    public String getRegistrationSuccessfulMsg() {
        return driver.findElement(registrationSuccessfulMessage).getText();
    }
    public String getHelloUsernameMessage() {
        return driver.findElement(helloUsernameMessage).getText();
    }

}
