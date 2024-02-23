package cucumber.test_runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "cucumber.step_definitions", }, plugin = {
		"pretty" }, dryRun = true, tags = "@test")
public class TestDryRunner extends AbstractTestNGCucumberTests {

}
