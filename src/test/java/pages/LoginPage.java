package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //----------LOCATORS----------//
    public By createAccountButton = By.xpath("//a[@title=\"Create an Account\"]");

    //----------PRIVATE METHODS----------//


    //----------PUBLIC METHODS----------//
    public void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }
}
