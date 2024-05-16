package qa.seleniumpomhybrid.tests.SignUp;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qa.seleniumpomhybrid.base.BaseTest;
import qa.seleniumpomhybrid.pages.LoginPage;
import qa.seleniumpomhybrid.pages.SignupPage;

public class SignUpTest extends BaseTest {
	
	LoginPage loginPage;
	SignupPage signupPage;
	
	@BeforeTest
	public void doBeforeTest() {
		launchBrowser();
		loginPage = new LoginPage(driver);
		signupPage = loginPage.clickSignUpLink();
	}
	
	@Test
	public void test_signUpWithValidLoginDetails() {
		System.out.println("I am on sign up page. Thank You!");
	}
}
