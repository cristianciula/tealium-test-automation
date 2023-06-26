package testdata;

import utils.JSONReader;

public final class User {

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

    public User(String fileName) {
        this.email = JSONReader.json(fileName).get("email").toString();
        this.password = JSONReader.json(fileName).get("password").toString();
        this.firstName = JSONReader.json(fileName).get("firstName").toString();
        this.middleName = JSONReader.json(fileName).get("middleName").toString();
        this.lastName = JSONReader.json(fileName).get("lastName").toString();
        this.company = JSONReader.json(fileName).get("company").toString();
        this.telephone = JSONReader.json(fileName).get("telephone").toString();
        this.fax = JSONReader.json(fileName).get("fax").toString();
        this.street1 = JSONReader.json(fileName).get("street1").toString();
        this.street2 = JSONReader.json(fileName).get("street2").toString();
        this.city = JSONReader.json(fileName).get("city").toString();
        this.state = JSONReader.json(fileName).get("state").toString();
        this.zip = JSONReader.json(fileName).get("zip").toString();
        this.country = JSONReader.json(fileName).get("country").toString();
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
