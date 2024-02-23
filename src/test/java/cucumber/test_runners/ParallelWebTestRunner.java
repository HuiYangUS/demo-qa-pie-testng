package cucumber.test_runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "cucumber.hooks.config",
		"cucumber.step_definitions" }, plugin = { "pretty", "json:target/cucumber-reports/cucumber-report.json",
				"html:target/cucumber-reports/cucumber-report.html" }, tags = "@ui")
public class ParallelWebTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
