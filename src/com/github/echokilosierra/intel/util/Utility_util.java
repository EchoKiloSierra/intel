package com.github.echokilosierra.intel.util;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Utility_util 
{
    
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Dimension getScrnSize()
    {
        return screenSize;
    }

    public int getLoginPopupHeight()
    {
         return (int)screenSize.getHeight() / 5;
    }

    public int getLoginPopupWidth()
    {
        return (int)screenSize.getWidth() / 5;
    }
}
