package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends MenuPage {

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".title")
	private WebElement titleLabel;

	public void addToChartProdoct(String name) {
		List<WebElement> itemArea = driver.findElements(By.cssSelector(".inventory_item"));
		for (WebElement el : itemArea) {
			WebElement title = el.findElement(By.cssSelector(".inventory_item_name"));
			if (title.getText().equalsIgnoreCase(name)) {
				WebElement addToChartBtn = el.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
				click(addToChartBtn);
				break;
			}
		}
	}

	public void chooseProdoct(String name) {
		List<WebElement> itemArea = driver.findElements(By.cssSelector(".inventory_item"));
		for (WebElement el : itemArea) {
			WebElement title = el.findElement(By.cssSelector(".inventory_item_name"));
			if (title.getText().equalsIgnoreCase(name)) {
				WebElement itemBtn = el.findElement(By.cssSelector(".inventory_item_name"));
				click(itemBtn);
				break;
			}
		}
	}

	public boolean isProductsPage() {
		if (getText(titleLabel).equals("PRODUCTS")) {
			return true;
		}
		return false;
	}

}
