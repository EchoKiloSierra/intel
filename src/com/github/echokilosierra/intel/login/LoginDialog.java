package com.github.echokilosierra.intel.login;

import com.github.echokilosierra.intel.util.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.*;
import java.awt.Font;

public class LoginDialog
{

    private final ProcessLgn login = new ProcessLgn();

    private static final JDialog login_d = new JDialog();

    private final Utility_util util = new Utility_util();

    public void callLoginFramework() 
    {
        this.config();
    }

    private void config() 
    {
        login_d.addWindowListener(new WindowAdapter() { 
            public void windowClosing(WindowEvent e) { 
              System.exit(0);
            }
        });
        login_d.setSize(util.getLoginPopupWidth(), util.getLoginPopupHeight());
        login_d.setLocation(util.getLoginPopupWidth()*2,util.getLoginPopupHeight()*2);
        login_d.setResizable(false);
        login_d.setAlwaysOnTop(true);
        login_d.setTitle("INSCOM Login");
        login_d.setLayout(null);
        login_d.setVisible(true);
        this.addDialogElements();
        this.confDialogElements();
    }

    Font font = new Font("Courier", Font. BOLD,12);
    JTextField un_ID = new JTextField("Username:");
    JTextField pw_ID = new JTextField("Password:");
    JTextField un = new JTextField();
    JPasswordField pw = new JPasswordField();
    JTextField[] loginFields = {un_ID, pw_ID, un};

    JButton login_btn = new JButton("Login");

    private void addDialogElements()
    {
        for(int i = 0; i < 3; i++) {
            login_d.add(loginFields[i]);
        }
        login_d.add(pw);
        login_d.add(login_btn);
    }

    private void confDialogElements()
    {
        un_ID.setLocation(login_d.getWidth() / 10, login_d.getHeight() / 5);
        un_ID.setSize(login_d.getWidth() / 4, login_d.getHeight() / 6);
        
        pw_ID.setLocation(login_d.getWidth() / 10, (int)un_ID.getLocation().getY() + un_ID.getHeight());
        pw_ID.setSize(un_ID.getSize());

        un.setLocation((int)un_ID.getLocation().getX() + un_ID.getWidth(),(int) un_ID.getLocation().getY());
        un.setSize(un_ID.getWidth() * 2, un_ID.getHeight());
        un.setLayout(null);
        un.setEditable(true);
        un.setVisible(true);

        pw.setLocation((int) un.getLocation().getX(),(int) un.getLocation().getY() + un.getHeight());
        pw.setSize(un.getSize());
        pw.setLayout(null);
        pw.setEditable(true);
        pw.setEchoChar('*');
        pw.setVisible(true);

        for(int i = 0; i < 2; i++) {
            loginFields[i].setHorizontalAlignment(SwingConstants.CENTER);
            loginFields[i].setHorizontalAlignment(SwingConstants.CENTER);
            loginFields[i].setEditable(false);
            loginFields[i].setFont(font);
        }

        login_btn.setLocation((int)pw.getLocation().getX() + pw.getWidth() / 4 ,(int)pw.getLocation().getY() + pw.getHeight());
        login_btn.setSize(pw.getWidth() / 2, pw.getHeight());
        login_btn.setText("Login");
        login_btn.setFocusable(false);
        login_btn.setVisible(true);
        login_btn.addActionListener(e -> login.callLoginProcess(getUserName(), getPassword()));
    }

    protected final String getUserName()
    {
        return un.getText();
    }

    protected final String getPassword() 
    {
        String pwCont = new String(pw.getPassword());
        return pwCont;
    }

    protected static final void closeLogin()
    {
        login_d.dispose();
    }
}
