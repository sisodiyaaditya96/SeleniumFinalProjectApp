package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utilities.Base;

public class GoogleScreenShotUsingSelenium extends Base {
	WebDriver driver;

	@Test(priority = 1)
	public void openApplication() {
		driver = initializeDriver();
		driver.get("https://www.google.co.in/?gws_rd=ssl");
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void takeScreenShot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\work\\" + System.currentTimeMillis() + ".png"));
	}
}
