package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "featureFiles/Options/Taggs.feature",
        glue = "stepDefinitions/Options"
        , monochrome = true
//        , dryRun = true
//        ,tags = "@SmokeTest", // Change tag here for specific execution
        , tags = "@SmokeTest and @RegressionTest",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunnerTest {


}
