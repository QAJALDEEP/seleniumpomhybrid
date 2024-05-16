package qa.seleniumpomhybrid.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class MyFunctions {

	private WebDriver driver;
	private Actions actions;
	private WebDriverWait wait;

	public static final int IMPLICIT_WAIT = 10;
	public static final int ELEMENT_WAIT = 10;

	public static final int LOG_DEBUG = 1;
	public static final int LOG_INFO = 2;
	public static final int LOG_WARN = 3;
	public static final int LOG_ERROR = 4;
	public static final int LOG_FATAL = 5;

	public MyFunctions(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_WAIT));
		actions = new Actions(driver);
	}

	public WebElement waitForElementPresent(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void moveToElement(WebElement element) {
		waitForElementPresent(element);
		actions.moveToElement(element).perform();
	}

	public void enterInputIntoField(WebElement element, String value) {
		waitForElementPresent(element).sendKeys(value);
	}

	public void clickElement(WebElement element) {
		waitForElementPresent(element);
		waitForElementToBeClickable(element);
		element.click();
	}
	
	public void clickElementUsingJs(WebElement element) {
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", element);
	}

	public void pressTabKey() {
		actions.sendKeys(Keys.TAB).perform();
	}

	public void pressEnterKey() {
		actions.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * Captures a screenshot of the current browser window and saves it to a
	 * 'screenshots' folder within the project's root directory. This method is
	 * compatible across multiple operating systems.
	 *
	 * @param driver The WebDriver instance.
	 */
	public static void takeScreenshot(WebDriver driver) {
		// Format for the screenshot file name, including timestamp to avoid overwriting
		// files
		String timestamp = new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date());
		String fileName = "screenshot_" + timestamp + ".png";

		// Use File.separator to ensure the correct path separator is used for the OS
		String relativePath = "screenshots" + File.separator + fileName;

		// Get the project's root directory
		String rootPath = System.getProperty("user.dir");

		// Combine them to form the full file path
		String filePath = rootPath + File.separator + relativePath;

		// Take the screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Create the destination file object
		File destFile = new File(filePath);

		try {
			// Ensure the screenshots directory exists
			File screenshotDir = new File(rootPath + File.separator + "screenshots");
			if (!screenshotDir.exists()) {
				screenshotDir.mkdirs(); // Make the directory if it doesn't exist
			}

			// Copy the screenshot to the destination
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot saved: " + filePath);
		} catch (IOException e) {
			System.err.println("An error occurred while saving the screenshot: " + e.getMessage());
		}
	}
}
