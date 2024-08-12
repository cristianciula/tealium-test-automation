package testdatafiles;

import utils.RandomUtils;

public enum UserData {

    //VALID DATA
    EMAIL("testuser" + RandomUtils.intValue(100) + "@example.com"),
    PASSWORD("Parola100!"),
    FIRST_NAME("First" + RandomUtils.stringValue(3)),
    MIDDLE_NAME("Middle" + RandomUtils.stringValue(3)),
    LAST_NAME("Last" + RandomUtils.stringValue(3));

    private final String value;

    // Constructor
    UserData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
