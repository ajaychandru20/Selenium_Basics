package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "featureFiles/Options/DryRun.feature",
        glue = "stepDefinitions"
//        , dryRun = true
)
public class RunnerTest {

}
