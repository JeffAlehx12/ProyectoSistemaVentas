
package controlador;

import com.raven.main.Main;
import conexion.*;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;


public class Frm_Ctrl_GestionarProveedores {
    
    InterGestionarProveedor vista;
    
    private int idProveedor;
    
    public Frm_Ctrl_GestionarProveedores() {
    
    }
    
    
    
    public Frm_Ctrl_GestionarProveedores(InterGestionarProveedor vista) {
        
        this.vista = vista;
        init();
        
    }
    
    
    
    private void init() {
        
        

        vista.setSize(new Dimension(1580, 850));
        vista.setTitle("Gestionar Proveedo");
        vista.setVisible(true);
        vista.setLocation(0,0);
        
        // Evitar que se pueda mover el JInternalFrame
        vista.setResizable(false);  // Deshabilita el redimensionamiento
        vista.setClosable(false);   // Deshabilita la opción de cerrar
        vista.setMaximizable(false); // Deshabilita la opción de maximizar
        vista.setIconifiable(false); // Deshabilita la opción de minimizar

        // Eliminar la barra de título y los botones de control (Cerrar, Minimizar, Maximizar)
        JInternalFrame jif = vista;
        ((BasicInternalFrameUI) jif.getUI()).setNorthPane(null); // Quita la barra de título

// Quitar el borde adicional alrededor del contenido
        jif.setBorder(BorderFactory.createEmptyBorder());  // Elimina el borde de todo el JInternalFrame

// Fuerza a que se dibuje correctamente el contenido
        jif.revalidate();
        jif.repaint();
        
        vista.toFront();
        
         //Cargar tabla
       
        CargarTablaProveedores();
        
        
        /*insertar imagen en nuestro JLabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo2.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        vista.jLabel_wallpaper.setIcon(icono);
        vista.repaint();
        */
        
         
        vista.jButton_Guardar.addActionListener(e -> jButton_GuardarActionPerformed(e));
        vista.jButton_editar.addActionListener(e -> jButton_editarActionPerformed(e));
        vista.jButton_eliminar.addActionListener(e -> jButton_eliminarActionPerformed(e));
        vista.jButton_Cancelar.addActionListener(e -> jButton_CancelarActionPerformed(e));
        vista.jbtnBuscarporDni.addActionListener(e -> jbtnBuscarporDniActionPerformed(e));
            
       
   
         
    }
    
   
    
    
   
    
    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {
        if (vista.jtxtRazonSocial.getText().isEmpty() || vista.jtxtIdentificacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completa todos los campos");
        } else {
            Proveedor proveedor = new Proveedor();
            

            // Determine if it's a new or updated record
            boolean isNewRecord = idProveedor == 0;

            proveedor.setRazonSocial(vista.jtxtRazonSocial.getText().trim());
            proveedor.setIdentificacion(vista.jtxtIdentificacion.getText().trim());
            proveedor.setNombre(vista.jtxtNombre.getText().trim());
            proveedor.setApellido(vista.jtxtApellido.getText().trim());
            proveedor.setProductos(vista.jtxtProductos.getText().trim());
            proveedor.setDireccion(vista.jtxtDireccion.getText().trim());
            proveedor.setTelefono(vista.jtxtTelefono.getText().trim());
            proveedor.setCorreo(vista.jtxtCorreo.getText().trim());
            proveedor.setEstado(obtenerEstado());

            if (isNewRecord) {
                // New record
                if (!existeProveedor(proveedor.getIdentificacion())) {
                    if (guardar(proveedor)) {
                        JOptionPane.showMessageDialog(null, "¡Proveedor Registrado!");
                        CargarTablaProveedores();
                        Limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Error al registrar Proveedor!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El Proveedor ya está registrado, ingrese otro.");
                }
            } else {
                // Updated record
                if (actualizar(proveedor, idProveedor)) {
                    JOptionPane.showMessageDialog(null, "¡Datos del proveedor actualizados!");
                    CargarTablaProveedores();
                    idProveedor=0;
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar los datos del proveedor");
                }
            }
        }
    }
    
    
    
     private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {                                                 
       
         
         Limpiar();
         
         vista.jtxtRazonSocial.requestFocus();
         
         
    }    
     
    

    private void jButton_editarActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = vista.jTable_proveedores.getSelectedRow();
        if (selectedRow != -1) {
            idProveedor = (int) vista.jTable_proveedores.getValueAt(selectedRow, 0);
            EnviarDatosProveedorSeleccionado(idProveedor);
        } else {
            System.out.println("No se ha seleccionado ningún proveedor.");
        }
    }

   

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {
    int selectedRow = vista.jTable_proveedores.getSelectedRow();
        if (selectedRow != -1) {
            idProveedor = (int) vista.jTable_proveedores.getValueAt(selectedRow, 0);

            // Mostrar cuadro de diálogo de confirmación
            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar el proveedor?", "Confirmación de eliminación", JOptionPane.YES_NO_OPTION);

            // Si el usuario selecciona "Sí"
            if (opcion == JOptionPane.YES_OPTION) {
                if (eliminar(idProveedor)) {
                    JOptionPane.showMessageDialog(null, "¡Proveedor Eliminado!");
                    CargarTablaProveedores();
                    Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "¡Proveedor esta siendo utilizado en algun producto!");
                    Limpiar();
                }
            } 
        } else {
            JOptionPane.showMessageDialog(null, "¡Seleccione un proveedor!");
        }
}

     private void jbtnBuscarporDniActionPerformed(java.awt.event.ActionEvent evt) { 
         
         String identificacion = vista.jtxtBusqueda.getText().trim();

    if (!identificacion.isEmpty()) {
        EnviarDatosProveedorSeleccionado2(identificacion);
    } else {
        System.out.println("Por favor ingrese una identificación.");
    }
         
         
    }
     
     private void EnviarDatosProveedorSeleccionado2(String identificacion) {
    DefaultTableModel model = (DefaultTableModel) InterGestionarProveedor.jTable_proveedores.getModel();
    for (int i = 0; i < model.getRowCount(); i++) {
        if (model.getValueAt(i, 2).equals(identificacion)) { // Asumiendo que la columna 2 contiene la identificación (Ruc/Dni)
            InterGestionarProveedor.jTable_proveedores.setRowSelectionInterval(i, i);
            InterGestionarProveedor.jTable_proveedores.scrollRectToVisible(new java.awt.Rectangle(InterGestionarProveedor.jTable_proveedores.getCellRect(i, 0, true)));
            return;
        }
    }
    System.out.println("Proveedor no encontrado.");
}
  
    
   
    
    private int obtenerEstado() {
        String estado = (String) vista.jComboBox_estado.getSelectedItem();
        if ("Activo".equals(estado)) {
            return 1;
        } else if ("Inactivo".equals(estado)) {
            return 0;
        }
        return -1; // Valor por defecto en caso de error
    }

    private void Limpiar() {
        vista.jtxtRazonSocial.setText("");
        vista.jtxtIdentificacion.setText("");
        vista.jtxtNombre.setText("");
        vista.jtxtApellido.setText("");
        vista.jtxtProductos.setText("");
        vista.jtxtDireccion.setText("");
        vista.jtxtTelefono.setText("");
        vista.jtxtCorreo.setText("");
        vista.jComboBox_estado.setSelectedIndex(0);
        idProveedor = 0;
    }

    public boolean guardar(Proveedor objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_proveedor values(?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getRazonSocial());
            consulta.setString(3, objeto.getIdentificacion());
            consulta.setString(4, objeto.getNombre());
            consulta.setString(5, objeto.getApellido());
            consulta.setString(6, objeto.getProductos());
            consulta.setString(7, objeto.getDireccion());
            consulta.setString(8, objeto.getTelefono());
            consulta.setString(9, objeto.getCorreo());
            consulta.setInt(10, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar proveedor: " + e);
        }
        return respuesta;
    }
    
    

    public boolean existeProveedor(String identificacion) {
        boolean respuesta = false;
        String sql = "select identificacion from tb_proveedor where identificacion = '" + identificacion + "';";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar proveedor: " + e);
        }
        return respuesta;
    }

    public boolean actualizar(Proveedor objeto, int idProveedor) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_proveedor set razonSocial=?, identificacion= ?, nombre=?, apellido=?, producto_ofrecido=?, direccion = ?, telefono= ?, correo = ?, estado = ? where idProveedor = ?");
            consulta.setString(1, objeto.getRazonSocial());
            consulta.setString(2, objeto.getIdentificacion());
            consulta.setString(3, objeto.getNombre());
            consulta.setString(4, objeto.getApellido());
            consulta.setString(5, objeto.getProductos());
            consulta.setString(6, objeto.getDireccion());
            consulta.setString(7, objeto.getTelefono());
            consulta.setString(8, objeto.getCorreo());
            consulta.setInt(9, objeto.getEstado());
            consulta.setInt(10, idProveedor);
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar proveedor: " + e);
        }
        return respuesta;
    }

    public boolean eliminar(int idProveedor) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("DELETE FROM tb_proveedor WHERE idProveedor = ?");
            pst.setInt(1, idProveedor);
            int rowsAffected = pst.executeUpdate();
            con.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar proveedor: " + e);
            return false;
        }
    }

    
    private void CargarTablaProveedores() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select * from tb_proveedor";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarProveedor.jTable_proveedores = new JTable(model);
            InterGestionarProveedor.jScrollPane1.setViewportView(InterGestionarProveedor.jTable_proveedores);
            
            model.addColumn("id");
            model.addColumn("Razon Social");
            model.addColumn("Ruc/Dni");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("producto_ofrecido");
            model.addColumn("direccion");
            model.addColumn("telefono");
            model.addColumn("correo");
            model.addColumn("estado");

            while (rs.next()) {
                Object fila[] = new Object[10];
                for (int i = 0; i < 10; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla clientes: " + e);
        }
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        
        
    }

    
    
    
    
        private void EnviarDatosProveedorSeleccionado(int idProveedor) {
            try {
                Connection con = Conexion.conectar();
                PreparedStatement pst = con.prepareStatement(
                        "select * from tb_proveedor where idProveedor = ?");
                pst.setInt(1, idProveedor);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    vista.jtxtRazonSocial.setText(rs.getString("razonSocial"));
                    vista.jtxtIdentificacion.setText(rs.getString("identificacion"));
                    vista.jtxtNombre.setText(rs.getString("nombre"));
                    vista.jtxtApellido.setText(rs.getString("apellido"));
                    vista.jtxtProductos.setText(rs.getString("producto_ofrecido"));
                    vista.jtxtDireccion.setText(rs.getString("direccion"));
                    vista.jtxtTelefono.setText(rs.getString("telefono"));
                    vista.jtxtCorreo.setText(rs.getString("correo"));

                    int estado = rs.getInt("estado");
                    if (estado == 0) {
                        vista.jComboBox_estado.setSelectedItem("Inactivo");
                    } else if (estado == 1) {
                        vista.jComboBox_estado.setSelectedItem("Activo");
                    }
                } else {
                    System.out.println("Proveedor no encontrado.");
                }
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al seleccionar proveedor: " + e);
            }
        }

    

    
 
    
}
