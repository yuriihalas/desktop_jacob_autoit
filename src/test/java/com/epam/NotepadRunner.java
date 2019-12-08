package com.epam;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/notepad.feature",
        glue = {"src/main/java/com/epam/MyStepDefs"
        })
public class NotepadRunner {
}
