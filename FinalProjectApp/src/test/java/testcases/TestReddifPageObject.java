package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectrepositoy.RediffLoginPage;
import utilities.Base;

public class TestReddifPageObject extends Base {
	WebDriver driver;
	RediffLoginPage login;

	@BeforeClass
	public void tearUp() {
		driver = initializeDriver();
	}

	@Test
	public void openApplication() {
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
	}

	@Test(dependsOnMethods = "openApplication")
	public void doLogin() {
		login = new RediffLoginPage(driver);
		login.typeUserName().sendKeys("username");
		login.typePassword().sendKeys("pwd1234");
		login.doLogin().click();
	}
}
