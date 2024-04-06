package dataprovider;

import org.testng.annotations.DataProvider;

public class dataProviders {

    @DataProvider (name = "validCredentials")
    public static Object[][] validCredentials() {
        return new Object[][]{
                {"testuser01@example.com", "Parola100!"}

        };
    }

    @DataProvider (name = "invalidCredentials")
    public static Object[][] invalidCredentials() {
        return new Object[][] {

            // Invalid Email with Valid Password
                {"", "Parola100!"},
                {" ", "Parola100!"},
                {"aexample.com", "Parola100!"},
                {"a@b.c", "Parola100!"},
                {"_@_._", "Parola100!"},
                {"unregisteredemail@example.com", "Parola100!"},

            //Valid Email with Invalid Password
                {"testuser01@example.com", ""},
                {"testuser01@example.com", " "},
                {"testuser01@example.com", "invalidPassword"}
        };
    }

    @DataProvider (name = "validUserInfo")
    public static Object[][] validUserInfo() {
        return new Object[][] {
                {validCredentials()[0][0]}
        };
    }
}