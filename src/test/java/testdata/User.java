package testdata;

import utils.Reader;

public class User {

    private String email;
    private String password;

    public User(String fileName) {
        this.email = Reader.json(fileName).get("credentials.email").toString();
        this.password = Reader.json(fileName).get("credentials.password").toString();
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
