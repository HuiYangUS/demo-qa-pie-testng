package ui.demo;

import org.testng.annotations.Test;

import ui.base.DriverFactoryBase;
import utilities.MyTestUtils;

public class ParallelWebTest extends DriverFactoryBase {

	private static String url = "https://www.lambdatest.com/selenium-playground/";

	@Test
	void runTest() {
		System.out.println("Current thread ID: " + Thread.currentThread().getId());
		System.out.println(driver.getWindowHandle());
		MyTestUtils.pause(1);
	}

	@Test
	void demoTest() {
		System.out.println("Current thread ID: " + Thread.currentThread().getId());
		driver.navigate().to(url);
		MyTestUtils.pause(2);
	}

}
