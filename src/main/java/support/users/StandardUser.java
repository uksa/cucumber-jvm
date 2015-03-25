package support.users;

import support.users.BaseUser;
import support.users.UserDetails.LoginDetails;

/**
 * Created by sam on 10/07/2014.
 */
public class StandardUser extends BaseUser {

    public StandardUser() {
        super(new LoginDetails());
        setLoginDetails();
    }

    private void setLoginDetails() {
        this.getLoginDetails().setEmail("samtreweek@yahoo.co.uk");
        this.getLoginDetails().setPassword("Password1");
    }
}
