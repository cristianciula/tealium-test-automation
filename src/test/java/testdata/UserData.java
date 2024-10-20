package testdata;

import utilities.helpers.JSONReaderHelper;

public class UserData {
    private String invalidEmailSyntaxes;

    public UserData(String fileName) {
        this.invalidEmailSyntaxes = JSONReaderHelper.extractValue(fileName, "", "invalidEmailSyntaxes.invalidSyntax");
    }

    //GETTERS
    public String getInvalidEmailSyntaxes() {
        return invalidEmailSyntaxes;
    }

    //SETTERS
    public void setInvalidEmailSyntaxes(String invalidEmailSyntaxes) {
        this.invalidEmailSyntaxes = invalidEmailSyntaxes;
    }
}
