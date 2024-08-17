package testdata;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

import static testdatafiles.UserData.*;

public class DataProviders {


    /* -------------------- EMAIL DATA PROVIDERS -------------------- */

    @DataProvider (name = "validEmail")
    public Object[][] validEmail() {
        return new Object[][] {
                {EMAIL.getValue()}
        };
    }

    @DataProvider (name = "invalidEmail")
    public Object[][] invalidEmail() {
        return new Object[][] {
                // Email not associated to an account
                {"unknown@example.com"}
        };
    }

    @DataProvider (name = "invalidEmailSyntax")
    public Object[][] invalidEmailSyntax() {
        return new Object[][]{
                {""},
                {" "},
                {" @example.com"},
                {"user@example. com"},
                {"user @example.com"},
                {"user@ example.com"},
                {"user@example .com"},
                {"@example.com"},
                {"userexample.com"},
                {"user@.com"},
                {"user@examplecom"},
                {"user@example."},
                {"user@example.c"}
        };
    }

    /* -------------------- PASSWORD DATA PROVIDERS -------------------- */

    @DataProvider (name = "validPassword")
    public Object[][] validPassword() {
        return new Object[][] {
                {PASSWORD.getValue()}
        };
    }

    @DataProvider (name = "invalidPassword")
    public Object[][] invalidPassword() {
        return new Object[][] {
                {"Parola000!"}
        };
    }

    @DataProvider (name = "invalidPasswordSyntax")
    public Object[][] invalidPasswordSyntax() {
        return new Object[][] {
                {""},
                {" "},
                {"P"},
                {"123"},
                {"P123"},
                {"ParolaParola"},
                {"ParolaParola100"},
                {"ParolaParola!"},
                {"1234567890"},
                {"1234567890!"}
        };
    }

    /* -------------------- USER NAMES DATA PROVIDERS -------------------- */

    @DataProvider (name = "validFirstName")
    public Object[][] validFirstName() {
        return new Object[][] {
                {FIRST_NAME.getValue()}
        };
    }

    @DataProvider (name = "validMiddleName")
    public Object[][] validMiddleName() {
        return new Object[][] {
                {MIDDLE_NAME.getValue()}
        };
    }

    @DataProvider (name = "validLastName")
    public Object[][] validLastName() {
        return new Object[][] {
                {LAST_NAME.getValue()}
        };
    }

    @DataProvider (name = "validFirstAndLastName")
    public Object[][] validNames() {
        return new Object[][] {
                {FIRST_NAME.getValue(), MIDDLE_NAME.getValue(), LAST_NAME.getValue()}
        };
    }

    /* -------------------- COMBINED EMAIL & PASSWORD DATA PROVIDERS -------------------- */

    @DataProvider (name = "validEmailValidPassword")
    public Object[][] validEmailValidPassword() {

        //Prerequisites
        Object[][] dataProvider1 = validEmail();
        Object[][] dataProvider2 = validPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "validEmailInvalidPassword")
    public Object[][] validEmailInvalidPassword() {

        //Prerequisites
        Object[][] dataProvider1 = validEmail();
        Object[][] dataProvider2 = invalidPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "validEmailInvalidPasswordSyntax")
    public Object[][] validEmailInvalidPasswordSyntax() {

        //Prerequisites
        Object[][] dataProvider1 = validEmail();
        Object[][] dataProvider2 = invalidPasswordSyntax();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "invalidEmailInvalidPassword")
    public Object[][] invalidEmailInvalidPassword() {

        //Prerequisites
        Object[][] dataProvider1 = invalidEmail();
        Object[][] dataProvider2 = invalidPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "invalidEmailValidPassword")
    public Object[][] invalidEmailValidPassword() {

        //Prerequisites
        Object[][] dataProvider1 = invalidEmail();
        Object[][] dataProvider2 = validPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "invalidEmailSyntaxValidPassword")
    public Object[][] invalidEmailSyntaxValidPassword() {

        //Prerequisites
        Object[][] dataProvider1 = invalidEmailSyntax();
        Object[][] dataProvider2 = validPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

}