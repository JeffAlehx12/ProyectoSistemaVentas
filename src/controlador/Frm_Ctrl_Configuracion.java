
package controlador;

import conexion.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

public class Frm_Ctrl_Configuracion {

    InterConfiguracion vista;
    

    public Frm_Ctrl_Configuracion() {
        
    }
    
    
     
    public Frm_Ctrl_Configuracion(InterConfiguracion vista) {
        this.vista=vista;
        init();
    }
    
   
    
    private void init(){

        vista.setSize(new Dimension(440, 307));
        vista.setTitle("Informacion de la Empresa");
        vista.setVisible(true);
        vista.setLocation(750,50);
        FromMenu.desktopPane.add(vista);
    
        vista.toFront();
        
        cargarConfiguracion();
      
    
    
        
        vista.jButton_Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton_GuardarActionPerformed(e);
            }
        });

        
    }

    
    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {
    
     Configuracion config = new Configuracion(
            vista.jtxt_ruc.getText().trim(),
            vista.jtxt_nombre.getText().trim(),
            vista.jtxt_telefono.getText().trim(),
            vista.jtxt_direccion.getText().trim(),
            vista.jtxt_razon.getText().trim()
        );

        if (validarCampos(config)) {
            if (guardarConfiguracion(config)) {
                JOptionPane.showMessageDialog(null, "Configuración guardada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                setCamposColor(Color.GREEN);
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar la configuración", "Error", JOptionPane.ERROR_MESSAGE);
                setCamposColor(Color.RED);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Completa todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            setCamposColor(Color.RED);
        }
    }
   
    
    
    
        private void cargarConfiguracion() {
        Configuracion config = obtenerConfiguracion();
        if (config != null) {
            vista.jtxt_ruc.setText(config.getRuc());
            vista.jtxt_nombre.setText(config.getNombre());
            vista.jtxt_telefono.setText(config.getTelefono());
            vista.jtxt_direccion.setText(config.getDireccion());
            vista.jtxt_razon.setText(config.getRazon());
        } else {
            
          
        }
    }
        
        
         private boolean validarCampos(Configuracion config) {
        return !config.getRuc().isEmpty() && !config.getNombre().isEmpty() && !config.getTelefono().isEmpty() && !config.getDireccion().isEmpty() && !config.getRazon().isEmpty();
    }
         
         private void setCamposColor(Color color) {
        vista.jtxt_ruc.setBackground(color);
        vista.jtxt_nombre.setBackground(color);
        vista.jtxt_telefono.setBackground(color);
        vista.jtxt_direccion.setBackground(color);
        vista.jtxt_razon.setBackground(color);
    }

   

    public Configuracion obtenerConfiguracion() {
        Connection cn = Conexion.conectar();
        Configuracion config = null;

        try {
            PreparedStatement consulta = cn.prepareStatement("SELECT * FROM Configuracion ORDER BY id DESC LIMIT 1");
            ResultSet rs = consulta.executeQuery();
            if (rs.next()) {
                config = new Configuracion(
                    rs.getString("ruc"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("razon")
                );
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener configuración: " + e);
        }

        return config;
    }

    public boolean guardarConfiguracion(Configuracion config) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {
            // Si no hay configuración, insertar una nueva
            if (obtenerConfiguracion() == null) {
                PreparedStatement consulta = cn.prepareStatement(
                    "INSERT INTO Configuracion (id, ruc, nombre, telefono, direccion, razon) VALUES (1, ?, ?, ?, ?, ?)"
                );
                consulta.setString(1, config.getRuc());
                consulta.setString(2, config.getNombre());
                consulta.setString(3, config.getTelefono());
                consulta.setString(4, config.getDireccion());
                consulta.setString(5, config.getRazon());
                if (consulta.executeUpdate() > 0) {
                    respuesta = true;
                }
            } else {
                // Si hay configuración, actualizar la existente
                PreparedStatement consulta = cn.prepareStatement(
                    "UPDATE Configuracion SET ruc = ?, nombre = ?, telefono = ?, direccion = ?, razon = ? WHERE id = 1"
                );
                consulta.setString(1, config.getRuc());
                consulta.setString(2, config.getNombre());
                consulta.setString(3, config.getTelefono());
                consulta.setString(4, config.getDireccion());
                consulta.setString(5, config.getRazon());
                if (consulta.executeUpdate() > 0) {
                    respuesta = true;
                }
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar configuración: " + e);
        }

        return respuesta;
    }


}
