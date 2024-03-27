package qa.seleniumpomhybrid.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import qa.seleniumpomhybrid.utils.FileUtils;

public class BaseTest {

	protected WebDriver driver;
	public Properties env;

	public BaseTest() {
		loadProperties();
	}

	public void launchBrowser() {
		String browserName = env.getProperty("browser");
		try {
			switch (browserName) {
			case "chrome":
				setUpChromeDriver();
				break;
			case "firefox":
				setUpFireFoxDriver();
				break;
			default:
				Reporter.log(browserName + " - Browser not setup.");
			}
			postBrowseDriverLaunch();
		} catch (Exception e) {
			Reporter.log("Error launching browser: " + e.getMessage());
		}
	}

	public void loadProperties() {
		try {
			env = loadPropertyFiles(FileUtils.getEnvPropertiesPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Properties loadPropertyFiles(String path) throws IOException {
		FileInputStream fi;
		Properties properties = new Properties();
		fi = new FileInputStream(path);
		properties.load(fi);
		return properties;
	}

	public void setUpChromeDriver() {
		driver = new ChromeDriver();
	}

	public void setUpFireFoxDriver() {
		driver = new FirefoxDriver();
	}

	public void postBrowseDriverLaunch() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(env.getProperty("devUrl"));
	}
}
