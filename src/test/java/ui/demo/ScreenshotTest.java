package ui.demo;

import java.io.File;

import org.openqa.selenium.OutputType;

import org.testng.annotations.Test;

import ui.base.DriverFactoryBase;
import utilities.MyTestUtils;

public class ScreenshotTest extends DriverFactoryBase {

	@Test
	void runTest() {
		driver.navigate().to("https://www.saucedemo.com/");
		File imgSrcFile = ts.getScreenshotAs(OutputType.FILE);
		File imgDestFile = new File("target/screenshots/demo/index.png");
		MyTestUtils.copyFile(imgSrcFile, imgDestFile);
	}

}
