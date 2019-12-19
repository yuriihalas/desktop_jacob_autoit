package com.epam.desktop;

import static com.epam.utils.DesktopKeys.ENTER;

public class WindowsInteraction extends AbstractInteraction {
    private static final String SEARCH_IN_WINDOWS_BASIC_WINDOW_INFO = "[CLASS:Shell_TrayWnd]";
    private static final String SEARCH_IN_WINDOWS_CLASSNAME_NN = "TrayButton1";

    public void findInWindowsSomethingAndPressEnter(String something) {
        autoItX.controlClick(SEARCH_IN_WINDOWS_BASIC_WINDOW_INFO, "", SEARCH_IN_WINDOWS_CLASSNAME_NN);
        autoItX.send(something);
        autoItX.send(ENTER, false);
    }
}
