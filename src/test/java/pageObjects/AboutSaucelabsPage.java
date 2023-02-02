package pageObjects;

import org.openqa.selenium.WebDriver;

public class AboutSaucelabsPage extends BasePage {

	public AboutSaucelabsPage(WebDriver driver) {
		super(driver);
	}

	public boolean isItAbautSaucelabsPage() {
		if (getTitle().equalsIgnoreCase("Swag Labs")) {
			return true;
		} else {
			return false;
		}
	}
}
