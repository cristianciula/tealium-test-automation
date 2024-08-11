package testdata;

public enum UserData {

    FIRST_NAME("First"),
    MIDDLE_NAME("Middle"),
    LAST_NAME("Last");

    private final String value;

    // Constructor
    UserData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
