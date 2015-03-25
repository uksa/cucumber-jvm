package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import pages.MemberDetails;
import pages.SignInPage;

import static org.junit.Assert.assertEquals;

/**
 * Created by sam on 25/03/2015.
 */
public class MemberDetailsStepDefs {

    MemberDetails memberDetails;

    public MemberDetailsStepDefs(SignInStepdefs signInStepdefs){
        memberDetails = signInStepdefs.memberDetails;
    }

    @Then("^I will see my Member Details$")
    public void I_will_see_my_Member_Details() throws Throwable {
        assertEquals("Member Details", memberDetails.sectionTitle());
    }

}
