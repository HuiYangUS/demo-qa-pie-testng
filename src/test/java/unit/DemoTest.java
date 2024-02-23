package unit;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.MyPrinter;

public class DemoTest extends Base {

	@Test(groups = { "demo" }, alwaysRun = true)
	void runTest() {
		MyPrinter.printLine("This is a demo test.");
	}

	@Test(enabled = false)
	void tryTest() {
		MyPrinter.printLine("Try to run a test.");
	}

	@Test
	void badTest() {
		Assert.fail("This is a bad test.");
	}

	@Test(dependsOnMethods = { "badTest" })
	void tryAgainTest() {
		MyPrinter.printLine("Can I try?");
	}

	@Test(dependsOnMethods = { "badTest" }, alwaysRun = true)
	void tryMoreTest() {
		MyPrinter.printLine("Please try again!");
	}

	@Test(dependsOnGroups = { "demo" })
	void tryDemoTest() {
		MyPrinter.printLine("Try to run a demo test.");
	}

}
