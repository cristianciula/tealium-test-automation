package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    public By accountButton = By.xpath("//span[@class=\"label\"][contains(.,\"Account\")]");

    //METHODS
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }
}
