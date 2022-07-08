package CambDict;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(plugin = {"pretty", "junit:target/cucumber-reports/cucumber.xml"},
tags="@ParameterizedTest",
features="/BDDCambridgeDictionary004/src/test/java/CambDict/CambDict.feature",
glue="Dictionary",
monochrome=false, 
dryRun=true
)

//html:target/Destination
//json:target/cucumber-reports/cucumber.json
public class CambDictRunner {

}
