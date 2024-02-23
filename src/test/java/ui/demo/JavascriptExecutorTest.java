package ui.demo;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import ui.base.DriverFactoryBase;
import utilities.MyTestUtils;

public class JavascriptExecutorTest extends DriverFactoryBase {

	@Test
	void runTest() {
		driver.navigate().to(FirstWebTest.getURL());
		driver.findElement(By.name("q")).sendKeys(FirstWebTest.getSearchTerm());
		By searchButtonLocator = By.xpath("//input[@type='submit'][@role='button'][@value='Google Search']");
		je.executeScript("arguments[0].click();", driver.findElement(searchButtonLocator));
		System.out.println("Page title: " + driver.getTitle());
		MyTestUtils.pause(2);
	}

}
