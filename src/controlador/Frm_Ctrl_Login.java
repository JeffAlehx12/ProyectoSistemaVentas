
package controlador;

import com.raven.main.Main;
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
    // Verificar si los campos de usuario y contraseña no están vacíos
    if (!vista.txt_usuario.getText().isEmpty() && !vista.txt_password.getText().isEmpty()) {

        // Crear el objeto Usuario con las credenciales ingresadas
        Usuario usuario = new Usuario();
        usuario.setUsuario(vista.txt_usuario.getText().trim());
        usuario.setPassword(vista.txt_password.getText().trim());

        // Verificar si las credenciales son correctas
        if (loginUser(usuario)) {

            // Obtener el rol del usuario desde la base de datos
            String rolSeleccionado = obtenerRolUsuario(usuario);

            // Crear la ventana del menú y el controlador
            Main menu = new Main();
            
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
    String sql = "SELECT idUsuario, usuario, password, nombre, apellido FROM tb_usuario WHERE usuario = ? AND password = ?";

    try (PreparedStatement pst = cn.prepareStatement(sql)) {
        pst.setString(1, objeto.getUsuario());
        pst.setString(2, objeto.getPassword());

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            respuesta = true;

            // Obtener los datos del usuario
            int idUsuario = rs.getInt("idUsuario");
            String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");

            // Registrar la sesión del usuario en la tabla tb_sesion_usuario
            String registrarSesionSQL = "INSERT INTO tb_sesion_usuario (idUsuario) VALUES (?)";
            try (PreparedStatement pst2 = cn.prepareStatement(registrarSesionSQL)) {
                pst2.setInt(1, idUsuario);  // Guardamos el idUsuario en la tabla de sesiones
                pst2.executeUpdate();
                System.out.println("Usuario logueado registrado correctamente en la tabla de sesiones.");
            } catch (SQLException e) {
                System.out.println("Error al registrar el usuario logueado en la tabla de sesiones: " + e.getMessage());
            }

            // Opcionalmente, puedes devolver el nombre completo del usuario o cualquier otro dato
            System.out.println("Usuario logueado: " + nombreCompleto);
        }
    } catch (SQLException e) {
        System.out.println("Error al Iniciar Sesion");
        JOptionPane.showMessageDialog(null, "Error al Iniciar Sesion");
    }
    return respuesta;
}
   public void verificarUsuarioLogueado() {
    Connection cn = Conexion.conectar();
    String sql = "SELECT @usuario_logueado";

    try (PreparedStatement pst = cn.prepareStatement(sql)) {
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            String usuarioLogueado = rs.getString(1);
            System.out.println("Usuario Logueado: " + usuarioLogueado);
        }
    } catch (SQLException e) {
        System.out.println("Error al verificar usuario logueado");
    }
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
    

