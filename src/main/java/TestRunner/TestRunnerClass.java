package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/main/java/Features",
        glue = {"StepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/Cucumber.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
        },
        monochrome = true
)
public class TestRunnerClass extends AbstractTestNGCucumberTests{

}