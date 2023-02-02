package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompleteCheckoutPage extends MenuPage {

	public CompleteCheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#back-to-products")
	private WebElement backHomeBtn;
	@FindBy(css = ".complete-text")
	private WebElement summaryMsg;
	@FindBy(css = ".title")
	private WebElement summaryTitle;	

	public void goToProdectsPage() {
		click(backHomeBtn);
	}

	public void GetSummaryMsg() {
		getText(summaryMsg);
	}

	public void GetSummaryMsgTitle() {
		getText(summaryTitle);
	}
	
	public boolean isItCompleteCheckoutPage() {
		if (getText(summaryTitle).equals("CHECKOUT: COMPLETE!"))  {
			return true;
		}
		return false;
	}
}
