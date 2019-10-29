package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	public static WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-disable-notifications");
		option.addArguments("-disable-infobars");
		option.setAcceptInsecureCerts(true);
		return new ChromeDriver(option);
	}
}
