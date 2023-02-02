package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends MenuPage {

	public ItemPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".back-to-products")
	private WebElement BackToProductsBtn;
	@FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
	private WebElement addToCartBtn;
	@FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
	private WebElement remuveFromCartBtn;
	@FindBy(css = ".inventory_details_name.large_size")
	private WebElement title;

	public void goBackToProducts() {
		click(BackToProductsBtn);
	}

	public void AddToCart() {
		click(addToCartBtn);
	}

	public void remuveFromCart() {
		click(remuveFromCartBtn);
	}

	public boolean isItItemPage(String name) {
		if (getText(title).equals(name)) {
			return true;
		}
		return false;
	}
}