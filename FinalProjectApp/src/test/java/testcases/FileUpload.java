package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.Base;

public class FileUpload extends Base {
	WebDriver driver;

	@Test(priority = 1)
	public void openApplication() {
		driver = initializeDriver();
		driver.get("http://www.tinyupload.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void uploadFile() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@name='uploaded_file']"))))
				.click();
	}
}
