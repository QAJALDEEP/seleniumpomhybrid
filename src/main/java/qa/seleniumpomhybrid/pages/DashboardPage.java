package qa.seleniumpomhybrid.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.seleniumpomhybrid.utils.MyFunctions;

public class DashboardPage {

	protected WebDriver driver;
	MyFunctions functions;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		functions = new MyFunctions(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".welcome-text.font-medium")
	WebElement welcomeLabel;

	public boolean isWelComeLabelDisplayed() {
		return functions.waitForElementPresent(welcomeLabel).isDisplayed();
	}
}
