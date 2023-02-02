package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#user-name")
	private WebElement username;
	@FindBy(css = "#password")
	private WebElement password;
	@FindBy(css = "#login-button")
	private WebElement loginBtn;
	@FindBy(css = ".error-message-container.error")
	private WebElement errorMsg;

	public void toLogin(String userName, String passWord) {
		refresh();
		fillText(username, userName);
		fillText(password, passWord);
		click(loginBtn);
	}

	public String getErrorMsg() {
		return getText(errorMsg);
	}

	public boolean isItLoginPage() {
		if (loginBtn.isDisplayed()) {
			return true;
		}
		return false;
	}

}
