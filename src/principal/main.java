
package principal;

import controlador.Frm_Ctrl_Login;
import vista.FromLogin;



public class main {

    public static void main(String[] args) {
     
        FromLogin login = new FromLogin();
        Frm_Ctrl_Login loginControl = new Frm_Ctrl_Login(login);
        login.setVisible(true);
       
        
    }

    
}
