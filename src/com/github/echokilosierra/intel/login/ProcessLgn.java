package com.github.echokilosierra.intel.login;

import com.github.echokilosierra.intel.app.Application_Main;

public class ProcessLgn extends LoginDB_Con
{
    private static transient final Application_Main app = new Application_Main();

    private transient static final LoginDB_Con db = new LoginDB_Con();

    protected final void callLoginProcess(String username, byte[] password)
    {
     if(!db.requestVerify(username, password)){
        LoginDialog.closeLogin();
     } else {   
        LoginDialog.closeLogin();
        app.run();
     }
    }

}
