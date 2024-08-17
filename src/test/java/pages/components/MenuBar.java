package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static wrappers.SeleniumWrapper.*;

public class MenuBar {

    WebDriver driver;

    public MenuBar(WebDriver driver) {
        this.driver = driver;
    }

    //____________________LOCATORS____________________//

    private final By menTab = By.xpath("//li[@class=\"level0 nav-2 parent\"]");
    private final By breadcrumbs = By.xpath("//div[@class=\"breadcrumbs\"]");
    private final By menShirtsSubTab = By.xpath("//a[@href=\"https://ecommerce.tealiumdemo.com/men/shirts.html\"]");

    //____________________METHODS____________________//

    public void expandMenSubTabs() {
        hoverOver(menTab);
    }

    public String getBreadcrumbsPath() {
        return getText(breadcrumbs);
    }

    public void clickMenShirtsSubTab() {
        click(menShirtsSubTab);
    }

}
