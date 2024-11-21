package com.ssmu.security.runner;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;



// @Suite
// @IncludeEngines("cucumber")
// @SelectPackages("src/test/java/com/ssmu/security")
// @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")



// @RunWith(CucumberWithSerenity.class)

// @CucumberOptions(
//         features = "src/test/resources/features",
//         glue = "com.ssmu.security.definitions"
//         // snippets = CucumberOptions.SnippetType.CAMELCASE
// )

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.ssmu.security")
public class RunCucumberTest {
    
}
