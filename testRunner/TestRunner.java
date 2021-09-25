import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

// Ejecutar con: mvn clean test
@RunWith(Cucumber.class)
@CucumberOptions(
        // add missing options here
        snippets = SnippetType.CAMELCASE
)
public class TestRunner {

}