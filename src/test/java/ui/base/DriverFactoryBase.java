package ui.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.DriverFactory;

public class DriverFactoryBase {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static Actions actions;
	protected static JavascriptExecutor je;
	protected static TakesScreenshot ts;

	@Parameters(value = { "browser" })
	@BeforeMethod
	protected void setUp(@Optional("default") String browser) {
		System.setProperty("browser", browser);
		System.out.println("Test start:");
		driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);
		je = (JavascriptExecutor) driver;
		ts = (TakesScreenshot) driver;
	}

	@AfterMethod
	protected void tearDown() {
		DriverFactory.reset();
		System.out.println("Test completed.\n");
	}

}
