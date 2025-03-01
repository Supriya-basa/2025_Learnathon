package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import coreComponents.ExtentManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Features/Selenium.feature",
        glue = "stepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
        },
        dryRun = true
)
public class TestRunner {


}