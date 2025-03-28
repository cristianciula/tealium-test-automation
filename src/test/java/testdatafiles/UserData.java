package testdatafiles;

import utilities.utils.RandomUtils;

public enum UserData {

    //TODO: Need to keep track of created users to avoid trying to create existing users
    //VALID DATA
    EMAIL("testuser" + RandomUtils.alphanumericalString(10) + "@example.com"),
    PASSWORD("Parola100!"),
    FIRST_NAME("First" + RandomUtils.alphabeticalString(3)),
    MIDDLE_NAME("Middle" + RandomUtils.alphabeticalString(3)),
    LAST_NAME("Last" + RandomUtils.alphabeticalString(3));

    private final String value;

    // Constructor
    UserData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
