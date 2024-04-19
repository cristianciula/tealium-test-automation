package dataprovider;

import org.testng.annotations.DataProvider;

import static dataprovider.userDataProvider.validLoginCredentials;

public class signUpDataProvider {

    static Object validEmail = validLoginCredentials()[0][0];
    static Object validPassword = validLoginCredentials()[0][1];

    @DataProvider(name = "userSignUpData")
    public static Object[][] userSignUpData() {
        return new Object[][]{
                {validEmail, validPassword}
        };
    }
}
