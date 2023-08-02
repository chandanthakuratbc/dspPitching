package TestRunners;

import org.junit.runner.RunWith;

import com.qa.factory.DriverFactory;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures"},
		glue = {"stepdefinitions", "AppHooks"},monochrome = true,dryRun = false,tags = "@sp-01 or @ap-01 or @dp-01",
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"			
		}
		
		)
public class MyTestRunner extends DriverFactory{


}
