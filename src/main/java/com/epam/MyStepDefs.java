package com.epam;

import com.epam.desktop.NotepadInteraction;
import com.epam.desktop.WindowsInteraction;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class MyStepDefs {
    private NotepadInteraction notepad = new NotepadInteraction();
    private WindowsInteraction windows = new WindowsInteraction();

    @When("^I open notepad$")
    public void iOpenNotepad() {
        notepad.openNotepad();
        notepad.waitUntilNotepadNotActivated();
    }

    @And("^I write \"([^\"]*)\" to notepad$")
    public void iWriteToNotepad(String message) {
        notepad.writeNote(message);
    }

    @Then("^I click save as button$")
    public void iClickSaveAsButton() {
        notepad.openSaveAsWindow();
    }

    @And("^I set location: \"([^\"]*)\" to saving file$")
    public void iSetLocationToSavingFile(String location) {
        notepad.setLocationToSaveFile(location);
    }

    @And("^I set filename: \"([^\"]*)\"$")
    public void iSetFilename(String filename) {
        notepad.setFilenameToSaveFile(filename);
    }

    @And("^I save changes and close notepad$")
    public void iSaveChangesAndCloseNotepad() {
        notepad.saveChanges();
        notepad.closeNotepad();
    }

    @And("^I finding in windows my new created file \"([^\"]*)\"$")
    public void iFindingInWindowsMyNewCreatedFile(String filename) {
        windows.findInWindowsSomethingAndPressEnter(filename);
    }

    @Then("^text in notepad must to be \"([^\"]*)\"$")
    public void textInNotepadMustToBe(String message) {
        Assert.assertEquals(notepad.getNotepadText(), message);
    }
}
