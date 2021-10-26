package tests;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/features/mystore-test.feature",
        plugin = {"pretty", "html:target/reports.html"}
)

public class Zadanie1CucumberTest {
}
