package webServiceTesting;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/webservice",
        tags = {"@TC002, @TC003, @TC004"}
)

public class WebServiceTestRunner {
}
