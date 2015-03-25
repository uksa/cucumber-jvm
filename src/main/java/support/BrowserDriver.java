package support;

import org.openqa.selenium.WebDriver;

/**
 * Created by sam on 04/03/2014.
 */


public class BrowserDriver {
    protected static WebDriver driver;
    protected String scheme = "http://";
    protected String host = "uksa-testing.co.uk/";
    protected String home = scheme + host;
}
