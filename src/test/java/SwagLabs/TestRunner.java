package SwagLabs;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue={"SwagLabs"},monochrome = true,plugin = {"pretty","html:target/HtmlReports"}, tags = "@SmokeTest")
public class TestRunner {
}
