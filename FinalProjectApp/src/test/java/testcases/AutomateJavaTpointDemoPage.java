package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Base;

public class AutomateJavaTpointDemoPage extends Base {

	WebDriver driver;

	@BeforeClass
	public void tearUp() {
		driver = initializeDriver();
	}

	@Test(priority = 1)
	public void openApplication() {
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void automateForm() {
		driver.findElement(By.linkText("This is a link")).sendKeys(Keys.CONTROL, Keys.ENTER);
		driver.findElement(By.name("firstName")).sendKeys("Aditya");
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		driver.findElement(By.id("male")).click();
		driver.findElement(By.xpath("//input[@value='Automation']")).click();
		Select course = new Select(driver.findElement(By.xpath("//select[@id='testingDropdown']")));
		course.selectByVisibleText("Automation Testing");
		WebElement a = driver.findElement(By.id("dblClkBtn"));
		Actions act = new Actions(driver);
		act.doubleClick(a).build().perform();
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		alert.accept();
		System.out.println("message1 : " + message);
		driver.findElement(By.xpath("//button[contains(text(),'Generate Alert Box')]")).click();
		Alert alert2 = driver.switchTo().alert();
		String message2 = alert2.getText();
		alert2.accept();
		System.out.println("Message 2 : " + message2);
		driver.findElement(By.xpath("//button[contains(text(),'Generate Confirm Box')]")).click();
		Alert alert3 = driver.switchTo().alert();
		alert3.dismiss();
		Actions act2 = new Actions(driver);
		act2.dragAndDrop(driver.findElement(By.xpath("//img[@id='sourceImage']")),
				driver.findElement(By.xpath("//div[@id='targetDiv']"))).build().perform();

	}
}
