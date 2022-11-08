package com.github.echokilosierra.intel.gui;

import javax.swing.JFrame;
import com.github.echokilosierra.intel.util.*;

public class GUI extends JFrame
{

    private final Utility_util util = new Utility_util();

    public final void setup()
    {
        this.setTitle("S2 - Intelligence and Security Command (INSCOM)");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(util.getScrnSize());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }    
}
