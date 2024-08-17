package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.WaitsWrapper;

import static wrappers.SeleniumWrapper.*;

public class WomenPage {

    WebDriver driver;
    WaitsWrapper waitsWrapper;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
        this.waitsWrapper = new WaitsWrapper(driver);
    }

    //____________________LOCATORS____________________//

    private final By breadcrumbs = By.xpath("//div[@class=\"breadcrumbs\"]/descendant::strong[text()=\"Women\"]");

    //____________________METHODS____________________//

    public boolean isBreadcrumbsDisplayed() {
        return isElementDisplayed(breadcrumbs);
    }

}
