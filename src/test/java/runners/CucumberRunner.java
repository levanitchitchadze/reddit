package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//This is testng cucumber runner class
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
