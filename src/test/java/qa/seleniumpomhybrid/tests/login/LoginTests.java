package qa.seleniumpomhybrid.tests.login;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import qa.seleniumpomhybrid.base.BaseTest;
import qa.seleniumpomhybrid.pages.DashboardPage;
import qa.seleniumpomhybrid.pages.LoginPage;

public class LoginTests extends BaseTest {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	SoftAssert softAssert;

	@BeforeTest
	public void doBeforeClass() {
		launchBrowser();
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}

	@Test
	public void doTestOne() {
		String ownerEmail = env.getProperty("ownerEmail");
		String ownerPassword = env.getProperty("ownerPassword");
		dashboardPage = loginPage.doLogin(ownerEmail, ownerPassword);
		softAssert.assertTrue(dashboardPage.isWelComeLabelDisplayed());
		softAssert.assertAll();
	}

}
