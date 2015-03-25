package support.users;

import support.users.UserDetails.*;

/**
 * Created by sam on 10/07/2014.
 */
public class AdminUser extends BaseUser {

    public AdminUser() {
        super(new LoginDetails());
        setLoginDetails();
    }

    private void setLoginDetails() {
        this.getLoginDetails().setEmail("samtreweek@gmail.com");
        this.getLoginDetails().setPassword("Password1");
    }
}
