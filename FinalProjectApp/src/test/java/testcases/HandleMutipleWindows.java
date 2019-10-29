package testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utilities.Base;

public class HandleMutipleWindows extends Base {
	WebDriver driver;

	@Test(priority = 1)
	public void openApplication() {
		driver = initializeDriver();
		driver.get("https://accounts.google.com/signin");
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void createWindows() throws Exception {
		driver.findElement(By.linkText("Help")).sendKeys(Keys.CONTROL, Keys.ENTER);
		driver.findElement(By.linkText("Privacy")).sendKeys(Keys.CONTROL, Keys.ENTER);
		driver.findElement(By.linkText("Terms")).sendKeys(Keys.CONTROL, Keys.ENTER);
	}

	@Test(priority = 3)
	public void handleWindowsById() throws Exception {
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> id = ids.iterator();
		String parentID = id.next();
		String firstChildID = id.next();
		String secondChildID = id.next();
		String thirdChildID = id.next();
		System.out.println("Parent Title : " + driver.getTitle());
		driver.switchTo().window(firstChildID);
		System.out.println("First Title : " + driver.getTitle());
		driver.switchTo().window(secondChildID);
		System.out.println("Second Title : " + driver.getTitle());
		driver.switchTo().window(thirdChildID);
		System.out.println("Third Title : " + driver.getTitle());
		driver.switchTo().window(parentID);
	}

	@Test(priority = 4)
	public void tearDown() throws Exception {
		driver.quit();
	}
}
