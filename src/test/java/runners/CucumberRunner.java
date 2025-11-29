package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "steps",
        },
        plugin = {
                "html:cucumber-reports/cucumber-pretty.html",
                "json:cucumber-reports/CucumberTestReport.json"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
