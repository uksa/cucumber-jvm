package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sam on 10/07/2014.
 */
public class SignInPage extends Base {

    private By usernameLocator = By.cssSelector("#user_email");
    private By passwordLocator = By.cssSelector("#user_password");
    private By submit = By.name("commit");
    private By h3Tag = By.cssSelector(".container>h3");

    public SignInPage(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(h3Tag));
        assertEquals("UK Software Alliance | Sign in", driver.getTitle());
    }

    public SignInPage enterUsername(String email){
        driver.findElement(usernameLocator).sendKeys(email);
        return this;
    }

    public SignInPage enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public void submitLogin(){
        driver.findElement(submit).click();
    }

    public MemberDetails signInAs(String email, String password){
        enterUsername(email);
        enterPassword(password);
        submitLogin();
        return new MemberDetails();
    }

    public SignInPage attemptSignInAs(String email, String password){
        enterUsername(email);
        enterPassword(password);
        submitLogin();
        return new SignInPage();
    }

    public String getSectionTitle(){
        return driver.findElement(h3Tag).getText();
    }

}
