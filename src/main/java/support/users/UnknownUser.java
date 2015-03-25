package support.users;

import support.users.BaseUser;
import support.users.UserDetails.LoginDetails;

/**
 * Created by sam on 10/07/2014.
 */
public class UnknownUser extends BaseUser {

    public UnknownUser() {
        super(new LoginDetails());
        setLoginDetails();
    }

    private void setLoginDetails() {
        this.getLoginDetails().setEmail("unknown@email.com");
        this.getLoginDetails().setPassword("Password1");
    }
}
