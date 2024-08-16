package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testdata.URL;
import testdata.User;
import wrappers.WaitsWrapper;

import java.util.ArrayList;
import java.util.List;

import static tests.BaseTest.user;
import static wrappers.SeleniumWrapper.*;

public class SignUpPage {

    WebDriver driver;
    WaitsWrapper waitsWrapper;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.waitsWrapper = new WaitsWrapper(driver);
    }

    //____________________LOCATORS____________________//
    private final By pageTitle = By.xpath("//div[@class=\"page-title\"]");
    private final By firstNameInput = By.id("firstname");
    private final By middleNameInput = By.id("middlename");
    private final By lastNameInput = By.id("lastname");
    private final By emailInput = By.id("email_address");
    private final By passwordInput = By.id("password");
    private final By confirmPasswordInput = By.id("confirmation");
    private final By rememberMeCheckbox = By.xpath("//input[@title=\"Remember Me\"]");
    private final By registerButton = By.xpath("//button[@title=\"Register\"]");
    private final By inputErrors = By.xpath("//div[@class=\"validation-advice\"]");
    private final By firstNameInputError = By.id("advice-required-entry-firstname");
    private final By lastNameInputError = By.id("advice-required-entry-lastname");
    private final By emailInputError = By.id("advice-required-entry-email_address");
    private final By passwordInputError = By.id("advice-required-entry-password");
    private final By confirmPasswordInputError = By.id("advice-required-entry-confirmation");

    //____________________PRIVATE METHODS____________________//
    private void enterFirstName(String string) {
        sendText(firstNameInput, string);
    }
    private void enterMiddleName(String string) {
        sendText(middleNameInput, string);
    }
    private void enterLastName(String string) {
        sendText(lastNameInput, string);
    }
    private void enterConfirmPassword(String string) {
        sendText(confirmPasswordInput, string);
    }
    private void clickRememberMeCheckbox() {
        click(rememberMeCheckbox);
    }
    private boolean isRememberMeCheckboxSelected() {
        return isElementSelected(rememberMeCheckbox);
    }

    //-------------------------------------------------------------------------------------------------------------//

    //____________________PUBLIC METHODS____________________//
    public void navigateToCreateAccountPage() {
        goToUrl(URL.SIGN_UP_PAGE);
    }
    public String getPageTitle() {
        return getText(pageTitle);
    }
    public void enterEmail(String string) {
        sendText(emailInput, string);
    }
    public void enterPassword(String string) {
        sendText(passwordInput, string);
    }
    //TODO: Update method after fixing the User class
    public void fillCreateAccountForm(User user) {
        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        enterConfirmPassword(user.getPassword());
    }
    public void clearCreateAccountForm() {
        clear(firstNameInput);
        clear(middleNameInput);
        clear(lastNameInput);
        clear(emailInput);
        clear(passwordInput);
        clear(confirmPasswordInput);
    }
    public void clearEmailField() {
        clear(emailInput);
    }
    public void unselectRememberMeCheckbox() {
        if(isElementSelected(rememberMeCheckbox)) {
            clickRememberMeCheckbox();
        }
    }
    public void selectRememberMeCheckbox() {
        if(!isElementSelected(rememberMeCheckbox)) {
            clickRememberMeCheckbox();
        }
    }
    public void clickRegister() {
        click(registerButton);
    }

    public void registerUser() {
        fillCreateAccountForm(user);
        clickRegister();
    }
    public boolean isRegisterButtonDisplayed() {
        return isElementDisplayed(registerButton);
    }
    public List<String> getEmptyInputErrorMessages() {
        List<WebElement> inputErrorsElements = driver.findElements(inputErrors);
        List<String> inputErrors = new ArrayList<>();

        for (WebElement inputErrorElement : inputErrorsElements) {
            inputErrors.add(inputErrorElement.getText());
        }
        return inputErrors;
    }
    public boolean areEmptyFieldErrorsDisplayed() {
        List<WebElement> inputErrorsElements = driver.findElements(inputErrors);

        for (WebElement inputErrorElement : inputErrorsElements) {
            if (inputErrorElement.isDisplayed()) {
                return true;
            }
        }
        return false;
    }
}
