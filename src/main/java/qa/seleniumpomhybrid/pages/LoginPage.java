package qa.seleniumpomhybrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.seleniumpomhybrid.utils.MyFunctions;

public class LoginPage {

	protected WebDriver driver;
	MyFunctions functions;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		functions = new MyFunctions(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='email']")
	WebElement emailInputField;

	@FindBy(css = "input[name='password']")
	WebElement passwordInputField;

	@FindBy(css = "button[type='submit']")
	WebElement loginButton;

	@FindBy(css = "a[href='/signup']")
	WebElement signUpLink;

	@FindBy(css = "a[href='/forgot-password']")
	WebElement forgotPasswordLink;

	public LoginPage enterEmail(String email) {
		functions.enterInputIntoField(emailInputField, email);
		return this;
	}

	public LoginPage enterPassword(String password) {
		functions.enterInputIntoField(passwordInputField, password);
		return this;
	}

	public LoginPage clickLoginButton() {
		functions.waitForElementToBeClickable(loginButton).click();
		return this;
	}

	public DashboardPage doLogin(String email, String password) {
		enterEmail(email).enterPassword(password).clickLoginButton();
		return new DashboardPage(driver);
	}
	
	public SignupPage clickSignUpLink() {
		functions.clickElement(signUpLink);
		return new SignupPage(driver);
	}
}
