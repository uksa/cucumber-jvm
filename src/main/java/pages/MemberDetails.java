package pages;

import org.openqa.selenium.By;

/**
 * Created by sam on 25/03/2015.
 */
public class MemberDetails extends Base {

    private By h3Tag = By.cssSelector(".container>h3");

    public String sectionTitle(){
        return driver.findElement(h3Tag).getText();
    }

}
