package runners;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "test/automation/steps",
        },
        plugin = {
                "html:cucumber-reports/cucumber-pretty.html",
                "json:cucumber-reports/CucumberTestReport.json"
        }
)
public class CucumberRunner {
}
