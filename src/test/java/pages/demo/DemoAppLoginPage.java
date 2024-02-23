package pages.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ConfigReader;
import utilities.DriverFactory;

public class DemoAppLoginPage {

	private static String fileName = "config";

	private static WebDriver driver;

	@FindBy(id = "user-name")
	private static WebElement usernameInput;

	@FindBy(id = "password")
	private static WebElement passwordInput;

	@FindBy(id = "login-button")
	private static WebElement loginButton;

	public DemoAppLoginPage() {
		driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void loadPage() {
		driver.navigate().to(ConfigReader.getValue(fileName, "url"));
	}

	public void enterUsername(String username) {
		usernameInput.sendKeys(ConfigReader.getValue(fileName, username));
	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(ConfigReader.getValue(fileName, password));
	}

	public void submitLogin() {
		loginButton.submit();
	}

}
