package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utils.Utils;

public class LoginTest extends BaseTest {

	@Test
	public void T1_invalidLoginWithoutPassword() {
		LoginPage li = new LoginPage(driver);
		li.toLogin(Utils.readProperty("username"), "");
		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.getErrorMsg().equalsIgnoreCase("Epic sadface: Password is required"));
	}

	public void T2_invalidLoginWithoutUsername() {
		LoginPage li = new LoginPage(driver);
		li.toLogin("", Utils.readProperty("password"));
		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.getErrorMsg().equalsIgnoreCase("Epic sadface: Username is required"));
	}

	@Test(dataProvider = "getData")
	public void T3_invalidLogin(String user, String password) {
		LoginPage li = new LoginPage(driver);
		li.toLogin(user, password);
		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.getErrorMsg()
				.equalsIgnoreCase("Epic sadface: Username and password do not match any user in this service"));
	}

	@Test
	public void T4_validLogin() {
		LoginPage li = new LoginPage(driver);
		li.toLogin(Utils.readProperty("username"), Utils.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertTrue(pp.isProductsPage());
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "standard_user", "123#Abcd" }, { "standard_user", "123" },
				{ "Ariel123", "secret_sauce" }, { "Michael", "secret_sauce" }, };
		return myData;
	}

}
