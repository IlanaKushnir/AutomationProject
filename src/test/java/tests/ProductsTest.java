package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utils.Utils;

public class ProductsTest extends BaseTest {

	@Test
	public void T1_Login() {
		LoginPage li = new LoginPage(driver);
		li.toLogin(Utils.readProperty("username"), Utils.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertTrue(pp.isProductsPage());
	}

	@Test
	public void T2_addToChartBackpack() {
		ProductsPage pp = new ProductsPage(driver);
		int before = pp.getChartTexs();
		pp.addToChartProdoct("Sauce Labs Backpack");
		int actual = pp.getChartTexs();
		Assert.assertEquals(actual, before + 1);
	}

	@Test
	public void T3_addToChartBikeLight() {
		ProductsPage pp = new ProductsPage(driver);
		int before = pp.getChartTexs();
		pp.addToChartProdoct("Sauce Labs Bike Light");
		int actual = pp.getChartTexs();
		Assert.assertEquals(actual, before + 1);
	}

	@Test
	public void T4_addToChartTShirt() {
		ProductsPage pp = new ProductsPage(driver);
		int before = pp.getChartTexs();
		pp.addToChartProdoct("Sauce Labs Bolt T-Shirt");
		int actual = pp.getChartTexs();
		Assert.assertEquals(actual, before + 1);
	}

	@Test
	public void T5_addToChartJacket() {
		ProductsPage pp = new ProductsPage(driver);
		int before = pp.getChartTexs();
		pp.addToChartProdoct("Sauce Labs Fleece Jacket");
		int actual = pp.getChartTexs();
		Assert.assertEquals(actual, before + 1);
	}

	@Test
	public void T6_addToChartOnesie() {
		ProductsPage pp = new ProductsPage(driver);
		int before = pp.getChartTexs();
		pp.addToChartProdoct("Sauce Labs Onesie");
		int actual = pp.getChartTexs();
		Assert.assertEquals(actual, before + 1);
	}

	@Test
	public void T7_addToChartRedTShirt() {
		ProductsPage pp = new ProductsPage(driver);
		int before = pp.getChartTexs();
		pp.addToChartProdoct("Test.allTheThings() T-Shirt (Red)");
		int actual = pp.getChartTexs();
		Assert.assertEquals(actual, before + 1);
	}

}
