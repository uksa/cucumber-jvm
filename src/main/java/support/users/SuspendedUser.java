package support.users;

import support.users.BaseUser;
import support.users.UserDetails.LoginDetails;

/**
 * Created by sam on 10/07/2014.
 */
public class SuspendedUser extends BaseUser {

    public SuspendedUser() {
        super(new LoginDetails());
        setLoginDetails();
    }

    private void setLoginDetails() {
        this.getLoginDetails().setEmail("samtreweek@hotmail.com");
        this.getLoginDetails().setPassword("Password1");
    }
}
