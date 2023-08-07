package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.SeleniumUtils.*;
import static utils.WaitUtils.*;

public class Menu {

    WebDriver driver;

    public Menu(WebDriver driver) {
        this.driver = driver;
    }

    //____________________LOCATORS____________________//
    private By menDropDownMenu = By.xpath("//li[@class=\"level0 nav-2 parent\"]");
    private By breadcrumbs = By.xpath("//div[@class=\"breadcrumbs\"]");

    //____________________PRIVATE METHODS____________________//

    //____________________PUBLIC METHODS____________________//
    public void expandMenuDropDown() {
        hoverOverElement(menDropDownMenu);
    }
    public String getBreadcrumbsPath() {
        return getText(breadcrumbs);
    }

}
