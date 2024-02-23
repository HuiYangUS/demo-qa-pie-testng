package ui.playground;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.playground.HomePage;
import ui.base.DriverFactoryBase;
import utilities.DriverFactory;
import utilities.MyTestUtils;

@SuppressWarnings("unused")
public class SimpleTest extends DriverFactoryBase {

	@Test
	void homePageTest() {
		HomePage homePage = new HomePage();
		homePage.loadPage();
		assertTrue(homePage.isPageLoaded(), "The home page is not loaded.");
	}

	@Test(dependsOnMethods = { "homePageTest" })
	void toFormPageTest() {
		HomePage homePage = new HomePage();
		homePage.loadPage();
		homePage.toFormDemo();
		assertTrue(driver.getCurrentUrl().endsWith("simple-form-demo"), "Simple form demo page is not loaded.");
	}

}
