package CambTranslator;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)                
@CucumberOptions(plugin = {"pretty", "html:target/Destination"},
tags="@ParameterizedTest",
features="/BDDCambridgeDictionary004/src/test/java/CambTranslator/CambTrans.feature",
glue="TranslatorGrammer",
monochrome=false, 
dryRun=true
)
public class CambTransRunner {

}
