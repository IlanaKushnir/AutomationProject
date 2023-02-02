package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Utils;

public class BaseTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get(Utils.readProperty("url"));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void waitMe(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
