package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static WebDriver initDriver(String browser,String gridURL,String env_execution,String os) throws MalformedURLException {


			MutableCapabilities options;

			switch (browser.toLowerCase()) {

			case "chrome":
				options = new ChromeOptions();
				break;

			case "edge":
				options = new EdgeOptions();
				break;

			case "firefox":
				options = new FirefoxOptions();
				break;

			default:
				throw new IllegalArgumentException("Browser not supported: " + browser);
			}

			if (env_execution.equalsIgnoreCase("remote")) {

				if (os != null && !os.isEmpty()) {
					options.setCapability("platformName", os);
				}

				tlDriver.set(new RemoteWebDriver(new URL(gridURL), options));

			} else if (env_execution.equalsIgnoreCase("local")) {

				switch (browser.toLowerCase()) {
				case "chrome":
					tlDriver.set(new ChromeDriver((ChromeOptions) options));
					break;
				case "edge":
					tlDriver.set(new EdgeDriver((EdgeOptions) options));
					break;
				case "firefox":
					tlDriver.set(new FirefoxDriver((FirefoxOptions) options));
					break;
				}

			} else {
				throw new IllegalArgumentException("Environment execution value is wrong");
			}

			return getDriver();
		}

		

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void quitDriver() {
		getDriver().quit();
		tlDriver.remove();
	}
}