package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    public By accountButton = By.xpath("//span[@class=\"label\"][text()=\"Account\"]");
    public By myAccountButton = By.xpath("//div[@id=\"header-account\"]/descendant::a[@href=\"http://demo-store.seleniumacademy.com/customer/account/\"]");
    public By cartButton = By.xpath("//span[@class=\"label\"][contains(.,\"Cart\")]");

    //METHODS
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }
    public void clickMyAccountButton() {
        driver.findElement(myAccountButton).click();
    }
    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }
}
