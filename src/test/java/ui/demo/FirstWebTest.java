package ui.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import ui.base.Base;
import utilities.MyTestUtils;

public class FirstWebTest extends Base {

	private static String url = "https://www.google.com/";
	private static String searchTerm = "men's shoes";

	@Test
	void runTest() {
		System.out.println(driver.toString().replaceAll("[(].*[)]", ""));
		System.out.println(driver.getWindowHandle());
		MyTestUtils.pause(1);
	}

	@Test
	void demoTest() {
		// better than driver.get(url) because it stores browser history
		driver.navigate().to(url);
		driver.findElement(By.name("q")).sendKeys(searchTerm + Keys.ENTER);
		MyTestUtils.pause(2);
	}

	public static String getURL() {
		return url;
	}

	public static String getSearchTerm() {
		return searchTerm;
	}

}
