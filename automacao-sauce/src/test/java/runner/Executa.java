package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources",
		glue = "tests",
		tags = "@featLogin",
		plugin = {"pretty", "html:target/report.html"}, 
		dryRun = false, 
		monochrome = true

		
		)

public class Executa {

}
