package unit;

import org.testng.annotations.Test;

import utilities.DoString;

public class MainUtilsTest {

	@Test
	void runTest() {
		String actual = DoString.findTitleCase("good morning!");
		System.out.println("Result: " + actual);
	}

	@Test
	void titleTest() {
		String actual = DoString.getProperTitle("good-morning-to-you.");
		System.out.println("Result: " + actual);
	}

}
