package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//850999//IdeaProjects//CucumberFrameWork//Features//Login.feature",
        glue = "StepDefinations",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-reports/Cucumber.html"}
)
public class TestLoginPageRunner {
}
