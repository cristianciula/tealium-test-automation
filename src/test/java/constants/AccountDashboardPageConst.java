package constants;

import testdata.User;

public class AccountDashboardPageConst {

    private final static User validUser = new User("validUser");

    //----------MESSAGES----------//
    public final static String SUCCESSFUL_REGISTRATION_MESSAGE = "Thank you for registering with Tealium Ecommerce.";
    public final static String HELLO_USERNAME_MESSAGE = "Hello, " + validUser.getFirstName() + " " + validUser.getLastName() + "!";

    //----------COLOUR CODES----------//

    //----------LABELS----------//

}
