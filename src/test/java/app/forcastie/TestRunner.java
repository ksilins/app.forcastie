package app.forcastie;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        features = {"src/test/resources/app.forcastie/features"},
        tags = {"@smoke"},
        strict = true
)

public class TestRunner {
}
