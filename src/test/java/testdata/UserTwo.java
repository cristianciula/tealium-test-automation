package testdata;

import static testdata.Credentials.*;
import static testdata.UserData.*;

public final class UserTwo {

    private String email;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;

    public UserTwo() {
        this.email = VALID_EMAIL.getValue();
        this.password = VALID_PASSWORD.getValue();
        this.firstName = FIRST_NAME.getValue();
        this.middleName = MIDDLE_NAME.getValue();
        this.lastName = LAST_NAME.getValue();
    }

    //GETTERS
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }

    //SETTERS
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
