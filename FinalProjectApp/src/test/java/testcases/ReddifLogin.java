package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Base;

public class ReddifLogin extends Base {
	WebDriver driver;

	@BeforeClass
	public void tearUp() {
		driver = initializeDriver();
	}

	@Test(priority = 1)
	public void openApplication() {
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void doLogin() {
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("sisodiyaaditya95@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pwd123");
		Boolean status = driver.findElement(By.xpath("//input[@id='remember']")).isSelected();
		if (status != true) {
			driver.findElement(By.xpath("//input[@id='remember']")).click();
		}
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		System.out.println("loggin in process.............");
	}

	@Test(priority = 3)
	public void validateLogin() {
		String currentURL = driver.getCurrentUrl();
		String baseURL = "https://mail.rediff.com/cgi-bin/login.cgi";
		Assert.assertEquals(currentURL, baseURL);
		String errorMessage = driver.findElement(By.xpath("//div[@class='login-form']/div[1]")).getText();
		System.out.println("error message : " + errorMessage);
	}

}
