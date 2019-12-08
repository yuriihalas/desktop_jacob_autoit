package com.epam.desktop;

import autoitx4java.AutoItX;
import com.epam.AutoItManager.AutoItManager;

public class AbstractInteraction {

    protected AutoItX autoItX;

    public AbstractInteraction() {
        autoItX = AutoItManager.getAutoItX();
    }
}
