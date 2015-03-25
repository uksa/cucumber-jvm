package pages;

import org.openqa.selenium.By;

/**
 * Created by sam on 17/07/2014.
 */
public class HeaderContainer extends Base {

    private By headerLinks = By.cssSelector(".nav.pull-right>li>a");

    public SignInPage openSignInPage(){
        clickHeaderLink(headerLinks);
        return new SignInPage();
    }

    public void clickHeaderLink(By links){
        clickLinkItemByName(links, "Sign In");
    }


}
