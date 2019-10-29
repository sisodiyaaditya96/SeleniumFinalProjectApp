package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Base;

public class NaukriPortalAutomation extends Base {
	WebDriver driver;

	@BeforeClass
	public void tearUp() {
		driver = initializeDriver();
	}

	@Test(priority = 1)
	public void launchApplication() {
		driver.get("https://www.naukri.com/nlogin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void doLogin() {
		driver.findElement(By.id("usernameField")).sendKeys("sisodiyaaditya95@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("Aadi@1996");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}

	@Test(priority = 3)
	public void validateLogin() {
		String actualUserName = driver.findElement(By.xpath("//div[@class='user-name roboto-bold-text']")).getText();
		String expectedUserName = "Aditya Sisodiya";
		Assert.assertEquals(actualUserName, expectedUserName);
	}

	@Test(priority = 4)
	public void doLogout() throws InterruptedException {
		//Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'My Naukri')]"))).build().perform();
		driver.findElement(By.linkText("Logout")).click();
	}
}
