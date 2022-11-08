package com.github.echokilosierra.intel.login;


public class LoginDB_Con extends EncryptUserData
{
    protected final boolean requestVerify(String user, byte[] pswd)
    {
            String password = new String(decrypt(pswd));
            if(user.equals("USER") && password.equals("ROOT")){
                
                return true;
            } else {
                return false;
            }
    }
}
