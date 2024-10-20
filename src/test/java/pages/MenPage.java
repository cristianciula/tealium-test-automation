package pages;

import org.openqa.selenium.WebDriver;
import utilities.helpers.WaitsHelper;

import static utilities.helpers.SeleniumHelper.getTitle;

public class MenPage {

    WebDriver driver;
    WaitsHelper waitsHelper;

    public MenPage(WebDriver driver) {
        this.driver = driver;
        this.waitsHelper = new WaitsHelper(driver);
    }

    //____________________LOCATORS____________________//


    //____________________METHODS____________________//

    public String getPageTitle() {
        return getTitle();
    }
}
