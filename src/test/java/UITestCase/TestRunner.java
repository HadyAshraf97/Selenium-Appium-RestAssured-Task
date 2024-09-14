package UITestCase;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/UITestCase/tests/LoginWithInValidData.feature",
        glue = {"UITestCase"},
        plugin = {"pretty"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}