package com.epam.desktop;

import autoitx4java.AutoItX;

import static com.epam.utils.DesktopKeys.*;

public class NotepadInteraction extends AbstractInteraction {
    private static final String DEFAULT_NOTEPAD_LOCATION = "C:/Windows/System32/notepad.exe";
    private static final String NOTEPAD_BASIC_WINDOW_INFO = "[CLASS:Notepad]";
    private static final String NOTEPAD_TEXT_CLASSNAME_NN = "Edit1";
    private static final String SAVE_AS_BASIC_WINDOW_INFO = "[CLASS:#32770]";
    private static final String SAVE_AS_EDIT_FILENAME_CLASSNAME_NN = "Edit1";
    private static final String SAVE_AS_SET_LOCATION_CLASSNAME_NN = "ToolbarWindow324";

    public void openNotepad() {
        autoItX.run(DEFAULT_NOTEPAD_LOCATION, "", AutoItX.SW_MAXIMIZE);
    }

    public void waitUntilNotepadNotActivated() {
        autoItX.winActivate(NOTEPAD_BASIC_WINDOW_INFO);
        autoItX.winWaitActive(NOTEPAD_BASIC_WINDOW_INFO);
    }

    public void writeNote(String note) {
        autoItX.controlSend(NOTEPAD_BASIC_WINDOW_INFO, "", NOTEPAD_TEXT_CLASSNAME_NN, note);
    }

    public void setFilenameToSaveFile(String filename) {
        autoItX.ControlSetText(SAVE_AS_BASIC_WINDOW_INFO, "", SAVE_AS_EDIT_FILENAME_CLASSNAME_NN, filename);
        autoItX.controlClick(SAVE_AS_BASIC_WINDOW_INFO, "", SAVE_AS_EDIT_FILENAME_CLASSNAME_NN);
    }

    public void saveChanges() {
        autoItX.controlSend(SAVE_AS_BASIC_WINDOW_INFO, "", SAVE_AS_EDIT_FILENAME_CLASSNAME_NN, ENTER);
        if (autoItX.winExists(SAVE_AS_BASIC_WINDOW_INFO)) {
            autoItX.send(LEFT_ARROW, false);
            autoItX.send(ENTER, false);
        }
    }

    public void setLocationToSaveFile(String location) {
        autoItX.controlClick(SAVE_AS_BASIC_WINDOW_INFO, "", SAVE_AS_SET_LOCATION_CLASSNAME_NN, "", 1, 650, 5);
        autoItX.send(location);
    }

    public void openSaveAsWindow() {
        autoItX.controlSend(NOTEPAD_BASIC_WINDOW_INFO, "", "", CTRL_PLUS_S);
        autoItX.winWait(SAVE_AS_BASIC_WINDOW_INFO);
    }

    public void closeNotepad() {
        autoItX.winClose(NOTEPAD_BASIC_WINDOW_INFO);
    }

    public String getNotepadText() {
        return autoItX.controlGetText(NOTEPAD_BASIC_WINDOW_INFO, "", NOTEPAD_TEXT_CLASSNAME_NN);
    }
}
