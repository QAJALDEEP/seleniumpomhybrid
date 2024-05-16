package qa.seleniumpomhybrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.seleniumpomhybrid.utils.MyFunctions;

public class SignupPage {

	protected WebDriver driver;
	MyFunctions functions;

	@FindBy(css = "h1")
	private WebElement welcomeTextLabel;

	@FindBy(id = "first_name")
	private WebElement firstNameTextField;

	@FindBy(id = "last_name")
	private WebElement lastNameTextField;

	@FindBy(id = "email")
	private WebElement emailAddressTextField;

	@FindBy(id = "password")
	private WebElement passwordTextField;

	@FindBy(id = "confirmPassword")
	private WebElement confirmPasswordTextField;

	@FindBy(xpath = "//button[.='Sign Up']")
	private WebElement signUpButton;

	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SignupPage enterFirstName(String firstNameValue) {
		functions.enterInputIntoField(firstNameTextField, firstNameValue);
		return this;
	}

	public SignupPage enterLastName(String lastNameValue) {
		functions.enterInputIntoField(lastNameTextField, lastNameValue);
		return this;
	}

	public SignupPage enterEmail(String emailValue) {
		functions.enterInputIntoField(emailAddressTextField, emailValue);
		return this;
	}

	public SignupPage enterPassword(String passwordValue) {
		functions.enterInputIntoField(passwordTextField, passwordValue);
		return this;
	}

	public SignupPage enterConfirmPassword(String confirmPasswordValue) {
		functions.enterInputIntoField(confirmPasswordTextField, confirmPasswordValue);
		return this;
	}

	public void clickSignUpButon() {
		functions.clickElement(signUpButton);
	}

}
