package com.BleuCRM.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue= "com/BleuCRM/step_definitions",
        features = "@target/rerun.txt",
        tags = "@LUE-1014"

)
public class FailedTestRunner {
}
