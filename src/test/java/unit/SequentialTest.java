package unit;

import org.testng.annotations.Test;

import utilities.MyPrinter;

public class SequentialTest extends Base {

	@Test
	void run1stTest() {
		MyPrinter.printLine("This the 1st demo test.");
	}

	@Test
	void run2ndTest() {
		MyPrinter.printLine("This the 2nd demo test.");
	}

	@Test
	void run3rdTest() {
		MyPrinter.printLine("This the 3rd demo test.");
	}

}
