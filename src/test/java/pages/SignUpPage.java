package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testdata.URL;
import testdata.User;
import utilities.helpers.WaitsHelper;

import java.util.ArrayList;
import java.util.List;

import static utilities.helpers.SeleniumHelper.*;

public class SignUpPage {

    WebDriver driver;
    WaitsHelper wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitsHelper(driver);
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

    //_____ERROR MESSAGES_____//
    private final By inputErrors = By.xpath("//div[@class=\"validation-advice\"]");
    private final By firstNameInputError = By.id("advice-required-entry-firstname");
    private final By lastNameInputError = By.id("advice-required-entry-lastname");
    private final By emailInputError = By.id("advice-required-entry-email_address");
    private final By passwordInputError = By.id("advice-required-entry-password");
    private final By confirmPasswordInputError = By.id("advice-required-entry-confirmation");
    private final By duplicateAccountError = By.xpath("//li[@class=\"error-msg\"]");

    //____________________METHODS____________________//

    public void enterFirstName(String string) {
        sendText(firstNameInput, string);
    }

    public void enterMiddleName(String string) {
        sendText(middleNameInput, string);
    }

    public void enterLastName(String string) {
        sendText(lastNameInput, string);
    }

    public void enterConfirmPassword(String string) {
        sendText(confirmPasswordInput, string);
    }

    public boolean isRememberMeCheckboxSelected() {
        return isElementSelected(rememberMeCheckbox);
    }

    public void navigateToCreateAccountPage() {
        getUrl(URL.SIGN_UP_PAGE);
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

    public void clearEmailInput() {
        clear(emailInput);
    }

    public void checkRememberMeCheckbox() {
        if(!isElementSelected(rememberMeCheckbox)) {
            click(rememberMeCheckbox);
        }
    }

    public void uncheckRememberMeCheckbox() {
        if(isElementSelected(rememberMeCheckbox)) {
            click(rememberMeCheckbox);
        }
    }

    public void clickRegisterButton() {
        click(registerButton);
        refreshPage();
    }

    public void registerUser(User user) {
        fillCreateAccountForm(user);
        clickRegisterButton();
    }

    public boolean isRegisterButtonDisplayed() {
        return isElementDisplayed(registerButton);
    }

    public List<String> getEmptyMandatoryInputsErrors() {
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

    public boolean isDuplicateAccountErrorDisplayed() {
        return isElementDisplayed(duplicateAccountError);
    }

}
