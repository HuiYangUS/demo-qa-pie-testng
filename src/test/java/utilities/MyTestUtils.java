package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class MyTestUtils {

	public static void pause(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getCurrentDir() {
		return System.getProperty("user.dir").replace("\\", "/");
	}

	public static String getOS() {
		return System.getProperty("os.name").toLowerCase();
	}

	public static boolean isWindows() {
		return getOS().contains("windows");
	}

	public static void copyFile(File imgSrcFile, File imgDestFile) {
		try {
			FileUtils.copyFile(imgSrcFile, imgDestFile);
		} catch (IOException e) {
			System.out.println("Failed to copy image file.");
			e.printStackTrace();
		}
	}

}
