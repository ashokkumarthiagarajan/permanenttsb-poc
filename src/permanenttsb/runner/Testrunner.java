package permanenttsb.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


public class Testrunner {
	

	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/permanenttsb/feature"
			,glue={"src.permanenttsb.steps"},tags = {"@booking"}
			)

	public class TestRunner {

	}

}
