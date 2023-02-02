package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedinPage extends BasePage {

	public LinkedinPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".nav")
	private WebElement linkedinLogo;
	@FindBy(css = ".contextual-sign-in-modal__modal-dismiss-icon")
	private WebElement closeWindoBtn;

	public boolean isItLinkedinPage() {
		waitMe(1000);
		refresh();
		waitMe(1000);
		return linkedinLogo.isDisplayed();
	}
}
