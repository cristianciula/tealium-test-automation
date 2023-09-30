package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.SeleniumUtils.*;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //____________________LOCATORS____________________//
    private By tealium = By.xpath("//img[@src=\"https://ecommerce.tealiumdemo.com/skin/frontend/base/default/images/media/logo.png\"]");

    //____________________PRIVATE METHODS____________________//

    //____________________PUBLIC METHODS____________________//
    public void clickTealium() {
        click(tealium);
    }

}
