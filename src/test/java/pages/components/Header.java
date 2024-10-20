package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import testdata.URL;
import utilities.helpers.WaitsHelper;

import static utilities.helpers.SeleniumHelper.*;

public class Header {

    WebDriver driver;
    WaitsHelper wait;

    public Header(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitsHelper(driver);
    }

    //____________________LOCATORS____________________//

    private final By languageSelector = By.xpath("//select[@id=\"select-language\"]");
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

    //____________________METHODS____________________//

    public void navigateToHomePage() {
        getUrl(URL.HOME_PAGE);
    }

    public void clickMyAccountDropdownOption() {
        click(myAccountDropdownOption);
    }

    public void clickCartButton() {
        click(cartButton);
    }

    public void clickLoginDropdownOption() {
        click(loginDropdownOption);
    }

    public boolean isLogoutButtonDisplayed() {
        wait.waitElementToBeVisible(logoutDropdownOption, 2);
        return isElementDisplayed(logoutDropdownOption);
    }

    public boolean isLoginButtonDisplayed() {
        wait.waitElementToBeVisible(loginDropdownOption, 2);
        return isElementDisplayed(loginDropdownOption);
    }

    public void clickAccountDropdownButton() {
        click(accountDropdownButton);
    }

    public void clickLogoutDropdownOption() {
        wait.waitElementToBeVisible(logoutDropdownOption, 2);
        click(logoutDropdownOption);
        wait.waitUrlToBe("https://ecommerce.tealiumdemo.com/", 7);
    }

    public void clickRegisterDropdownOption() {
        click(registerDropdownOption);
        wait.waitUrlToBe("https://ecommerce.tealiumdemo.com/customer/account/create/", 2);
    }

    public void logoutUser() {
        try {
            clickAccountDropdownButton();
            clickLogoutDropdownOption();
        }
        catch (NoSuchElementException e) {
            System.out.println("User is not logged in.");
        }
    }

    public String getWelcomeMessage() {
        wait.waitElementToBeVisible(welcomeMessage, 2);
        return getText(welcomeMessage);
    }

    public void clickLanguageSelector() {
        click(languageSelector);
    }

    public void selectEnglishLanguage() {
        click(englishLanguageOption);
    }

    public void selectFrenchLanguage() {
        click(frenchLanguageOption);
    }

    public void selectGermanLanguage() {
        click(germanLanguageOption);
    }

}
