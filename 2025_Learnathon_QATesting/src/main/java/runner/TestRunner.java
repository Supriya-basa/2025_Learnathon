package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/resources/Features",
    glue = "stepDefinitions",
    plugin = {"pretty", "html:target/cucumber-reports"},
    dryRun = false,
    monochrome = true,
    tags = "@LoginUnsuccessful"
)
public class TestRunner {
}