package testdata;

public enum Credentials {

    VALID_EMAIL("testuser@example.com"),
    VALID_PASSWORD("Parola100!");

    private final String name;

    // Constructor
    Credentials(String name) {
        this.name = name;
    }

    // Getter method
    public String getName() {
        return name;
    }

}
