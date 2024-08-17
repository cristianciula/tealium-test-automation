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
    
    private final By tealiumLogo = By.xpath("//img[@src=\"https://ecommerce.tealiumdemo.com/skin/frontend/base/default/images/media/logo.png\"]");
    private final By womenTab = By.xpath("//a[@href=\"https://ecommerce.tealiumdemo.com/women.html\"]/ancestor::nav[@id=\"nav\"]");

    //____________________METHODS____________________//

    public void clickTealiumLogo() {
        click(tealiumLogo);
    }

    public void clickWomenTab() {
        click(womenTab);
    }

}
