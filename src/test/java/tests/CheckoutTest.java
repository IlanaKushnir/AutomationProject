package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ChartPage;
import pageObjects.CheackoutPage;
import pageObjects.CheckoutOverwiewPage;
import pageObjects.ItemPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utils.Utils;

public class CheckoutTest extends BaseTest {

	@Test(description = "Test susses login")
	public void T01_Login() {
		LoginPage li = new LoginPage(driver);
		li.toLogin(Utils.readProperty("username"), Utils.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertTrue(pp.isProductsPage());
	}

	@Test
	public void T02_addItemAndGoToChart() {
		ItemPage it = new ItemPage(driver);
		int before = it.getChartTexs();
		it.AddToCart();
		int after = it.getChartTexs();
		Assert.assertEquals(after, before + 1);
		it.goToChart();
		ChartPage cp = new ChartPage(driver);
		Assert.assertTrue(cp.isItChartPage());
		cp.goToCheckout();
		CheackoutPage cop = new CheackoutPage(driver);
		Assert.assertTrue(cop.isCheackoutPage());
	}

	@Test(dataProvider = "getData")
	public void T03_CheckoutWithMissingData(String firstName, String lastName, String postalCode) {
		CheackoutPage cop = new CheackoutPage(driver);
		cop.FillPersonalInfo(firstName, lastName, postalCode);
		Assert.assertTrue(cop.isThereErrorMsg());
	}

	@Test
	public void T04_CheckoutWithInvalidFirstName() {
		CheackoutPage cop = new CheackoutPage(driver);
		cop.FillPersonalInfo("1", "Kushnir", "1234567");
		CheckoutOverwiewPage co = new CheckoutOverwiewPage(driver);
		co.navigateBack();
		Assert.assertFalse(cop.isCheackoutPage());
	}

	@Test
	public void T05_CheckoutWithInvalidLastName() {
		CheackoutPage cop = new CheackoutPage(driver);
		cop.FillPersonalInfo("Ilana", "1", "1234567");
		CheckoutOverwiewPage co = new CheckoutOverwiewPage(driver);
		co.navigateBack();
		Assert.assertFalse(cop.isCheackoutPage());
	}

	@Test
	public void T06_CheckoutWithInvalidZipcode() {
		CheackoutPage cop = new CheackoutPage(driver);
		cop.FillPersonalInfo("Ilana", "Kushnir", "abc");
		CheckoutOverwiewPage co = new CheckoutOverwiewPage(driver);
		Assert.assertFalse(co.isItCheckoutOverwiewPage());
	}

	@DataProvider
	public Object[][] getData() {
		String[][] data = { { "", "Kushnir", "1234567" }, { "Ilana", "", "1234567" }, { "Ilana", "Kushnir", "" }, };
		return data;
	}
}
