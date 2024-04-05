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
    private By womenPageBreadcrumb = By.xpath("//div[@class=\"breadcrumbs\"]/descendant::strong[text()=\"Women\"]");

    //____________________PRIVATE METHODS____________________//

    //____________________PUBLIC METHODS____________________//
    public boolean womenPageBreadcrumbIsDisplayed() {
        return isElementDisplayed(womenPageBreadcrumb);
    }
}
