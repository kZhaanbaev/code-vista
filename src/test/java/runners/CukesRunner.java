package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/report.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "io.techleadacademy.stepDefs",
        stepNotifications = true,
        tags = "@US100",
        dryRun = true
)
public class CukesRunner {

}
