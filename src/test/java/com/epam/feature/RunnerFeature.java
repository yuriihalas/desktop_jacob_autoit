package com.epam.feature;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/epam/feature/notepad.feature",
        glue = {"com.epam.stepdef"
        })
public class RunnerFeature {
}