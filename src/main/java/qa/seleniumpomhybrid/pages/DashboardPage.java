package qa.seleniumpomhybrid.pages;

import java.util.List;

import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.NoSuchElementException;
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

	@FindBy(xpath = "//button[@aria-haspopup='dialog' and @class='h-6 w-6']")
	WebElement clockInOutButton;

	@FindBy(xpath = "//button[contains(@class,'items-start flex justify-between gap-3  md:gap-5 w-full py-2 hover:bg-light rounded-lg px-2 text-sm font-light')]")
	List<WebElement> staffList;

	@FindBy(xpath = "//p[@class='text-xl  md:text-2xl text-text_2']")
	WebElement staffName;

	public boolean isWelComeLabelDisplayed() {
		return functions.waitForElementPresent(welcomeLabel).isDisplayed();
	}

	public DashboardPage clickOnClockInOutButton() throws InterruptedException {
		Thread.sleep(3000);
		functions.clickElement(clockInOutButton);
		return this;
	}

	public DashboardPage clickStaffMemeber(String staffMemberName) {
		for (WebElement staff : staffList) {
			if (staffMemberName.equalsIgnoreCase(staff.getText())) {
				functions.clickElement(staff);
				return this; // Found and clicked, now return.
			}
		}

		// If we get here, it means the staff member wasn't found.
		// Log the info and return this DashboardPage object without clicking anything.
		System.out.println("Staff member with name '" + staffMemberName + "' not found.");
		// Alternatively, you can handle any other logic you want here.

		return this;
	}

}