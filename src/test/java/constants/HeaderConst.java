package constants;

import testdata.User;


public class HeaderConst {

    public static User validUser = new User("validUser");

    //----------TITLES----------//

    //----------MESSAGES----------//
    public final static String HEADER_WELCOME_MESSAGE = "WELCOME, " + validUser.getFirstName() + " " + validUser.getLastName() + "!";


    //----------LABELS----------//
}
