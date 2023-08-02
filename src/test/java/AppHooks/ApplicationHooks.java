package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 0)
	public void getproperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order =1)
	public void lauchBrowser() {
		String browserName = prop.getProperty("browser");
		long implcitWait = Integer.parseInt(prop.getProperty("implicitWait"));
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName, implcitWait);  //We are giving life to driver
	}
	
	@After(order=0)
	public void quitBrowser() {
		//driver.quit();		//we are closing driver
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}
}
