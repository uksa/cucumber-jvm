package support.users;

import support.users.UserDetails.*;

/**
 * Created by sam on 10/07/2014.
 */
public class BaseUser {

    private final LoginDetails loginDetails;

    public BaseUser(LoginDetails loginDetails) {
        this.loginDetails = loginDetails;
    }

    public LoginDetails getLoginDetails() {
        return loginDetails;
    }
}
