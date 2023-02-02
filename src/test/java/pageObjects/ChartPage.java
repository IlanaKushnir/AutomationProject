package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChartPage extends MenuPage {

	public ChartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#remove-sauce-labs-bolt-t-shirt")
	private WebElement removeBtn;
	@FindBy(css = "#checkout")
	private WebElement checkoutBtn;
	@FindBy(css = "#continue-shopping")
	private WebElement continueShoppingBtn;
	@FindBy(css = ".cart_quantity")
	private WebElement itemInChartQuantity;

	public void removeFromChart() {
		click(removeBtn);
	}

	public void goToCheckout() {
		click(checkoutBtn);
	}

	public void goToProductsPage() {
		click(continueShoppingBtn);
	}

	public boolean isItChartPage() {
		if (itemInChartQuantity.isDisplayed()) {
			return true;
		}
		return false;
	}

	public Integer getNumItemsInChart() {
		int num = 0;
		try {
			String s = getText(itemInChartQuantity);
			num = Integer.parseInt(s);
		} catch (Exception e) {
		}
		return num;
	}

}
