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
    private By menDropMenu = By.xpath("//li[@class=\"level0 nav-2 parent\"]");
    private By breadcrumbs = By.xpath("//div[@class=\"breadcrumbs\"]");
    private By menShirtsDropOption = By.xpath("//a[@href=\"https://ecommerce.tealiumdemo.com/men/shirts.html\"]");


    //____________________PRIVATE METHODS____________________//

    //____________________PUBLIC METHODS____________________//
    public void expandMenDropMenu() {
        hoverOverElement(menDropMenu);
    }
    public String getBreadcrumbsPath() {
        return getText(breadcrumbs);
    }
    public void clickMenShirtsDropOption() {
        click(menShirtsDropOption);
    }


}
