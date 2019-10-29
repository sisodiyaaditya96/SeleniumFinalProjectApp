package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExpediaAutomation {
	WebDriver driver;

	@BeforeClass
	public void tearUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("disable-infobars");
		driver = new ChromeDriver(option);
	}

	@Test(priority = 1)
	public void openApplication() {
		driver.get("https://www.expedia.co.in/");
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void doEnquiry() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Car Hire')]")).click();
		driver.findElement(By.xpath("//input[@id='car-pickup-hp-car']")).sendKeys("indore");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='car-pickup-hp-car']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='car-dropoff-hp-car']")).sendKeys("mumbai");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='car-dropoff-hp-car']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}

	@Test(priority = 3)
	public void selectDate() {
		driver.findElement(By.xpath("//input[@id='car-pickup-date-hp-car']")).click();
		String title = driver.findElement(By.xpath("//div[@class='datepicker-cal']/div[2]/table/caption")).getText();
		while (!title.equalsIgnoreCase("nov 2019")) {
			driver.findElement(By.xpath("//div[@class='datepicker-cal']/button[2]")).click();
			title = driver.findElement(By.xpath("//div[@class='datepicker-cal']/div[2]/table/caption")).getText();
		}
		List<WebElement> dateList = driver.findElements(By.xpath(
				"//div[@class='datepicker-cal']/div[2]/table/tbody/tr/td[@class='datepicker-day-number notranslate']/button"));
		for (int i = 0; i < dateList.size(); i++) {
			String date = dateList.get(i).getText();
			if (date.contains("2")) {
				dateList.get(i).click();
				break;
			}
		}
		Select pickUpTime = new Select(driver.findElement(By.xpath("//select[@id='car-pickup-time-hp-car']")));
		pickUpTime.selectByVisibleText("01:00");
		driver.findElement(By.xpath("//input[@id='car-dropoff-date-hp-car']")).click();
		List<WebElement> dateList2 = driver.findElements(By.xpath(
				"//div[@class='datepicker-cal']/div[2]/table/tbody/tr/td[@class='datepicker-day-number notranslate']/button"));
		for (int i = 0; i < dateList2.size(); i++) {
			String date = dateList2.get(i).getText();
			if (date.contains("3")) {
				dateList2.get(i).click();
				break;
			}
		}
		Select dropTime = new Select(driver.findElement(By.xpath("//select[@id='car-dropoff-time-hp-car']")));
		dropTime.selectByVisibleText("02:00");
		Select carDriverAge = new Select(driver.findElement(By.xpath("//select[@id='car-age-of-driver-hp-car']")));
		carDriverAge.selectByVisibleText("25");
		driver.findElement(By.id("gcw-submit-car")).click();
	}
}
