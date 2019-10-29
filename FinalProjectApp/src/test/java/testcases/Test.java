package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.Base;

public class Test extends Base {
	public static void main(String args[]) {
		WebDriver driver;
		driver = initializeDriver();
		driver.get("http://www.tinyupload.com/");
		driver.findElement(By.xpath("//input[@name='uploaded_file']")).click();
	}
}
