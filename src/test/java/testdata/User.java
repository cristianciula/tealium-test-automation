package testdata;

import static testdatafiles.UserData.*;

public final class User {

    private String email;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;

    //CONSTRUCTOR
    public User() {
        this.email = EMAIL.getValue();
        this.password = PASSWORD.getValue();
        this.firstName = FIRST_NAME.getValue();
        this.middleName = MIDDLE_NAME.getValue();
        this.lastName = LAST_NAME.getValue();
    }

    //GETTERS
    public String getEmail() {
        System.out.println("Email: " + email);
        return email;
    }
    public String getPassword() {
        System.out.println("Password: " + password);
        return password;
    }
    public String getFirstName() {
        System.out.println("First Name: " + firstName);
        return firstName;
    }
    public String getMiddleName() {
        System.out.println("Middle Name: " + middleName);
        return middleName;
    }
    public String getLastName() {
        System.out.println("Last Name: " + lastName);
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
