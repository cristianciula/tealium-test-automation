package dataprovider;

import org.testng.annotations.DataProvider;

public class userDataProvider {

    @DataProvider (name = "validCredentials")
    public static Object[][] validLoginCredentials() {
        return new Object[][]{
                {"testuser01@example.com", "Parola100!"}
        };
    }

    @DataProvider (name = "invalidCredentials")
    public static Object[][] invalidLoginCredentials() {
        return new Object[][] {

            // Invalid Email with Valid Password
                {"aexample.com", "Parola100!"},
                {"a@b.c", "Parola100!"},
                {"_@_._", "Parola100!"},
                {"unregisteredemail@example.com", "Parola100!"},
                {"testuser137@example.com", "Parola12345!"},

            //Valid Email with Invalid Password
                {"testuser01@example.com", "invalidPassword"}
        };
    }

    @DataProvider (name = "emptyCredentials")
    public static Object[][] emptyLoginCredentials() {
        return new Object[][] {

                // Empty Email and Empty Password
                {"", ""},
                {" ", " "},

                // Empty Email and Valid Password
                {"", "Parola12345!"},

                // Valid Email and Empty Password
                {"testuser137@example.com", ""},
                {"testuser137@example.com", "Parola12345!"}, //test the test
        };
    }
}