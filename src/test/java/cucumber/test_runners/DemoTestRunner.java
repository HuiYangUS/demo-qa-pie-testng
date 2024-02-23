package cucumber.test_runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features/example.feature" }, glue = {
		"cucumber.step_definitions", }, plugin = { "pretty" }, dryRun = false, tags = "@tag and @test")
public class DemoTestRunner extends AbstractTestNGCucumberTests {

}
