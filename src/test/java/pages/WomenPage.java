package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.helpers.WaitHelper;

import static utilities.helpers.SeleniumHelper.isElementDisplayed;

public class WomenPage {

    WebDriver driver;
    WaitHelper waitHelper;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
    }

    //____________________LOCATORS____________________//

    private final By breadcrumbs = By.xpath("//div[@class=\"breadcrumbs\"]/descendant::strong[text()=\"Women\"]");

    //____________________METHODS____________________//

    public boolean isBreadcrumbsDisplayed() {
        return isElementDisplayed(breadcrumbs);
    }

}
