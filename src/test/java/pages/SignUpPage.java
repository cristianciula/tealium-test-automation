package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testdata.URL;
import testdata.User;

import java.util.ArrayList;
import java.util.List;

import static wrapers.SeleniumUtils.*;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //____________________LOCATORS____________________//
    private By pageTitle = By.xpath("//div[@class=\"page-title\"]");
    private By firstNameInput = By.id("firstname");
    private By middleNameInput = By.id("middlename");
    private By lastNameInput = By.id("lastname");
    private By emailInput = By.id("email_address");
    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("confirmation");
    private By rememberMeCheckbox = By.xpath("//input[@title=\"Remember Me\"]");
    private By registerButton = By.xpath("//button[@title=\"Register\"]");
    private By inputErrors = By.xpath("//div[@class=\"validation-advice\"]");
    private By firstNameInputError = By.id("advice-required-entry-firstname");
    private By lastNameInputError = By.id("advice-required-entry-lastname");
    private By emailInputError = By.id("advice-required-entry-email_address");
    private By passwordInputError = By.id("advice-required-entry-password");
    private By confirmPasswordInputError = By.id("advice-required-entry-confirmation");

    //____________________PRIVATE METHODS____________________//
    private void enterFirstName(String string) {
        sendKeys(firstNameInput, string);
    }
    private void enterMiddleName(String string) {
        sendKeys(middleNameInput, string);
    }
    private void enterLastName(String string) {
        sendKeys(lastNameInput, string);
    }
    private void enterConfirmPassword(String string) {
        sendKeys(confirmPasswordInput, string);
    }
    private void clickRememberMeCheckbox() {
        click(rememberMeCheckbox);
    }
    private boolean rememberMeCheckboxIsSelected() {
        return isElementSelected(rememberMeCheckbox);
    }

    //-------------------------------------------------------------------------------------------------------------//

    //____________________PUBLIC METHODS____________________//
    public void navigateToCreateAccountPage() {
        navigateTo(URL.CREATE_ACCOUNT_PAGE);
    }
    public String getPageTitle() {
        return getText(pageTitle);
    }
    public void enterEmail(String string) {
        sendKeys(emailInput, string);
    }
    public void enterPassword(String string) {
        sendKeys(passwordInput, string);
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
    public boolean registerButtonIsDisplayed() {
        return isElementDisplayed(registerButton);
    }
    public List<String> getEmptyInputErrors() {
        List<WebElement> inputErrorsElements = driver.findElements(inputErrors);
        List<String> inputErrors = new ArrayList<>();

        for (WebElement inputErrorElement : inputErrorsElements) {
            inputErrors.add(inputErrorElement.getText());
        }
        return inputErrors;
    }
    public boolean emptyFieldErrorsAreDisplayed() {
        List<WebElement> inputErrorsElements = driver.findElements(inputErrors);

        for (WebElement inputErrorElement : inputErrorsElements) {
            if (inputErrorElement.isDisplayed()) {
                return true;
            }
        }
        return false;
    }
}
