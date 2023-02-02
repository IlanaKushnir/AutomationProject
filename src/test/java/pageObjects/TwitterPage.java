package pageObjects;

import org.openqa.selenium.WebDriver;

public class TwitterPage extends BasePage {

	public TwitterPage(WebDriver driver) {
		super(driver);
	}

	public boolean isItTwitterPage() {
		if (getUrl().equalsIgnoreCase("https://twitter.com/saucelabs")) {
			return true;
		} else {
			return false;
		}
	}

}
