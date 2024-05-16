package qa.seleniumpomhybrid.agreements;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import qa.seleniumpomhybrid.base.BaseTest;
import qa.seleniumpomhybrid.pages.Agreements;
import qa.seleniumpomhybrid.pages.LeftSideParentManue;
import qa.seleniumpomhybrid.pages.LoginPage;

public class TestNavigateToAgreements extends BaseTest {
	LoginPage loginPage;
	LeftSideParentManue leftSideParentManue;
	SoftAssert softAssert;
	Agreements agreements;

	@BeforeClass
	public void doBeforeClass() {
		launchBrowser();
		softAssert = new SoftAssert();
		loginPage = new LoginPage(driver);
		leftSideParentManue = new LeftSideParentManue(driver);
		String ownerEmail = env.getProperty("ownerEmail");
		String ownerPassword = env.getProperty("ownerPassword");
		loginPage.doLogin(ownerEmail, ownerPassword);
	}

	@Test
	public void test_EditAgreementRecord() throws Exception{
		agreements = leftSideParentManue.clickAgreementMenu();
		agreements.clickEditAgreementButton("Service Agreement");
	}

}
