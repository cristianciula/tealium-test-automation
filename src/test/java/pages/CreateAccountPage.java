package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testdata.User;
import utils.JSExecutorWrapper;

public class CreateAccountPage {

    WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    private final By firstNameInput = By.id("firstname");
    private final By middleNameInput = By.id("middlename");
    private final By lastNameInput = By.id("lastname");
    private final By emailInput = By.id("email_address");
    private final By passwordInput = By.id("password");
    private final By confirmPasswordInput = By.id("confirmation");
    private final By rememberMeCheckbox = By.xpath("//input[@title=\"Remember Me\"]");
    private final By registerButton = By.xpath("//button[@title=\"Register\"]");

    //METHODS
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }
    public void enterMiddleName(String middleName) {
        driver.findElement(middleNameInput).sendKeys(middleName);
    }
    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void enterConfirmPassword(String password) {
        driver.findElement(confirmPasswordInput).sendKeys(password);
    }
    public void fillMandatoryCreateAccountForm(User user) {
        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        enterConfirmPassword(user.getPassword());
    }
    public void fillEntireCreateAccountForm(User user) {
        enterFirstName(user.getFirstName());
        enterMiddleName(user.getMiddleName());
        enterLastName(user.getLastName());
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        enterConfirmPassword(user.getPassword());
    }
    public void clickRememberMeCheckbox() {
        driver.findElement(rememberMeCheckbox).click();
    }
    public boolean rememberMeCheckboxIsSelected() {
        return driver.findElement(rememberMeCheckbox).isSelected();
    }
    public void clickRegisterButton() {
        WebElement regButton = driver.findElement(registerButton);
        /*
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", regButton);

         */
        JSExecutorWrapper.scrollToElement(driver, regButton);
        regButton.click();
    }
}
