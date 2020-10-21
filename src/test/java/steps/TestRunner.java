package steps;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
                 glue = {"steps"},
                 plugin = {"pretty", "json:target/JSONReports/Report.json"})
public class TestRunner {
}
