package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class MenuPage extends BasePage {

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#react-burger-menu-btn")
	private WebElement HamburgerBtn;
	// Links social media
	@FindBy(css = ".social_twitter")
	private WebElement twitterBtn;
	@FindBy(css = ".social_facebook")
	private WebElement facebookBtn;
	@FindBy(css = ".social_linkedin")
	private WebElement linkedinBtn;
	// HamburgerBtn links
	@FindBy(css = ".shopping_cart_link")
	private WebElement chatrBtn;
	@FindBy(css = "#inventory_sidebar_link")
	private WebElement allItemsBtn;
	@FindBy(css = "#about_sidebar_link")
	private WebElement aboutBtn;
	@FindBy(css = "#logout_sidebar_link")
	private WebElement logoutBtn;
	@FindBy(css = "#reset_sidebar_link")
	private WebElement resetBtn;
	@FindBy(css = "#react-burger-cross-btn")
	private WebElement closeBurgerMenuBtn;

	public Integer getChartTexs() {
		int num = 0;
		try {
			String s = getText(chatrBtn);
			num = Integer.parseInt(s);
		} catch (Exception e) {
		}
		return num;
	}

	public void goToChart() {
		click(chatrBtn);
	}

	public void goToSocialMedia(String SocialMedia) {
		if (SocialMedia == "twitter") {
			click(twitterBtn);
		} else {
			if (SocialMedia == "facebook") {
				click(facebookBtn);
			} else {
				if (SocialMedia == "linkedin") {
					click(linkedinBtn);
				}
			}
		}
	}

	public void chooseAction(String action) {
		click(HamburgerBtn);
		waitMe(5000);
		switch (action) {

		case "All Items":
			click(allItemsBtn);
			click(closeBurgerMenuBtn);
			break;

		case "About":
			click(aboutBtn);
			navigateBack();
			click(closeBurgerMenuBtn);
			break;

		case "Reset App State":
			click(resetBtn);
			click(closeBurgerMenuBtn);
			break;

		case "Logout":
			click(logoutBtn);
			break;

		default:
			break;
		}
	}
}
