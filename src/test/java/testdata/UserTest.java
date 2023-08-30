package testdata;

import utils.JSONParserUtil;

public final class UserTest {

    private String email;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String company;
    private String telephone;
    private String fax;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;
    private String country;

    public UserTest(String fileName) {
        this.email = JSONParserUtil.extractValue(fileName, "invalidEmailAddress");
        this.password = JSONParserUtil.extractValue(fileName, "password");
        this.firstName = JSONParserUtil.extractValue(fileName, "password");
        this.middleName = JSONParserUtil.extractValue(fileName, "password");
        this.lastName = JSONParserUtil.extractValue(fileName, "password");
        this.company = JSONParserUtil.extractValue(fileName, "password");
        this.telephone = JSONParserUtil.extractValue(fileName, "password");
        this.fax = JSONParserUtil.extractValue(fileName, "password");
        this.street1 = JSONParserUtil.extractValue(fileName, "password");
        this.street2 = JSONParserUtil.extractValue(fileName, "password");
        this.city = JSONParserUtil.extractValue(fileName, "password");
        this.state = JSONParserUtil.extractValue(fileName, "password");
        this.zip = JSONParserUtil.extractValue(fileName, "password");
        this.country = JSONParserUtil.extractValue(fileName, "password");
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
    public String getCompany() {
        return company;
    }
    public String getTelephone() {
        return telephone;
    }
    public String getFax() {
        return fax;
    }
    public String getStreet1() {
        return street1;
    }
    public String getStreet2() {
        return street2;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZip() {
        return zip;
    }
    public String getCountry() {
        return country;
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
    public void setCompany(String company) {
        this.company = company;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public void setStreet1(String street1) {
        this.street1 = street1;
    }
    public void setStreet2(String street2) {
        this.street2 = street2;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
