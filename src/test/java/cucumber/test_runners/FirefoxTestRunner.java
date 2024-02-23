package cucumber.test_runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "cucumber.hooks.browsers.firefox",
		"cucumber.hooks.config", "cucumber.step_definitions" }, plugin = { "pretty",
				"json:target/cucumber-reports/cucumber-report.json",
				"html:target/cucumber-reports/cucumber-report.html" }, tags = "@ui")
public class FirefoxTestRunner extends AbstractTestNGCucumberTests {

}
