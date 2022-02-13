package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * @author Sreej
 */

@CucumberOptions(features = "src/test/resources/features/Sample.feature", glue = "steps",
        plugin = {"json:src/test/resources/cucumberReport/cucumberReport.json", "listeners.BDDTestListener"})
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}