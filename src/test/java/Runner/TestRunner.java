package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\sathishkumar\\eclipse-workspace\\Selenium8AMBDDCucumber\\Features\\SearchMakeMyTrip.feature",
glue="StepDefenition",monochrome=true,publish=true,tags="~SIT")
public class TestRunner {



}
