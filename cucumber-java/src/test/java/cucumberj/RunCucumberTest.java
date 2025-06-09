package cucumberj;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("cucumberj")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
    value = "pretty, json:target/cucumber-report.json, html:target/cucumber-report.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "cucumberj")
public class RunCucumberTest {
}
