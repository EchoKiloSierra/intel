import com.github.echokilosierra.intel.login.LoginDialog;

public class Main extends LoginDialog
{
    private static transient final LoginDialog lgin = new LoginDialog();

    public static void main(String[] args)
    {
        lgin.callLoginFramework();
    }

}
