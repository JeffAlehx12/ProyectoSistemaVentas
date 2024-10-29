
package controlador;

import conexion.Conexion;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import modelo.Usuario;
import vista.FromLogin;
import vista.FromMenu;



public class Frm_Ctrl_Login {

     private final FromLogin vista;
     public static JDesktopPane jDesktopPane_menu;

    public Frm_Ctrl_Login(FromLogin vista) {
        
        this.vista = vista;
        this.vista.setResizable(false);
        this.vista.setLocationRelativeTo(null);
        this.vista.setTitle("Login - SISTEMA DE VENTAS");
        this.vista.setSize(new Dimension(700, 500));
        this.vista.jButton_IniciarSesion.addActionListener(e -> jButton_IniciarSesionActionPerformed(e));

        // Agregar KeyListener para txt_usuario
        this.vista.txt_usuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    
                    vista.txt_password.requestFocus();
                    
                }
            }
        });
        
        
        // Agregar KeyListener para txt_password
        this.vista.txt_password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton_IniciarSesionActionPerformed(null);
                }
            }
        });
    }

    

    private void jButton_IniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {
        
        
        if (!vista.txt_usuario.getText().isEmpty() && !vista.txt_password.getText().isEmpty()) {
       
            Usuario usuario = new Usuario();
            usuario.setUsuario(vista.txt_usuario.getText().trim());
            usuario.setPassword(vista.txt_password.getText().trim());

            if (loginUser(usuario)) {
                
                FromMenu menu = new FromMenu();
                FrmPrincipal_Ctrl_Menu ctrlMenu = new FrmPrincipal_Ctrl_Menu(menu);
                menu.setVisible(true);


                // Obtener el rol del usuario desde la base de datos
                String rolSeleccionado = obtenerRolUsuario(usuario);

                // Comparar el valor seleccionado
                if (rolSeleccionado != null && rolSeleccionado.equalsIgnoreCase("Usuario")) {
                    // Lógica para el caso cuando el rol es "Usuario"
                    // Aquí puedes deshabilitar el botón específico
                    menu.getjMenuItem_gestionar_usuarios().setEnabled(false);
                   
                    menu.getjMenuItem_gestionar_producto().setEnabled(false); 
                    
                    menu.setTitle("Sistema de Venta - USUARIO");
                    
                } else if (rolSeleccionado != null && rolSeleccionado.equalsIgnoreCase("Admin")) {
                    // Lógica para el caso cuando el rol es "Admin"
                    // Habilitar los botones si es necesario
                    menu.getjMenuItem_gestionar_usuarios().setEnabled(true);
                    
                    menu.setTitle("Sistema de Venta - ADMIN");
                }

                // Mostrar el menú
                menu.setVisible(true);

                // Cerrar la vista de inicio de sesión
                vista.dispose();
            } else {
                JOptionPane.showMessageDialog(vista, "Usuario o Clave Incorrectos");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Ingrese sus credenciales");
        }
    }
    
    
    public boolean loginUser(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        String sql = "select  usuario, password from tb_usuario where usuario = '" + objeto.getUsuario() + "' and password = '" + objeto.getPassword() + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al Iniciar Sesion");
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesion");
        }
        return respuesta;
    }
    

   public String obtenerRolUsuario(Usuario objeto) {
    String rol = null;
    Connection cn = Conexion.conectar();
    String sql = "SELECT rol FROM tb_usuario WHERE usuario = ? AND password = ?;";
    PreparedStatement pst;
    try {
        pst = cn.prepareStatement(sql);
        pst.setString(1, objeto.getUsuario());
        pst.setString(2, objeto.getPassword());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            rol = rs.getString("rol");
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener el rol del usuario");
        JOptionPane.showMessageDialog(null, "Error al obtener el rol del usuario");
    }
    return rol;
}

}
    

