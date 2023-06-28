package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.SeleniumUtils.waitForElementToBeVisible;

public class Header {

    WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    private By accountButton = By.xpath("//span[@class=\"label\"][text()=\"Account\"]");
    private By cartButton = By.xpath("//span[@class=\"label\"][contains(.,\"Cart\")]");
    private By accountDropMenu = By.xpath("//div[@id=\"header-account\"]");
    private By myAccountDropOption = By.xpath("//div[@id=\"header-account\"]/descendant::a[@href=\"https://ecommerce.tealiumdemo.com/customer/account/\"]");
    private By checkoutDropOption = By.xpath("//div[@id=\"header-account\"]/descendant::a[@title=\"Checkout\"]");
    private By registerDropOption= By.xpath("//div[@id=\"header-account\"]/descendant::a[@title=\"Register\"]");
    private By logOutDropOption = By.xpath("//a[@title=\"Log Out\"]");

    //METHODS
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }
    public void clickMyAccountButton() {
        driver.findElement(myAccountDropOption).click();
    }
    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }
    public boolean logOutButtonIsDisplayed() {
        waitForElementToBeVisible(driver, 10, logOutDropOption);
        return driver.findElement(logOutDropOption).isDisplayed();
    }

}
