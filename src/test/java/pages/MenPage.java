package pages;

import org.openqa.selenium.WebDriver;
import wrappers.WaitsWrapper;

import static wrappers.SeleniumWrapper.getTitle;

public class MenPage {

    WebDriver driver;
    WaitsWrapper waitsWrapper;

    public MenPage(WebDriver driver) {
        this.driver = driver;
        this.waitsWrapper = new WaitsWrapper(driver);
    }

    //____________________LOCATORS____________________//


    //____________________METHODS____________________//

    public String getPageTitle() {
        return getTitle();
    }
}
