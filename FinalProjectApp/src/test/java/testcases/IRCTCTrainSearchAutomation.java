package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Base;

public class IRCTCTrainSearchAutomation extends Base {
	WebDriver driver;

	@BeforeClass
	public void tearUp() {
		driver = initializeDriver();
	}

	@Test(priority = 1)
	public void openApplication() {
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void makeEnquiry() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("RTM", Keys.ENTER);
		// Thread.sleep(500);
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Pune", Keys.ENTER);
		driver.findElement(By.xpath(
				"//button[@class='ui-datepicker-trigger ui-calendar-button ng-tns-c14-6 ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ng-star-inserted']"))
				.click();
	}
}
