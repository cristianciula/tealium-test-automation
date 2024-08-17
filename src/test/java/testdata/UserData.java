package testdata;

import utils.JSONReaderHelper;

public class UserData {
    private String invalidSyntaxes;

    public UserData(String fileName) {
        this.invalidSyntaxes = JSONReaderHelper.extractValue(fileName, "", "");
    }

    //GETTERS
    public String getInvalidSyntaxes() {
        return invalidSyntaxes;
    }

    //SETTERS
    public void setInvalidSyntaxes(String invalidSyntaxes) {
        this.invalidSyntaxes = invalidSyntaxes;
    }
}
