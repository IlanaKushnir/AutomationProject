package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AboutSaucelabsPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utils.Utils;

public class MenuTest extends BaseTest {

	@Test(description = "Test susses login")
	public void T1_Login() {
		LoginPage li = new LoginPage(driver);
		li.toLogin(Utils.readProperty("username"), Utils.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertTrue(pp.isProductsPage());
	}

	@Test(description = "Test All Items")
	public void T2_() {
		ProductsPage pp = new ProductsPage(driver);
		pp.chooseAction("All Items");
		waitMe(2000);
		Assert.assertTrue(pp.isProductsPage());
	}

	@Test(description = "Test about sidebar")
	public void T3_() {
		ProductsPage pp = new ProductsPage(driver);
		pp.chooseAction("About");
		AboutSaucelabsPage ab = new AboutSaucelabsPage(driver);
		Assert.assertTrue(ab.isItAbautSaucelabsPage());
	}

	@Test(description = "Test Reset App State")
	public void T4_() {
		ProductsPage pp = new ProductsPage(driver);
		int before = pp.getChartTexs();
		pp.addToChartProdoct("Sauce Labs Fleece Jacket");
		int actual = pp.getChartTexs();
		Assert.assertEquals(actual, before + 1);
		pp.chooseAction("Reset App State");
		int actual2 = pp.getChartTexs();
		Assert.assertEquals(actual2, before);
	}

	@Test(description = "Test Logout")
	public void T5_() {
		ProductsPage pp = new ProductsPage(driver);
		pp.chooseAction("Logout");
		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.isItLoginPage());
	}
}
