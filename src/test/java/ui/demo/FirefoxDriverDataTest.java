package ui.demo;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirefoxDriverDataTest {

	private FirefoxDriver driver;

	@BeforeMethod
	void setUp() {
		driver = new FirefoxDriver(new GeckoDriverService.Builder()
				.usingDriverExecutable(new File("src/test/resources/drivers/firefoxdriver/geckodriver.exe")).build());
		driver.manage().window().maximize();
	}

	@AfterMethod
	void tearDown() {
		driver.quit();
	}

	@Test
	void runTest() {
		System.out.println("browserName: " + driver.getCapabilities().getBrowserName());
		System.out.println("browserVersion: " + driver.getCapabilities().getVersion());
		System.out.println("geckodriverVersion: " + driver.getCapabilities().getCapability("moz:geckodriverVersion"));
	}

}
