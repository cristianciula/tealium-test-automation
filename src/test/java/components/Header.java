package components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import testdata.URL;
import wrappers.WaitsWrapper;

import static wrappers.SeleniumWrapper.*;

public class Header {

    WebDriver driver;
    WaitsWrapper waitsWrapper;

    public Header(WebDriver driver) {
        this.driver = driver;
        this.waitsWrapper = new WaitsWrapper(driver);
    }

    //____________________LOCATORS____________________//
    private final By languageSelect = By.xpath("//select[@id=\"select-language\"]");
    private final By englishLanguageOption = By.xpath("//option[text()=\"English\"]");
    private final By frenchLanguageOption = By.xpath("//option[text()=\"French\"]");
    private final By germanLanguageOption = By.xpath("//option[text()=\"German\"]");
    private final By accountDropdownButton = By.xpath("//span[@class=\"label\"][text()=\"Account\"]");
    private final By logoutDropdownOption = By.xpath("//a[@title=\"Log Out\"]");
    private final By loginDropdownOption = By.xpath("//a[@title=\"Log In\"]");
    private final By myAccountDropdownOption = By.xpath("//div[@id=\"header-account\"]/descendant::a[@href=\"https://ecommerce.tealiumdemo.com/customer/account/\"]");
    private final By registerDropdownOption = By.xpath("//div[@id=\"header-account\"]/descendant::a[@title=\"Register\"]");
    private final By cartButton = By.xpath("//span[@class=\"label\"][contains(.,\"Cart\")]");
    private final By checkoutButton = By.xpath("//div[@id=\"header-account\"]/descendant::a[@title=\"Checkout\"]");
    private final By welcomeMessage = By.xpath("//p[@class=\"welcome-msg\"][contains(.,\"!\")]");

    //____________________PRIVATE METHODS____________________//


    //____________________PUBLIC METHODS____________________//

    public void navigateToHomePage() {
        navigateToUrl(URL.HOME_PAGE);
    }
    public void selectMyAccountDropdownOption() {
        click(myAccountDropdownOption);
    }
    public void clickCartButton() {
        click(cartButton);
    }
    public void selectLoginDropdownOption() {
        click(loginDropdownOption);
    }
    public boolean isLogOutButtonDisplayed() {
        waitsWrapper.waitElementToBeVisible(logoutDropdownOption, 2);
        return isElementDisplayed(logoutDropdownOption);
    }
    public boolean isLoginButtonDisplayed() {
        waitsWrapper.waitElementToBeVisible(loginDropdownOption, 2);
        return isElementDisplayed(loginDropdownOption);
    }
    public void clickAccountDropdownButton() {
        click(accountDropdownButton);
    }
    public void selectLogoutDropdownOption() {
        click(logoutDropdownOption);
        waitsWrapper.waitUrlToBe("https://ecommerce.tealiumdemo.com/", 7);
    }
    public void selectRegisterDropdownOption() {
        click(registerDropdownOption);
        waitsWrapper.waitUrlToBe("https://ecommerce.tealiumdemo.com/customer/account/create/", 2);
    }
    public void logoutUser() {
        try {
            clickAccountDropdownButton();
            selectLogoutDropdownOption();
        }
        catch (NoSuchElementException e) {
            System.out.println("User is not logged in.");
        }
    }
    public String getWelcomeMessage() {
        waitsWrapper.waitElementToBeVisible(welcomeMessage, 2);
        return getText(welcomeMessage);
    }
    public void clickLanguageSelect() {
        click(languageSelect);
    }
    public void selectEnglishLanguageOption() {
        click(englishLanguageOption);
    }
    public void selectFrenchLanguageOption() {
        click(frenchLanguageOption);
    }
    public void selectGermanLanguageOption() {
        click(germanLanguageOption);
    }
}
