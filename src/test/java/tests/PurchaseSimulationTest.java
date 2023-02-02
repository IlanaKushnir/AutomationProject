package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ChartPage;
import pageObjects.CheackoutPage;
import pageObjects.CheckoutOverwiewPage;
import pageObjects.CompleteCheckoutPage;
import pageObjects.ItemPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utils.Utils;

public class PurchaseSimulationTest extends BaseTest {

	@Test(description = "Test susses login")
	public void T1_Login() {
		LoginPage li = new LoginPage(driver);
		li.toLogin(Utils.readProperty("username"), Utils.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertTrue(pp.isProductsPage());
	}

	@Test
	public void T2_goToItem() {
		ProductsPage pp = new ProductsPage(driver);
		pp.chooseProdoct("Sauce Labs Backpack");
		ItemPage it = new ItemPage(driver);
		Assert.assertTrue(it.isItItemPage("Sauce Labs Backpack"));
	}

	@Test
	public void T3_addItemToChart() {
		ItemPage it = new ItemPage(driver);
		int before = it.getChartTexs();
		it.AddToCart();
		int after = it.getChartTexs();
		Assert.assertEquals(after, before + 1);
	}

	@Test
	public void T4_goToChartPage() {
		ItemPage it = new ItemPage(driver);
		it.goToChart();
		ChartPage cp = new ChartPage(driver);
		Assert.assertTrue(cp.isItChartPage());
	}

	@Test
	public void T5_numOfItemsInChart() {
		ChartPage cp = new ChartPage(driver);
		int expected = 1;
		int actual = cp.getNumItemsInChart();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void T6_goToCheackoutPage() {
		ChartPage cp = new ChartPage(driver);
		cp.goToCheckout();
		CheackoutPage cop = new CheackoutPage(driver);
		Assert.assertTrue(cop.isCheackoutPage());
	}

	@Test
	public void T7_goToCheckoutOverwiewPage() {
		CheackoutPage cop = new CheackoutPage(driver);
		cop.FillPersonalInfo("Ilana", "Kushnir", "1234567");
		CheckoutOverwiewPage co = new CheckoutOverwiewPage(driver);
		Assert.assertTrue(co.isItCheckoutOverwiewPage());
	}

	@Test
	public void T8_goToCompleteCheckoutPage() {
		CheckoutOverwiewPage co = new CheckoutOverwiewPage(driver);
		co.finishCheackOut();
		CompleteCheckoutPage cc = new CompleteCheckoutPage(driver);
		Assert.assertTrue(cc.isItCompleteCheckoutPage());
	}
}
