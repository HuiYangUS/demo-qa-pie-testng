package ui.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base {

	protected static WebDriver driver;

	@Parameters(value = { "browser" })
	@BeforeMethod
	protected void setUp(@Optional("default") String browser) {
		switch (browser.strip().toLowerCase()) {
		case "chrome":
			setDefault();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/edgedriver/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/firefoxdriver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("No browser is found. Default to chrome.");
			setDefault();
			break;
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	protected void tearDown() {
		driver.quit();
		System.out.println("Test completed.\n");
	}

	private static void setDefault() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

}
