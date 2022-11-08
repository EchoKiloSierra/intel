package com.github.echokilosierra.intel.util;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Utility_util 
{
    
    private transient final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public final Dimension getScrnSize()
    {
        return screenSize;
    }

    public final int getLoginPopupHeight()
    {
         return (int)screenSize.getHeight() / 5;
    }

    public final int getLoginPopupWidth()
    {
        return (int)screenSize.getWidth() / 5;
    }
}
