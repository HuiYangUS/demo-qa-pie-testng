package ui.demo;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ui.base.DriverFactoryBase;

public class FirefoxTest extends DriverFactoryBase {

	private static String url = "https://www.lambdatest.com/selenium-playground/";

	@BeforeTest
	static void beforeAllTest() {
		System.setProperty("browser", "firefox");
	}

	@Test
	void checkboxDemoTest() {
		driver.navigate().to(url);
		driver.findElement(By.linkText("Checkbox Demo")).click();
		wait.until(ExpectedConditions.urlContains("selenium-playground/checkbox-demo"));
		By checkboxLocator = By.id("isAgeSelected");
		System.out.println("Before click - is checkbox selected: " + driver.findElement(checkboxLocator).isSelected());
		driver.findElement(checkboxLocator).click();
		assertTrue(driver.findElement(checkboxLocator).isSelected(), "Checkbox is not clicked.");
	}

	@Test
	void demoTest() {
		GeckoDriverInfo driverInfo = new GeckoDriverInfo();
		System.out.println("Driver is " + (driverInfo.isAvailable() ? "" : "not ") + "ready.");
	}

}
