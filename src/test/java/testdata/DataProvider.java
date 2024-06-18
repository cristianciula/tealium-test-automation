package testdata;

import java.util.ArrayList;
import java.util.List;

import static testdata.Credentials.*;

public class DataProvider {

    /* -------------------- EMAIL DATA PROVIDERS -------------------- */

    @org.testng.annotations.DataProvider(name = "validEmailAddress")
    public Object[][] validEmail() {
        return new Object[][] {
                {VALID_EMAIL.getName()}
        };
    }

    @org.testng.annotations.DataProvider(name = "invalidEmail")
    public Object[][] invalidEmail() {
        return new Object[][] {
                // Unknown email
                {"unknown@example.com"}
        };
    }

    @org.testng.annotations.DataProvider(name = "invalidEmailSyntax")
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

    @org.testng.annotations.DataProvider(name = "validPassword")
    public Object[][] validPassword() {
        return new Object[][] {
                {VALID_PASSWORD.getName()}
        };
    }

    @org.testng.annotations.DataProvider(name = "invalidPassword")
    public Object[][] invalidPassword() {
        return new Object[][] {
                {"Parola000!"}
        };
    }

    @org.testng.annotations.DataProvider(name = "invalidPasswordSyntax")
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

    /* -------------------- COMBINED EMAIL & PASSWORD DATA PROVIDERS -------------------- */

    @org.testng.annotations.DataProvider(name = "validEmailValidPassword")
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

    @org.testng.annotations.DataProvider(name = "validEmailInvalidPassword")
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

    @org.testng.annotations.DataProvider(name = "validEmailInvalidPasswordSyntax")
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

    @org.testng.annotations.DataProvider(name = "invalidEmailInvalidPassword")
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

    @org.testng.annotations.DataProvider(name = "invalidEmailValidPassword")
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

}