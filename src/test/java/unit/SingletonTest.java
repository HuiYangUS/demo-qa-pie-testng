package unit;

import org.testng.annotations.Test;

import utilities.Cat;
import utilities.DataManager;
import utilities.MyPrinter;

public class SingletonTest extends Base {

	@SuppressWarnings("unused")
	@Test
	void runTest() {
		MyPrinter.printLine("Count: " + DataManager.getCount());
		DataManager dm1 = DataManager.getInstance();
		MyPrinter.printLine("Count: " + DataManager.getCount());
		DataManager dm2 = DataManager.getInstance();
		MyPrinter.printLine("Count: " + DataManager.getCount());
	}

	@SuppressWarnings("unused")
	@Test
	void runMultipleTest() {
		MyPrinter.printLine("Count: " + Cat.getCount());
		Cat cat1 = new Cat();
		MyPrinter.printLine("Count: " + Cat.getCount());
		Cat cat2 = new Cat();
		MyPrinter.printLine("Count: " + Cat.getCount());
	}

}
