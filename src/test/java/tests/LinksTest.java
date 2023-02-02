package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.FacebookPage;
import pageObjects.LinkedinPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.TwitterPage;
import utils.Utils;

public class LinksTest extends BaseTest {

	@Test(description = "Test susses login")
	public void T1_Login() {
		LoginPage li = new LoginPage(driver);
		li.toLogin(Utils.readProperty("username"), Utils.readProperty("password"));
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertTrue(pp.isProductsPage());
	}

	@Test
	public void T2_checkTwitter() {
		ProductsPage pp = new ProductsPage(driver);
		pp.goToSocialMedia("twitter");
		TwitterPage tp = new TwitterPage(driver);
		tp.moveToNewWindow();
		Assert.assertTrue(tp.isItTwitterPage());
		tp.moveBackToMainWindo();
		waitMe(5000);
	}

	@Test
	public void T3_checkfacebook() {
		ProductsPage pp = new ProductsPage(driver);
		pp.goToSocialMedia("facebook");
		FacebookPage fb = new FacebookPage(driver);
		fb.moveToNewWindow();
		Assert.assertTrue(fb.isItFacebookPage());
		fb.moveBackToMainWindo();
		waitMe(10000);
	}

	@Test
	public void T4_checklinkedin() {
		ProductsPage pp = new ProductsPage(driver);
		pp.goToSocialMedia("linkedin");
		LinkedinPage lp = new LinkedinPage(driver);
		lp.moveToNewWindow();
		Assert.assertTrue(lp.isItLinkedinPage());
		lp.moveBackToMainWindo();
	}
}
