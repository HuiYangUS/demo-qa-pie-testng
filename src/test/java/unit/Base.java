package unit;

import org.testng.annotations.AfterMethod;

public class Base {

	@AfterMethod
	void afterTest() {
		System.out.println();
	}

}
