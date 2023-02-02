package pageObjects;

import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver;
	String mainWindow;
	JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}

	public void click(WebElement el) {
		js.executeScript("arguments[0].setAttribute('style', 'background-color:cyan; border: 1px solid blue;');", el);
		waitMe(500);
		el.click();
	}

	public void fillText(WebElement el, String text) {
		el.clear();
		js.executeScript("arguments[0].setAttribute('style', 'background-color:yellow	; border: 1px solid blue;');",
				el);
		waitMe(500);
		el.sendKeys(text);
	}

	public String getText(WebElement el) {
		js.executeScript("arguments[0].setAttribute('style', 'background-color:orange	; border: 1px solid blue;');",
				el);
		waitMe(200);
		return el.getText();
	}

	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void refresh() {
		driver.navigate().refresh();
	}
	public String getTitle() {
		return driver.getTitle();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void waitMe(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void moveToNewWindow() {
		mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			driver.switchTo().window(win);
		}
	}

	public void moveBackToMainWindo() {
		driver.switchTo().window(mainWindow);
	}
}
