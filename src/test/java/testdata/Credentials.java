package testdata;

import utils.RandomUtils;

public enum Credentials {

    VALID_EMAIL("testuser@example.com"),
    VALID_PASSWORD("Parola100!");

    private final String name;

    // Constructor
    private Credentials(String name) {
        this.name = name;
    }

    // Getter method
    public String getName() {
        return name;
    }

}
