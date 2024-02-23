package cucumber.step_definitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.demo.DemoAppLoginPage;
import utilities.DriverFactory;
import utilities.MyTestUtils;

public class DemoAppLoginSteps {

	private static WebDriver driver = DriverFactory.getDriver();
	private static DemoAppLoginPage loginPage = new DemoAppLoginPage();

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		loginPage.loadPage();
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		loginPage.enterUsername("username");
		loginPage.enterPassword("password");
		MyTestUtils.pause(1);
	}

	@When("user clicks on the [Login] button")
	public void user_clicks_on_the_login_button() {
		loginPage.submitLogin();
		MyTestUtils.pause(1);
	}

	@Then("user is on the inventory page")
	public void user_is_on_the_inventory_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "wrong page");
	}

}
