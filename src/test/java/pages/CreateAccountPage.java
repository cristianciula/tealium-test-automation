package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.User;

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
}
