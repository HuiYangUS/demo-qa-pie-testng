package unit;

import org.testng.annotations.Test;

import utilities.MyPrinter;

public class GroupsTest extends Base {

	@Test(groups = "cat")
	void catTest() {
		MyPrinter.printLine("This is a cat.");
	}

	@Test(groups = { "dog", "pet" })
	void dogTest() {
		MyPrinter.printLine("This is a dog.");
		MyPrinter.printLine("I want a dog as my pet.");
	}

}
