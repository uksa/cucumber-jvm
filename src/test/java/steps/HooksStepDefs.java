package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import support.BrowserDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by sam on 10/07/2014.
 */
public class HooksStepDefs extends BrowserDriver {

    @Before
    public void setUp(Scenario scenario) throws IOException {
        /*
        SauceLabs (https://saucelabs.com/platforms)
        Jenkins Jobs will require environment variables to be set e.g.:
         export SELENIUM_BROWSER=chrome
         export SELENIUM_VERSION=26
         export SELENIUM_PLATFORM=Windows 7
        */

        /* Not currently used as no implementation yet for SauceLabs
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(System.getenv("SELENIUM_BROWSER"));
        desiredCapabilities.setVersion(System.getenv("SELENIUM_VERSION"));
        desiredCapabilities.setCapability(CapabilityType.PLATFORM, System.getenv("SELENIUM_PLATFORM"));
        desiredCapabilities.setCapability("name", "Web Automation Tests" + scenario.getSourceTagNames());
        desiredCapabilities.setCapability("screen-resolution", "1280x1024");
        desiredCapabilities.setCapability("record-screenshots", false);
        desiredCapabilities.setCapability("record-video", false);
        driver = new RemoteWebDriver(
                new URL("http://anatwine:d8827c01-46e2-4eff-8d31-966cb1303d48@ondemand.saucelabs.com:80/wd/hub"),
                desiredCapabilities);

        */

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

//        driver = new RemoteWebDriver( new URL("http://localhost:4444/wd/hub"), capabilities);
        /* Uncomment line/Change Driver for Local Display*/
        driver = new FirefoxDriver(capabilities);
//        */
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //sometimes waitrose-cellar might never load the homepage in
        //this timeout will fire after 120 Seconds - this should really be plenty
        //for a website to load a page in!
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(home);
    }

    @After
    public void tearDownAfterScenario(Scenario result) throws IOException {
        if(result.isFailed())
        {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            try {
                final byte[] screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.BYTES);
                result.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
        driver.quit();
    }

}
