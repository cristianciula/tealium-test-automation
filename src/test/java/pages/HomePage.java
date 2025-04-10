package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utilities.helpers.SeleniumHelper.click;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //____________________LOCATORS____________________//
    
    private final By tealiumLogo = By.xpath("//img[@src='https://ecommerce.tealiumdemo.com/skin/frontend/base/default/images/media/logo.png']");
    //TODO: Fix locator
    private final By womenTab = By.xpath("//a[@href='https://ecommerce.tealiumdemo.com/women.html']/ancestor::nav[@id=\"nav\"]");
    private final By menTab = By.xpath("//li[@class='level0 nav-2 parent']/a[contains(.,'Men')]");

    //____________________METHODS____________________//

    public void clickTealiumLogo() {
        click(tealiumLogo);
    }

    public void clickWomenTab() {
        click(womenTab);
    }

    public void clickMenTab() {
        click(menTab);
    }

}
