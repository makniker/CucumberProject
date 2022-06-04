package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"steps"},
        plugin = {"pretty"},
        publish = true,
        dryRun = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunTest {
}
