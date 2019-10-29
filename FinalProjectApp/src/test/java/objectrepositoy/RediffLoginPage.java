package objectrepositoy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPage {
	public RediffLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "login")
	WebElement username;
	@FindBy(name = "passwd")
	WebElement password;
	@FindBy(name = "proceed")
	WebElement submit;

	public WebElement typeUserName() {
		return username;
	}

	public WebElement typePassword() {
		return password;
	}

	public WebElement doLogin() {
		return submit;
	}
}
