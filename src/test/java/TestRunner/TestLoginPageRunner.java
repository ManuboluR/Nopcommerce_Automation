package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/root/Features/Login.feature",
        glue = "StepDefinations",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-reports/Cucumber.html"}
)
public class TestLoginPageRunner {
}
