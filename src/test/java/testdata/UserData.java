package testdata;

public enum UserData {


    //TODO: Merge this class into Credentials class and rename Credential class to UserData.
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
