package utilities;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/*
 * This "DriverFactory" class uses Selenium WebDriver 3.141.59
 */
public class DriverFactory {

	private static ThreadLocal<WebDriver> localDriver;
	private static String browser = "chrome";
	private static boolean headless = false;
	private static boolean isSet = false;
	private static int waitTime = 5;
	private static int count;

	private DriverFactory() {
		count++;
	}

	public static int getCount() {
		return count;
	}

	private static void setUpDriver() {
		String browserKey = "browser";
		if (System.getProperty(browserKey) != null)
			browser = System.getProperty(browserKey).strip().toLowerCase();
		else
			System.out.println("Default browser is used: " + browser);

		String headlessKey = "headless";
		if (System.getProperty(headlessKey) != null)
			headless = Boolean.valueOf(System.getProperty(headlessKey).strip().toLowerCase());
		isSet = true;
	}

	public static synchronized WebDriver getDriver() {
		if (!isSet)
			setUpDriver();
		if (localDriver == null)
			localDriver = new ThreadLocal<WebDriver>();
		if (localDriver.get() == null)
			localDriver.set(initLocalDriver());
		return localDriver.get();
	}

	public static void reset() {
		if (localDriver != null && localDriver.get() != null) {
			localDriver.get().quit();
			localDriver.remove();
		}
		isSet = false;
	}

	private static WebDriver initLocalDriver() {
		WebDriver driver;
		switch (browser) {
		case "chrome":
			driver = getDefaultLocalDriver();
			break;
		case "edge":
			String edgeDriverFilePath = getDriverDir() + "/edgedriver/msedgedriver"
					+ (MyTestUtils.isWindows() ? ".exe" : "");
			System.setProperty("webdriver.edge.driver", edgeDriverFilePath);
			EdgeOptions edgeOptions = new EdgeOptions();
			// create capabilities
			Map<String, Object> capabilities = new HashMap<>();
			Map<String, Object> prefs = new HashMap<String, Object>();
			// turn off personal prompt
			prefs.put("user_experience_metrics.personalization_data_consent_enabled", true);
			capabilities.put("prefs", prefs);
			edgeOptions.setCapability("ms:edgeOptions", capabilities);
			findEdgeHeadless(edgeOptions, capabilities);
			driver = new EdgeDriver(edgeOptions);
			break;
		case "firefox":
			String firefoxDriverFilePath = getDriverDir() + "/firefoxdriver/geckodriver"
					+ (MyTestUtils.isWindows() ? ".exe" : "");
			System.setProperty("webdriver.gecko.driver", firefoxDriverFilePath);
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addPreference("geo.enabled", false);
			findFirefoxHeadless(firefoxOptions);
			driver = new FirefoxDriver(firefoxOptions);
			break;
		default:
			driver = getDefaultLocalDriver();
			break;
		}
		System.out.println(driver.toString().replaceAll("[(].*[)]", ""));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		return driver;
	}

	private static WebDriver getDefaultLocalDriver() {
		String localDriverFilePath = getDriverDir() + "/chromedriver/chromedriver"
				+ (MyTestUtils.isWindows() ? ".exe" : "");
		System.setProperty("webdriver.chrome.driver", localDriverFilePath);
		ChromeOptions options = new ChromeOptions();
		findChromeHeadless(options);
		return new ChromeDriver(options);
	}

	private static void findChromeHeadless(ChromeOptions options) {
		if (headless)
			options.addArguments("--headless");
	}

	private static void findEdgeHeadless(EdgeOptions options, Map<String, Object> capabilities) {
		List<String> args = Arrays.asList("--headless");
		if (headless) {
			capabilities.put("args", args);
			options.setCapability("ms:edgeOptions", capabilities);
		}
	}

	private static void findFirefoxHeadless(FirefoxOptions options) {
		if (headless)
			options.addArguments("-headless");
	}

	public static String getDriverDir() {
		return MyTestUtils.getCurrentDir() + "/src/test/resources/drivers/";
	}

}
