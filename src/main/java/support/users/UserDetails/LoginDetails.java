package support.users.UserDetails;

import java.util.UUID;

/**
 * Created by sam on 17/07/2014.
 */
public class LoginDetails {

    protected String Email;
    protected String Password;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

}
