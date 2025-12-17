package RunnerCucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features",
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-report.html"}


)
public class Runner extends AbstractTestNGCucumberTests {
}

