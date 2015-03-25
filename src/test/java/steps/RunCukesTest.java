package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = {"src/test/resources/features/"},
                  format   = {"pretty", "html:target/cucumber-html-report",
                              "junit:target/cucumber-junit-report/report.xml",
                              "json:target/cucumber-json-report/report.json"},
                  tags     = {"~@wip"}
                )

public class RunCukesTest {
}
