package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.helpers.WaitsHelper;

import static utilities.helpers.SeleniumHelper.isElementDisplayed;

public class WomenPage {

    WebDriver driver;
    WaitsHelper waitsHelper;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
        this.waitsHelper = new WaitsHelper(driver);
    }

    //____________________LOCATORS____________________//

    private final By breadcrumbs = By.xpath("//div[@class=\"breadcrumbs\"]/descendant::strong[text()=\"Women\"]");

    //____________________METHODS____________________//

    public boolean isBreadcrumbsDisplayed() {
        return isElementDisplayed(breadcrumbs);
    }

}
