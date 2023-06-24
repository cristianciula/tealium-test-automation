package testdata;

import utils.Reader;

public class User {

    private String email;
    private String password;

    public User(String fileName) {
        this.email = Reader.json(fileName).get("email").toString();
        this.password = Reader.json(fileName).get("password").toString();
    }

    //GETTERS
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    //SETTERS
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
