package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static wrappers.SeleniumWrapper.*;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //____________________LOCATORS____________________//
    private By tealiumLogo = By.xpath("//img[@src=\"https://ecommerce.tealiumdemo.com/skin/frontend/base/default/images/media/logo.png\"]");
    private By womenNavBarButton = By.xpath("//a[@href=\"https://ecommerce.tealiumdemo.com/women.html\"]/ancestor::nav[@id=\"nav\"]");

    //____________________PRIVATE METHODS____________________//

    //____________________PUBLIC METHODS____________________//
    public void clickTealium() {
        click(tealiumLogo);
    }
    public void clickWomenNavBarButton() {
        click(womenNavBarButton);
    }

}
