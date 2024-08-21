package testdata.DataProviders;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static testdatafiles.UserData.EMAIL;
import static testdatafiles.UserData.FIRST_NAME;
import static testdatafiles.UserData.LAST_NAME;
import static testdatafiles.UserData.MIDDLE_NAME;
import static testdatafiles.UserData.PASSWORD;

public class UserDataProviders {

    /* -------------------- EMAIL DATA PROVIDERS -------------------- */

    @DataProvider (name = "validEmail")
    public Object[][] validEmail() {
        return new Object[][] {
                {EMAIL.getValue()}
        };
    }

    @DataProvider (name = "unknownEmail")
    public Object[][] wrongEmail() {
        return new Object[][] {
                // Email not associated to an account
                {"wrong@example.com"}
        };
    }

    @DataProvider (name = "emptyEmail")
    public Object[][] emptyEmail() {
        return new Object[][] {
                {""},
                {" "}
        };
    }

    @DataProvider (name = "invalidEmailSyntax")
    public Object[][] invalidEmailSyntax() {
        return new Object[][] {
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

    @DataProvider (name = "invalidEmails")
    public Object[][] invalidEmail() {

                Object[][] data1 = wrongEmail();
                Object[][] data2 = emptyEmail();
                Object[][] data3 = invalidEmailSyntax();

        return Stream.of(data1, data2, data3)
                        .flatMap(Arrays::stream)
                        .toArray(Object[][]::new);
    }

    /* -------------------- PASSWORD DATA PROVIDERS -------------------- */

    @DataProvider (name = "validPassword")
    public Object[][] validPassword() {
        return new Object[][] {
                {PASSWORD.getValue()}
        };
    }

    @DataProvider (name = "wrongPassword")
    public Object[][] wrongPassword() {
        return new Object[][] {
                {"Qwerty123!"}
        };
    }

    @DataProvider (name = "emptyPassword")
    public Object[][] emptyPassword() {
        return new Object[][] {
                {""},
                {" "}
        };
    }

    @DataProvider (name = "invalidPasswordSyntax")
    public Object[][] invalidPasswordSyntax() {
        return new Object[][] {
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

    @DataProvider (name = "invalidPassword")
    public Object[][] invalidPassword() {

        Object[][] data1 = wrongPassword();
        Object[][] data2 = emptyPassword();
        Object[][] data3 = invalidPasswordSyntax();

        return Stream.of(data1, data2, data3)
                .flatMap(Arrays::stream)
                .toArray(Object[][]::new);
    }

    /* -------------------- COMBINED EMAIL & PASSWORD DATA PROVIDERS -------------------- */

    @DataProvider (name = "validEmailValidPassword")
    public Object[][] validEmailValidPassword() {

        //  Prerequisites
        Object[][] dataProvider1 = validEmail();
        Object[][] dataProvider2 = validPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //  Combine the data
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

        //  Prerequisites
        Object[][] dataProvider1 = validEmail();
        Object[][] dataProvider2 = invalidPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //  Combine the data
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

        //  Prerequisites
        Object[][] dataProvider1 = invalidEmail();
        Object[][] dataProvider2 = validPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //  Combine the data
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

        //  Prerequisites
        Object[][] dataProvider1 = invalidEmail();
        Object[][] dataProvider2 = invalidPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //  Combine the data
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

        //  Prerequisites
        Object[][] dataProvider1 = invalidEmailSyntax();
        Object[][] dataProvider2 = validPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //  Combine the data
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

//    @DataProvider (name = "validEmailInvalidPasswordSyntax")
//    public Object[][] validEmailInvalidPasswordSyntax() {
//
//        //Prerequisites
//        Object[][] dataProvider1 = validEmail();
//        Object[][] dataProvider2 = invalidPasswordSyntax();
//        List<Object[]> combinedDataProviders = new ArrayList<>();
//
//        //Combine the data
//        for (Object[] dataProvider1Obj : dataProvider1) {
//            for (Object[] dataProvider2Obj : dataProvider2) {
//                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
//                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
//                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
//                combinedDataProviders.add(combinedItem);
//            }
//        }
//        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
//    }

//

//    @DataProvider (name = "invalidEmailSyntaxValidPassword")
//    public Object[][] invalidEmailSyntaxValidPassword() {
//
//        //Prerequisites
//        Object[][] dataProvider1 = invalidEmailSyntax();
//        Object[][] dataProvider2 = validPassword();
//        List<Object[]> combinedDataProviders = new ArrayList<>();
//
//        //Combine the data
//        for (Object[] dataProvider1Obj : dataProvider1) {
//            for (Object[] dataProvider2Obj : dataProvider2) {
//                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
//                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
//                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
//                combinedDataProviders.add(combinedItem);
//            }
//        }
//        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
//    }

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

}