package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "featureFiles/Options/Hooks.feature",
        glue = {"stepDefinitions", "HooksExample"},
        tags = "@InfinityGauntlet",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class ThanosTestRunner {

}