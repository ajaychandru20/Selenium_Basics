package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(


        features = {"featureFiles/Options/Background.feature"},
        glue = {"stepDefinitions"},
//        tags = "@",
//        dryRun = true,
//        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-report-background.html"}


)
public class BackgroundTestRunner {

}
