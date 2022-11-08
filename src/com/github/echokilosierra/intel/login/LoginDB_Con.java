package com.github.echokilosierra.intel.login;


class LoginDB_Con extends EncryptUserData
{
    private static transient String password = "";

    protected final boolean requestVerify(String user, byte[] pswd)
    {
            password = new String(decrypt(pswd));
            if(user.equals("USER") && password.equals("ROOT")){
                password = null;
                return true;
            } else {
                return false;
            }
    }
}
