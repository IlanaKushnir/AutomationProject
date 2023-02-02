package pageObjects;

import org.openqa.selenium.WebDriver;

public class FacebookPage extends BasePage{

	public FacebookPage(WebDriver driver) {
		super(driver);
	}
	public boolean isItFacebookPage() {
		waitMe(1000);
		refresh();
		waitMe(1000);
		if (getUrl().equalsIgnoreCase("https://www.facebook.com/saucelabs")) {
			return true;
		} else {
			return false;
		}
	}
}
