package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Base;

public class GmailLoginAutomation extends Base {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void tearUp() {
		driver = initializeDriver();
	}

	@Test(priority = 1)
	public void launchApplication() {
		driver.get("https://accounts.google.com/signin");
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void doLogin() {
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sisodiyaaditya95@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		wait = new WebDriverWait(driver, 10);
		WebElement passowrdField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
		passowrdField.sendKeys("Aadi@1996");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	}

	@Test(priority = 3)
	public void doLogout() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='gb_xa gbii']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign out')]"))).click();
	}
}
