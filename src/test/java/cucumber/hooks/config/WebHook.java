package cucumber.hooks.config;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import utilities.DriverFactory;

public class WebHook {

	@Before("@ui or @e2e or @web")
	public void beforeScenario() {
		DriverFactory.getDriver();

	}

	@After("@ui or @e2e or @web")
	public void afterScenario() {
		DriverFactory.reset();
	}

}
