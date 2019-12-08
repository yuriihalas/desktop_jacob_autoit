package com.epam.AutoItManager;

import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;

import java.io.File;
import java.util.Objects;

public class AutoItManager {
    private static AutoItX autoItX;

    static {
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, new File("src/main/resources/jacob-1.16-x64.dll")
                .getAbsolutePath());
    }

    private AutoItManager() {
    }

    public static AutoItX getAutoItX() {
        if (Objects.isNull(autoItX)) {
            autoItX = new AutoItX();
        }
        return autoItX;
    }
}
