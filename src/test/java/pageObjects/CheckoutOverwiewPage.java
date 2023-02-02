package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverwiewPage extends MenuPage {

	public CheckoutOverwiewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#finish")
	private WebElement finishBtn;
	@FindBy(css = "#cancel")
	private WebElement cancelBtn;
	@FindBy(css = ".title")
	private WebElement title;

	public void finishCheackOut() {
		click(finishBtn);
	}

	public void cancelCheackOut() {
		click(cancelBtn);
	}

	public boolean isItCheckoutOverwiewPage() {
		if (finishBtn.isDisplayed()) {
			return true;
		}
		return false;
	}

}
