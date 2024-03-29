package utilities;

import static org.testng.Assert.*;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private static final String DIR_PATH = "src/test/resources/configs/";

	public static String getValue(String fileName, String key) {
		String filePath = DIR_PATH + fileName + ".properties";
		Properties p = load(filePath);
		return p.containsKey(key) ? (p.getProperty(key).isBlank() ? null : p.getProperty(key)) : null;
	}

	private static Properties load(String filePath) {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(filePath));
		} catch (Exception e) {
			assertTrue(false, "No config file is discovered.");
		}
		return p;
	}

}
