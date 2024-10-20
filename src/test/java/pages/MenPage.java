package pages;

import org.openqa.selenium.WebDriver;
import utilities.helpers.WaitHelper;

import static utilities.helpers.SeleniumHelper.getTitle;

public class MenPage {

    WebDriver driver;
    WaitHelper waitHelper;

    public MenPage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
    }

    //____________________LOCATORS____________________//


    //____________________METHODS____________________//

    public String getPageTitle() {
        return getTitle();
    }
}
