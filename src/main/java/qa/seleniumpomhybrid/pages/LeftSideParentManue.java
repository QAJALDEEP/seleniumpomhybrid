package qa.seleniumpomhybrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.seleniumpomhybrid.utils.MyFunctions;

public class LeftSideParentManue {

	WebDriver driver;
	MyFunctions functions;

	public LeftSideParentManue(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		functions = new MyFunctions(driver);
	}

	@FindBy(css = "a[href='/agreements']")
	WebElement agreementMenu;

	public Agreements clickAgreementMenu() {
		functions.clickElement(agreementMenu);
		return new Agreements(driver);
	}

}
