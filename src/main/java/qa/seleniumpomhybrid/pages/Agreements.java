package qa.seleniumpomhybrid.pages;

import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.seleniumpomhybrid.utils.MyFunctions;

public class Agreements {

	WebDriver driver;
	MyFunctions functions;

	public Agreements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		functions = new MyFunctions(driver);
	}

	@FindBy(xpath = "//button[.='Add New']")
	private WebElement addNewAgreementButton;

	@FindBy(xpath = "//button[.='Agreement']")
	private WebElement agreementTab;

	@FindBy(xpath = "//table//tr")
	private List<WebElement> listOfAgreements;
	
	@FindBy(xpath = ".//td[3]//button[position()=1]")
	private WebElement editButton;

	public AddNewAgreementPage clickAddAgreementButton() {
		functions.clickElement(addNewAgreementButton);
		return new AddNewAgreementPage(driver);
	}

	public Agreements clickAgreementTab() {
		functions.clickElement(agreementTab);
		return this;
	}

	public void clickEditAgreementButton(String name){
		for (int i = 2; i < listOfAgreements.size(); i++) {
			String actualAgreementName = driver.findElement(By.xpath("//table//td["+i+"]")).getText();
			if (actualAgreementName.equals(name)) {
				System.out.println("Done");
			}
		}
	}
}
