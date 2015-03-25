package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HeaderContainer;
import pages.MemberDetails;
import pages.SignInPage;
import support.users.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by sam on 10/07/2014.
 */
public class SignInStepdefs {

    BaseUser user;
    HeaderContainer headerContainer = new HeaderContainer();
    MemberDetails memberDetails;
    SignInPage signInPage;

    @Given("^I'm a Admin User$")
    public void I_m_a_Admin_User() throws Throwable {
        user = new AdminUser();
    }

    @Given("^I'm a Standard User$")
    public void I_m_a_Standard_User() throws Throwable {
        user = new StandardUser();
    }

    @Given("^I'm a Suspended User$")
    public void I_m_a_Suspended_User() throws Throwable {
        user = new SuspendedUser();
    }

    @Given("^I'm a Unknown User$")
    public void I_m_a_Unknown_User() throws Throwable {
        user = new UnknownUser();
    }

    @When("^I Sign into the application$")
    public void I_Sign_into_the_application() throws Throwable {
        signInPage = headerContainer.openSignInPage();
        memberDetails = signInPage.signInAs(user.getLoginDetails().getEmail(), user.getLoginDetails().getPassword());
    }

    @When("^I attempt to Sign into the application$")
    public void I_attempt_to_Sign_into_the_application() throws Throwable {
        signInPage = headerContainer.openSignInPage();
        signInPage = signInPage.attemptSignInAs(user.getLoginDetails().getEmail(), user.getLoginDetails().getPassword());

    }

    @Given("^I'm a Signed in Admin User$")
    public void I_m_a_Signed_in_Admin_User() throws Throwable {
        user = new AdminUser();
        signInPage = headerContainer.openSignInPage();
        memberDetails = signInPage.signInAs(user.getLoginDetails().getEmail(), user.getLoginDetails().getPassword());
    }

    @Then("^I will still be on the Sign in page$")
    public void I_will_still_be_on_the_Sign_in_page() throws Throwable {
        assertEquals("Sign in", signInPage.getSectionTitle());
    }
}
