package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	
	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browser, long implicitWait) {
		System.out.println("Browser valude is :" + browser);
		if (browser.equals("chrome")) {
			//WebDriverManager.chromedriver().driverVersion("104.0.5112.79").setup();
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser value. You have enterd the browerser as :" + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		return getDriver();
	}

	
	/**
	 * this is used to get the driver with ThreadLocal	 * 
	 * @return tlDriver
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
//	/**
//	 * take screenshot
//	 */
//	public static String getScreenshot(String methodName) {
//		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
//		//Users/chandanthakur/Documents/workspace1/
//		String path = System.getProperty("user.dir")+"/screenshot/" + methodName + ".png";
//		File destination = new File(path);
//		try {
//			FileUtils.copyFile(srcFile, destination);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return path;
//	}
}
