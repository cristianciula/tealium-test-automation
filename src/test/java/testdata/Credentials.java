package testdata;

import utils.RandomUtils;

public enum Credentials {

    VALID_EMAIL("testuser" + RandomUtils.intValue(100) + "@example.com"),
    VALID_PASSWORD("Parola100!");

    private final String value;

    // Constructor
    Credentials(String value) {
        this.value = value;
    }

    // Getter method
    public String getValue() {
        return value;
    }

}
