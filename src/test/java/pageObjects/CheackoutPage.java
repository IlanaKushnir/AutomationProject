package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheackoutPage extends MenuPage {

	public CheackoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#continue")
	private WebElement continueBtn;
	@FindBy(css = "#cancel")
	private WebElement cancelBtn;
	@FindBy(css = "#first-name")
	private WebElement firstNameField;
	@FindBy(css = "#last-name")
	private WebElement lastNameField;
	@FindBy(css = "#postal-code")
	private WebElement postalCodeField;
	@FindBy(css = "[data-test='error']")
	private WebElement errorMsg;

	public void continueCheackoutProcces() {
		click(continueBtn);
	}

	public void cancelCheackoutProcces() {
		click(cancelBtn);
	}

	public boolean isCheackoutPage() {
		if (firstNameField.isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean isThereErrorMsg() {
		if (errorMsg.isDisplayed()) {
			return true;
		}
		return false;
	}

	public String getErrorMsg() {
		return getText(errorMsg);
	}

	public void FillPersonalInfo(String firstName, String lastName, String postalCode) {
		refresh();
		fillText(firstNameField, firstName);
		fillText(lastNameField, lastName);
		fillText(postalCodeField, postalCode);
		click(continueBtn);
	}
}
