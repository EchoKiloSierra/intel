package com.github.echokilosierra.intel.login;

import com.github.echokilosierra.intel.app.Application_Main;

public class ProcessLgn 
{
    private static final Application_Main app = new Application_Main();

    protected final void callLoginProcess(String username, String password)
    {
     if(!verifyCredentials(username, password)){
        
     } else {   
        LoginDialog.closeLogin();
        app.run();
     }

    }
    
    private final boolean verifyCredentials(String usn, String pswd)
    {
        //TODO: ADD Database connectivity

        if(usn.equals("USER") && pswd.equals("ROOT")){
            return true;
        }
        else {
            return false;
        }
    }

}
